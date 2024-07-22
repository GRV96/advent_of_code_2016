package src.day2;

public class DiamondKeypad extends AKeypad
{
    private static final int UPPER_INDEX_BOUND = 5;

    @Override
    protected boolean isColumnIndexWithinBounds(int pColumnIndex)
    {
        return false;
    }

    @Override
    protected boolean isRowIndexWithinBounds(int pRowIndex)
    {
        return false;
    }

    public DiamondKeypad()
    {
        super();
    }

    @Override
    public void resetPosition()
    {
        _rowIndex = 2;
        _columnIndex = 0;
    }
}
