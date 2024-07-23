package src.day4;

import src.day4.char_count.CharacterCounter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day4
{
    private static final char DASH = '-';
    private static final char OPENING_BRACKET = '[';

    private static final int CHECKSUM_LENGTH = 5;

    private static boolean isRoomCodeLegit(RoomCode pRoomCode)
    {
        CharacterCounter charCounter = new CharacterCounter();
        String roomName = pRoomCode.name;
        int nameLength = roomName.length();
        for (int i=0; i<nameLength; i++)
        {
            char currentChar = roomName.charAt(i);

            if (Character.isAlphabetic(currentChar))
            {
                charCounter.registerCharacter(currentChar);
            }
        }
        char[] descFreqSortedChars = charCounter.getCharsSortedByDescCount();

        String generatedChecksum
                = new String(descFreqSortedChars).substring(0, CHECKSUM_LENGTH);
        return generatedChecksum.equals(pRoomCode.checksum);
    }

    public static void main(String[] pArgs) throws IOException
    {
        String inputPath = pArgs[0];
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));

        int sectorIdSum = 0;
        String inputLine;
        while ((inputLine = reader.readLine()) != null)
        {
            RoomCode roomCode = makeRoomCode(inputLine);

            if (isRoomCodeLegit(roomCode))
            {
                sectorIdSum += roomCode.sectorId;
            }
        }

        System.out.println("Puzzle 1: " + sectorIdSum);
    }

    private static RoomCode makeRoomCode(String pPuzzleLine)
    {
        int lastDashIndex = pPuzzleLine.lastIndexOf(DASH);
        int sectorIdStartIndex = lastDashIndex + 1;
        int openingBracketIndex = pPuzzleLine.indexOf(OPENING_BRACKET);

        String name = pPuzzleLine.substring(0, lastDashIndex);
        String sectorId = pPuzzleLine.substring(sectorIdStartIndex, openingBracketIndex);
        String checksum = pPuzzleLine.substring(openingBracketIndex+1, pPuzzleLine.length()-1);

        return new RoomCode(name, Integer.parseInt(sectorId), checksum);
    }
}
