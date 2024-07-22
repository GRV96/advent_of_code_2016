package src.day2;

public class Keypad
{
    private static final int UPPER_INDEX_BOUND = 2;

    // i: rows, up to bottom
    // j: columns, left to right
    private static final int[][] KEYS = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    private int _rowIndex;
    private int _columnIndex;

    public Keypad()
    {
        resetPosition();
    }

    public int getKey()
    {
        return KEYS[_rowIndex][_columnIndex];
    }

    private static boolean isIndexWithinBounds(int pRowIndex)
    {
        return pRowIndex >= 0 && pRowIndex <= UPPER_INDEX_BOUND;
    }

    public boolean moveColumnIndex(int pDelta)
    {
        int updatedColumnIndex = _columnIndex + pDelta;
        boolean isIndexWithinBounds = isIndexWithinBounds((updatedColumnIndex));

        if(isIndexWithinBounds)
        {
            _columnIndex = updatedColumnIndex;
        }

        return isIndexWithinBounds;
    }

    public boolean moveRowIndex(int pDelta)
    {
        int updatedRowIndex = _rowIndex + pDelta;
        boolean isIndexWithinBounds = isIndexWithinBounds((updatedRowIndex));

        if(isIndexWithinBounds)
        {
            _rowIndex = updatedRowIndex;
        }

        return isIndexWithinBounds;
    }

    public void resetPosition()
    {
        _rowIndex = 1;
        _columnIndex = 1;
    }
}
