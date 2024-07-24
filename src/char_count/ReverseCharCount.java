package src.char_count;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.TreeMap;

class ReverseCharCount
{
    Map<Integer, Set<Character>> _countsToChar;

    public ReverseCharCount(Map<Character, Integer> pCharacterCounts)
    {
        initializeContent(pCharacterCounts);
    }

    public List<Character> getCharsSortedByDescCount()
    {
        List<Character> sortedCharacters = new ArrayList<>();

        for (Integer nbOccurrences : _countsToChar.keySet())
        {
            sortedCharacters.addAll(_countsToChar.get(nbOccurrences));
        }

        return sortedCharacters;
    }

    private void initializeContent(Map<Character, Integer> pCharacterCounts)
    {
        if (_countsToChar == null)
        {
            _countsToChar = new TreeMap<>(Comparator.reverseOrder());
        }
        else
        {
            _countsToChar.clear();
        }

        for (Character someChar : pCharacterCounts.keySet())
        {
            int nbOccurrences = pCharacterCounts.get(someChar);
            Set<Character> charsOfSameFrequency = _countsToChar.computeIfAbsent(
                    nbOccurrences, _ -> new TreeSet<>());

            charsOfSameFrequency.add(someChar);
        }
    }
}
