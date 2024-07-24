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

    public ReverseCharCount(
            Map<Character, Integer> pCharacterCounts,
            Comparator<Integer> pCharCountComparator,
            Comparator<Character> pCharComparator)
    {
        initializeContent(pCharacterCounts, pCharCountComparator, pCharComparator);
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

    private void initializeContent(
            Map<Character, Integer> pCharacterCounts,
            Comparator<Integer> pCharCountComparator,
            Comparator<Character> pCharComparator)
    {
        if (_countsToChar == null)
        {
            _countsToChar = new TreeMap<>(pCharCountComparator);
        }
        else
        {
            _countsToChar.clear();
        }

        for (Character someChar : pCharacterCounts.keySet())
        {
            int nbOccurrences = pCharacterCounts.get(someChar);
            Set<Character> charsOfSameFrequency = _countsToChar.computeIfAbsent(
                    nbOccurrences, _ -> new TreeSet<>(pCharComparator));

            charsOfSameFrequency.add(someChar);
        }
    }
}
