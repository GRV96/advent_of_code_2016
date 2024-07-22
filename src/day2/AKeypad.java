package src.day2;

public abstract class AKeypad
{
    // i: rows, up to bottom
    // j: columns, left to right
    protected char[][] _keys;

    protected int _upperIndexBound;
    protected int _rowIndex;
    protected int _columnIndex;

    protected abstract boolean isColumnIndexWithinBounds(int pColumnIndex);
    protected abstract boolean isRowIndexWithinBounds(int pRowIndex);

    protected AKeypad()
    {
        resetPosition();
    }

    public char getKey()
    {
        return _keys[_rowIndex][_columnIndex];
    }

    protected boolean isIndexWithinBounds(int pIndex)
    {
        return pIndex >= 0 && pIndex <= _upperIndexBound;
    }

    public boolean moveColumnIndex(int pDelta)
    {
        int updatedColumnIndex = _columnIndex + pDelta;
        boolean isIndexWithinBounds = isColumnIndexWithinBounds(updatedColumnIndex);

        if(isIndexWithinBounds)
        {
            _columnIndex = updatedColumnIndex;
        }

        return isIndexWithinBounds;
    }

    public boolean moveRowIndex(int pDelta)
    {
        int updatedRowIndex = _rowIndex + pDelta;
        boolean isIndexWithinBounds = isRowIndexWithinBounds(updatedRowIndex);

        if(isIndexWithinBounds)
        {
            _rowIndex = updatedRowIndex;
        }

        return isIndexWithinBounds;
    }

    public abstract void resetPosition();
}
