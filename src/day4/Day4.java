package src.day4;

import src.day4.char_count.CharacterCounter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day4
{
    private static final char DASH = '-';
    private static final char OPENING_BRACKET = '[';
    private static final char SPACE = ' ';

    private static final int CHECKSUM_LENGTH = 5;

    private static final String EMPTY_STR = "";
    private static final String NORTH = "north";
    private static final String NEW_LINE_TAB = "\n\t";


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
        CeasarDecrypter decrypter = new CeasarDecrypter();
        List<String> suspectNames = new ArrayList<>();
        String inputLine;
        while ((inputLine = reader.readLine()) != null)
        {
            RoomCode roomCode = makeRoomCode(inputLine);

            if (isRoomCodeLegit(roomCode))
            {
                sectorIdSum += roomCode.sectorId;
            }

            String decryptedName = decrypter.decryptMessage(
                    roomCode.name.replace(DASH, SPACE), roomCode.sectorId);

            if (decryptedName.contains(NORTH))
            {
                suspectNames.add(roomCode.sectorId + " (" + decryptedName + ")");
            }
        }

        System.out.println("Puzzle 1: " + sectorIdSum);
        System.out.println("Puzzle 2: " + makePuzzle2Output(suspectNames));
    }

    private static String makePuzzle2Output(List<String> pSuspectNames)
    {
        return switch (pSuspectNames.size())
        {
            case 0 -> EMPTY_STR;
            case 1 -> pSuspectNames.getFirst();
            default -> NEW_LINE_TAB + String.join(NEW_LINE_TAB, pSuspectNames);
        };
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
