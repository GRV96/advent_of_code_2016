package src.day7;

import java.util.ArrayList;
import java.util.List;

class PatternDetection
{
    private static final int ABBA_PATTERN_LENGTH = 4;

    private static final char OPENING_BRACKET = '[';
    private static final char CLOSING_BRACKET = ']';

    public static AddressBreakdown breakdownAddress(String pAddress)
    {
        int openingBracketIndex = -1;
        int closingBracketIndex = -1;
        AddressBreakdown addressBreakdown = new AddressBreakdown();

        int i = 0;
        boolean bracketsFound = true;
        while (bracketsFound)
        {
            openingBracketIndex = pAddress.indexOf(OPENING_BRACKET, i);
            closingBracketIndex = pAddress.indexOf(CLOSING_BRACKET, i);
            bracketsFound = openingBracketIndex > 0 && closingBracketIndex > 0;

            String supernetSequence = null;
            String hypernetSequence = null;
            if (bracketsFound)
            {
                supernetSequence = pAddress.substring(i, openingBracketIndex);
                hypernetSequence = pAddress.substring(openingBracketIndex + 1, closingBracketIndex);
            }
            else
            {
                supernetSequence = pAddress.substring(i);
            }
            addressBreakdown.addSupernetSequence(supernetSequence);
            addressBreakdown.addHypernetSequence(hypernetSequence);

            i = closingBracketIndex + 1;
        }

        return addressBreakdown;
    }

    public static boolean containsAbbaPattern(String pSomeString)
    {
        int indexBound = pSomeString.length() - ABBA_PATTERN_LENGTH;

        for (int i=0; i<=indexBound; i++)
        {
            if (detectAbbaPatternAtIndex(pSomeString, i))
            {
                return true;
            }
        }

        return false;
    }

    public static List<AbaPattern> detectAbaPatterns(String pSomeString)
    {
        List<AbaPattern> abaPatterns = new ArrayList<>();
        int indexBound = pSomeString.length() - AbaPattern.ABA_PATTERN_LENGTH;

        for (int i=0; i<=indexBound; i++)
        {
            AbaPattern abaPattern = AbaPattern.make(
                    pSomeString.substring(i, i + AbaPattern.ABA_PATTERN_LENGTH));

            if (abaPattern != null)
            {
                abaPatterns.add(abaPattern);
            }
        }

        return abaPatterns;
    }

    private static boolean detectAbbaPatternAtIndex(String pSomeString, int pStartIndex)
    {
        int stringLength = pSomeString.length();
        int endIndex = pStartIndex + ABBA_PATTERN_LENGTH - 1;
        boolean abbaPatternDetected = false;

        if (endIndex < stringLength)
        {
            char firstChar = pSomeString.charAt(pStartIndex);
            char secondChar = pSomeString.charAt(pStartIndex+1);
            abbaPatternDetected =
                    firstChar != secondChar
                    && firstChar == pSomeString.charAt(endIndex)
                    && secondChar == pSomeString.charAt(endIndex-1);
        }

        return abbaPatternDetected;
    }
}
