package src.day2;

public class SquareKeypad extends AKeypad
{
    private static final int UPPER_INDEX_BOUND = 2;

    // i: rows, up to bottom
    // j: columns, left to right
    private static final char[][] KEYS = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};

    public SquareKeypad()
    {
        super();
    }

    public char getKey()
    {
        return KEYS[_rowIndex][_columnIndex];
    }

    @Override
    protected boolean isColumnIndexWithinBounds(int pColumnIndex)
    {
        return isIndexWithinBounds(pColumnIndex);
    }

    private static boolean isIndexWithinBounds(int pRowIndex)
    {
        return pRowIndex >= 0 && pRowIndex <= UPPER_INDEX_BOUND;
    }

    @Override
    protected boolean isRowIndexWithinBounds(int pRowIndex)
    {
        return isIndexWithinBounds(pRowIndex);
    }

    @Override
    public void resetPosition()
    {
        _rowIndex = 1;
        _columnIndex = 1;
    }
}
