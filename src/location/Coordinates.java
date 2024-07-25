package src.location;

public class Coordinates
{
    private static final String COMMA_SPACE = ", ";
    private static final String PARENTHESIS_OPEN = "(";
    private static final String PARENTHESIS_CLOSED = ")";

    public final int x;
    public final int y;

    public Coordinates(int pX, int pY)
    {
        x = pX;
        y = pY;
    }

    @Override
    public boolean equals(Object pObject)
    {
        if(!(pObject instanceof Coordinates other))
        {
            return false;
        }

        return x == other.x && y == other.y;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 87 * hash + x;
        hash = 97 * hash + y;
        return hash;
    }

    @Override
    public String toString()
    {
        return PARENTHESIS_OPEN + x + COMMA_SPACE + y + PARENTHESIS_CLOSED;
    }

    public int calculateManhattanDistance()
    {
        return Math.abs(x) + Math.abs(y);
    }

    public Coordinates move(int pDeltaX, int pDeltaY)
    {
        return new Coordinates(x + pDeltaX, y + pDeltaY);
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
        return new Coordinates(x + pDeltaX, y);
    }

    public Coordinates moveY(int pDeltaY)
    {
        return new Coordinates(x, y + pDeltaY);
    }
}
