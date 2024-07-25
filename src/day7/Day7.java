package src.day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day7
{
    private static final int ABBA_INDEX_DIFF = 3;

    private static final char OPENING_BRACKET = '[';
    private static final char CLOSING_BRACKET = ']';

    private static boolean addressSupportsTls(String pAddress)
    {
        boolean abbaOutOfBrackets = false;

        boolean betweenBrackets = false;
        int addressLength = pAddress.length();
        for (int i=0; i<addressLength; i++)
        {
            AbbaDetectionResult detectionResult = detectAbbaPattern(pAddress, i);

            if (detectionResult.closingBracketIndex >= 0)
            {
                betweenBrackets = false;
            }
            else if (detectionResult.openingBracketIndex >= 0)
            {
                betweenBrackets = true;
            }

            if (detectionResult.containsAbbaPattern)
            {
                if (betweenBrackets)
                {
                    return false;
                }
                else
                {
                    abbaOutOfBrackets = true;
                    i += ABBA_INDEX_DIFF;
                }
            }
        }

        return  abbaOutOfBrackets;
    }

    private static AbbaDetectionResult detectAbbaPattern(String pSomeString, int pStartIndex)
    {
        int stringLength = pSomeString.length();
        int endIndex = pStartIndex + ABBA_INDEX_DIFF;
        boolean isAbbaPattern = false;

        if (endIndex < stringLength)
        {
            char firstChar = pSomeString.charAt(pStartIndex);
            char secondChar = pSomeString.charAt(pStartIndex+1);
            isAbbaPattern =
                    firstChar != secondChar
                    && firstChar == pSomeString.charAt(endIndex)
                    && secondChar == pSomeString.charAt(endIndex-1);
        }
        else
        {
            endIndex = stringLength - 1;
        }

        int openingBracketIndex = -1;
        int closingBracketIndex = -1;
        for (int i=pStartIndex; i<=endIndex; i++)
        {
            switch (pSomeString.charAt(i))
            {
                case OPENING_BRACKET -> openingBracketIndex = i;
                case CLOSING_BRACKET -> closingBracketIndex = i;
            }
        }

        return new AbbaDetectionResult(isAbbaPattern, openingBracketIndex, closingBracketIndex);
    }

    public static void main(String[] pArgs) throws IOException
    {
        String inputPath = pArgs[0];
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));

        int nbAddressesSupportTls = 0;
        String inputLine;
        while ((inputLine = reader.readLine()) != null)
        {
            inputLine = inputLine.trim();

            if (addressSupportsTls(inputLine))
            {
                nbAddressesSupportTls++;
            }
        }

        System.out.println("Puzzle 1: " + nbAddressesSupportTls);
    }
}
