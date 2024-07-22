package src.day2;

public class SquareKeypad extends AKeypad
{
    public SquareKeypad()
    {
        super();
        _upperIndexBound = 2;
        _keys = new char[][]{{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
    }

    @Override
    protected boolean isColumnIndexWithinBounds(int pColumnIndex)
    {
        return isIndexWithinBounds(pColumnIndex);
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
