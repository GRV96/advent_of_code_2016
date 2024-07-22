package src.day2;

public class DiamondKeypad extends AKeypad
{
    private static final char NULL_CHAR = '\0';

    public DiamondKeypad()
    {
        super();
        _upperIndexBound = 5;
        _keys = new char[][]
                {{'\0', '\0', '1', '\0', '\0'},
                {'\0', '2', '3', '4', '\0'},
                {'5', '6', '7', '7', '9'},
                {'\0', 'A', 'B', 'C', '\0'},
                {'\0', '\0', 'D', '\0', '\0'}};
    }

    @Override
    protected boolean isColumnIndexWithinBounds(int pColumnIndex)
    {
        return isIndexWithinBounds(pColumnIndex)
                && _keys[_rowIndex][pColumnIndex] != NULL_CHAR;
    }

    @Override
    protected boolean isRowIndexWithinBounds(int pRowIndex)
    {
        return isIndexWithinBounds(pRowIndex) &&
                _keys[pRowIndex][_columnIndex] != NULL_CHAR;
    }

    @Override
    public void resetPosition()
    {
        _rowIndex = 2;
        _columnIndex = 0;
    }
}
