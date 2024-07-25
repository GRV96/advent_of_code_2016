package src.day7;

import java.util.ArrayList;
import java.util.List;

class AddressBreakdown
{
    private final List<String> _hypernetSequences;
    private final List<String> _supernetSequences;

    public AddressBreakdown()
    {
        _hypernetSequences = new ArrayList<>();
        _supernetSequences = new ArrayList<>();
    }

    public void addHypernetSequence(String pHypernetSequence)
    {
        if (pHypernetSequence != null)
        {
            _hypernetSequences.add(pHypernetSequence);
        }
    }

    public void addSupernetSequence(String pSupernetSequence)
    {
        if (pSupernetSequence != null)
        {
            _supernetSequences.add(pSupernetSequence);
        }
    }

    public List<AbaPattern> getAbaPatternsFromHypernetSeqs()
    {
        return getAbaPatternsFromSequences(_hypernetSequences);
    }

    private static List<AbaPattern> getAbaPatternsFromSequences(List<String> pSequences)
    {
        List<AbaPattern> abaPatterns = new ArrayList<>();

        for (String sequence : pSequences)
        {
            abaPatterns.addAll(PatternDetection.detectAbaPatterns(sequence));
        }

        return abaPatterns;
    }

    public List<AbaPattern> getAbaPatternsFromSupernetSeqs()
    {
        return getAbaPatternsFromSequences(_supernetSequences);
    }

    public boolean hypernetSeqsContainAbba()
    {
        return sequencesContainAbba(_hypernetSequences);
    }

    private static boolean sequencesContainAbba(List<String> pSequences)
    {
        for (String sequence : pSequences)
        {
            if (PatternDetection.containsAbbaPattern(sequence))
            {
                return true;
            }
        }

        return false;
    }

    public boolean supernetSequencesContainAbba()
    {
        return sequencesContainAbba(_supernetSequences);
    }
}
