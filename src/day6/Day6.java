package src.day6;

import src.char_count.CharacterCounter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Day6
{
    private static <T> T computeIfIndexAbsent(
            List<T> pSomeList, int pIndex, Supplier<T> pInitFunction)
    {
        T itemToGet = null;

        if (pIndex < 0 || pIndex >= pSomeList.size())
        {
            itemToGet = pInitFunction.get();
            pSomeList.add(itemToGet);
        }
        else
        {
            itemToGet = pSomeList.get(pIndex);
        }

        return itemToGet;
    }

    public static void main(String[] pArgs) throws IOException
    {
        String inputPath = pArgs[0];
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));

        List<CharacterCounter> characterCounters = new ArrayList<>();
        String inputLine;
        while ((inputLine = reader.readLine()) != null)
        {
            int inputLength = inputLine.length();
            for (int i=0; i<inputLength; i++)
            {
                CharacterCounter characterCounter = computeIfIndexAbsent(
                        characterCounters, i, CharacterCounter::new);
                characterCounter.registerCharacter(inputLine.charAt(i));
            }
        }

        char[] messageChars = new char[characterCounters.size()];
        int messageIndex = 0;
        for (CharacterCounter charCounter : characterCounters)
        {
            char[] lettersDescFreqOrder = charCounter.getCharsSortedByDescCount();
            messageChars[messageIndex] = lettersDescFreqOrder[0];
            messageIndex++;
        }

        System.out.println("Puzzle 1: " + new String(messageChars));
    }
}
