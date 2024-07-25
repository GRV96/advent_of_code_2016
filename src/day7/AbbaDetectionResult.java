package src.day7;

class AbbaDetectionResult
{
    public final boolean containsAbbaPattern;
    public final int openingBracketIndex;
    public final int closingBracketIndex;

    public AbbaDetectionResult(
            boolean pContainsAbbaPattern, int pOpeningBracketIndex, int pClosingBracketIndex)
    {
        containsAbbaPattern = pContainsAbbaPattern;
        openingBracketIndex = pOpeningBracketIndex;
        closingBracketIndex = pClosingBracketIndex;
    }
}
