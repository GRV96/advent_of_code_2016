package src.char_count;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharacterCounter
{
    Map<Character, Integer> _characterCounts;

    public CharacterCounter()
    {
        _characterCounts = new HashMap<>();
    }

    public int getCharacterCount(char pSomeCharacter)
    {
        Integer nbOccurrences = _characterCounts.get(pSomeCharacter);
        return nbOccurrences == null ? 0 : nbOccurrences;
    }

    public void registerCharacter(char pSomeCharacter)
    {
        int nbOccurrences = getCharacterCount(pSomeCharacter);
        _characterCounts.put(pSomeCharacter, nbOccurrences + 1);
    }

    public char[] sortCharactersByCount(boolean pAscendingOrder)
    {
        Comparator<Integer> charCountComparator;
        Comparator<Character> charComparator;
        if (pAscendingOrder)
        {
            charCountComparator = Comparator.naturalOrder();
            charComparator = Comparator.naturalOrder();
        }
        else
        {
            charCountComparator = Comparator.reverseOrder();
            charComparator = Comparator.reverseOrder();
        }

        ReverseCharCount rcc = new ReverseCharCount(
                _characterCounts, charCountComparator, charComparator);
        List<Character> sortedCharacters = rcc.getCharsSortedByDescCount();
        int nbCharacters = sortedCharacters.size();
        char[] retVal = new char[nbCharacters];

        for (int i=0; i<nbCharacters; i++)
        {
            retVal[i] = sortedCharacters.get(i);
        }

        return retVal;
    }
}
