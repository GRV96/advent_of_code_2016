package src.day1;

public class Coordinates
{
    private static final String COMMA_SPACE = ", ";
    private static final String PARENTHESIS_OPEN = "(";
    private static final String PARENTHESIS_CLOSED = ")";

    private int _x;
    private int _y;

    public Coordinates(int pX, int pY)
    {
        _x = pX;
        _y = pY;
    }

    public Coordinates(Coordinates pOther)
    {
        _x = pOther._x;
        _y = pOther._y;
    }

    @Override
    public boolean equals(Object pObject)
    {
        if(!(pObject instanceof Coordinates other))
        {
            return false;
        }

        boolean areEqual = _x == other._x && _y == other._y;
        return areEqual;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 87 * hash + _x;
        hash = 97 * hash + _y;
        return hash;
    }

    @Override
    public String toString()
    {
        return PARENTHESIS_OPEN + _x + COMMA_SPACE + _y + PARENTHESIS_CLOSED;
    }

    public int calculateManhattanDistance()
    {
        return Math.abs(_x) + Math.abs(_y);
    }

    public int getX()
    {
        return _x;
    }

    public int getY()
    {
        return _y;
    }

    public Coordinates move(int pDeltaX, int pDeltaY)
    {
        return new Coordinates(_x + pDeltaX, _y + pDeltaY);
    }

    public Coordinates move(Direction.CardinalDir pCardinalDir, int pDistance)
    {
        return
                switch (pCardinalDir)
                {
                    case NORTH -> moveY(pDistance);
                    case EAST -> moveX(pDistance);
                    case SOUTH -> moveY(-pDistance);
                    case WEST -> moveX(-pDistance);
                };
    }

    public Coordinates moveX(int pDeltaX)
    {
        return new Coordinates(_x + pDeltaX, _y);
    }

    public Coordinates moveY(int pDeltaY)
    {
        return new Coordinates(_x, _y + pDeltaY);
    }
}
