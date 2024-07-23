package src.day4;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

    public char[] sortCharsByDescCount()
    {
        int sortedCharsIndex = 0;
        char[] sortedCharacters = new char[_characterCounts.size()];

        Map<Character, Integer> contentCopy = new HashMap<>(_characterCounts);

        while (!contentCopy.isEmpty())
        {
            Set<Character> keys = contentCopy.keySet();
            int maxOccurrenceCount = Integer.MIN_VALUE;
            Character mostFrequentChar = '\0';

            for (Character character : keys)
            {
                int occurrenceCount = contentCopy.get(character);

                if (occurrenceCount > maxOccurrenceCount)
                {
                    maxOccurrenceCount = occurrenceCount;
                    mostFrequentChar = character;
                }
            }

            sortedCharacters[sortedCharsIndex] = mostFrequentChar;
            sortedCharsIndex++;
            contentCopy.remove(mostFrequentChar);
        }

        return sortedCharacters;
    }
}
