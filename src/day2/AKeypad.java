package src.day2;

public abstract class AKeypad
{
    protected int _rowIndex;
    protected int _columnIndex;

    protected abstract boolean isColumnIndexWithinBounds(int pColumnIndex);
    protected abstract boolean isRowIndexWithinBounds(int pRowIndex);

    protected AKeypad()
    {
        resetPosition();
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
