package src.char_count;

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

    public char[] getCharsSortedByDescCount()
    {
        ReverseCharCount rcc = new ReverseCharCount(_characterCounts);
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
