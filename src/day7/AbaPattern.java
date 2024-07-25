package src.day7;

class AbaPattern
{
    public static final int ABA_PATTERN_LENGTH = 3;

    private String _content;

    private AbaPattern(String pContent)
    {
        _content = pContent;
    }

    @Override
    public boolean equals(Object object)
    {
        if (!(object instanceof AbaPattern other))
        {
            return false;
        }

        return _content.equals(other._content);
    }

    @Override
    public int hashCode()
    {
        return _content.hashCode();
    }

    public boolean isBabTo(String pSomeString)
    {
        if (pSomeString.length() != ABA_PATTERN_LENGTH)
        {
            return false;
        }

        char middle = _content.charAt(1);
        char otherMiddle = pSomeString.charAt(1);

        return _content.charAt(0) == otherMiddle && _content.charAt(2) == otherMiddle
                && pSomeString.charAt(0) == middle && pSomeString.charAt(2) == middle;
    }

    public boolean isBabTo(AbaPattern pOther)
    {
        return isBabTo(pOther._content);
    }

    public static AbaPattern make(String pSomeString)
    {
        if (pSomeString.length() != ABA_PATTERN_LENGTH)
        {
            return null;
        }

        AbaPattern abaPattern = null;

        char firstChar = pSomeString.charAt(0);
        if (pSomeString.charAt(1) != firstChar && pSomeString.charAt(2) == firstChar)
        {
            abaPattern = new AbaPattern(pSomeString);
        }

        return abaPattern;
    }
}
