package src.day8;

class Screen
{
    private static final String PIXEL_ON = "#";
    private static final String PIXEL_OFF = ".";
    private static final String PIXEL_SEPARATOR = " ";

    public final int nbColumns;
    public final int nbRows;

    // True: state is on.
    // False: state is off.
    private final boolean[][] _pixels;

    public Screen(int pNbColumns, int pNbRows)
    {
        if (pNbColumns < 1 || pNbRows < 1)
        {
            throw new IllegalArgumentException(
                    "The number of rows and columns must be at least 1.");
        }

        nbColumns = pNbColumns;
        nbRows = pNbRows;
        _pixels = new boolean[nbColumns][nbRows];
    }

    public boolean areIndicesValid(int pColumnIndex, int pRowIndex)
    {
        return isColumnIndexValid(pColumnIndex) && isRowIndexValid(pRowIndex);
    }

    public int countPixelsOn()
    {
        int nbPixelsOn = 0;

        for (int i=0; i<nbColumns; i++)
        {
            for (int j=0; j<nbRows; j++)
            {
                if (_pixels[i][j])
                {
                    nbPixelsOn++;
                }
            }
        }

        return nbPixelsOn;
    }

    public boolean getPixelState(int pColumnIndex, int pRowIndex)
    {
        return _pixels[pColumnIndex][pRowIndex];
    }

    public String getPixelStateMark(int pColumnIndex, int pRowIndex)
    {
        return _pixels[pColumnIndex][pRowIndex] ? PIXEL_ON : PIXEL_OFF;
    }

    public boolean isColumnIndexValid(int pColumnIndex)
    {
        return pColumnIndex >= 0 && pColumnIndex < nbColumns;
    }

    public boolean isRowIndexValid(int pRowIndex)
    {
        return pRowIndex >= 0 && pRowIndex < nbRows;
    }

    public void printPixels()
    {
        for (int j=0; j<nbRows; j++)
        {
            String rowToPrint = getPixelStateMark(0, j);

            for (int i=1; i<nbColumns; i++)
            {
                rowToPrint += PIXEL_SEPARATOR + getPixelStateMark(i, j);
            }

            System.out.println(rowToPrint);
        }
    }

    public boolean rotateColumn(int pColumnIndex, int pShift)
    {
        if (pShift <= 0 || !isColumnIndexValid(pColumnIndex))
        {
            return false;
        }

        boolean[] tmpMemory = new boolean[pShift];
        int tmpMemInitIndex = nbRows-pShift;
        for (int j=tmpMemInitIndex; j<nbRows; j++)
        {
            tmpMemory[j-tmpMemInitIndex] = _pixels[pColumnIndex][j];
        }

        for (int j=pShift; j<nbRows; j++)
        {
            _pixels[pColumnIndex][j] = _pixels[pColumnIndex][j-pShift];
        }

        for (int j=0; j<pShift; j++)
        {
            _pixels[pColumnIndex][j] = tmpMemory[j];
        }

        return true;
    }

    public boolean rotateRow(int pRowIndex, int pShift)
    {
        if (pShift <= 0 || !isRowIndexValid(pRowIndex))
        {
            return false;
        }

        boolean[] tmpMemory = new boolean[pShift];
        int tmpMemInitIndex = nbColumns-pShift;
        for (int i=tmpMemInitIndex; i<nbColumns; i++)
        {
            tmpMemory[i-tmpMemInitIndex] = _pixels[i][pRowIndex];
        }

        for (int i=pShift; i<nbColumns; i++)
        {
            _pixels[i][pRowIndex] = _pixels[i-pShift][pRowIndex];
        }

        for (int i=0; i<pShift; i++)
        {
            _pixels[i][pRowIndex] = tmpMemory[i];
        }

        return true;
    }

    public void setPixelState(int pColumnIndex, int pRowIndex, boolean pValue)
    {
        _pixels[pColumnIndex][pRowIndex] = pValue;
    }

    public void turnRectangleOn(int nbColumns, int nbRows)
    {
        for (int i=0; i<nbColumns; i++)
        {
            for (int j=0; j<nbRows; j++)
            {
                _pixels[i][j] = true;
            }
        }
    }
}
