package src.day1;

class Position
{
    private int _x;
    private int _y;

    private Direction.CardinalDir _orientation;

    public Position(int pX, int pY, Direction.CardinalDir pOrientation)
    {
        _x = pX;
        _y = pY;
        _orientation = pOrientation;
    }

    public Position(Position pOther)
    {
        _x = pOther._x;
        _y = pOther._y;
        _orientation = pOther._orientation;
    }

    @Override
    public boolean equals(Object pObject)
    {
        if(pObject == null)
        {
            return false;
        }

        /*
         * For the purpose of knowing if
         * a position has been visited more than once,
         * this method ignores the orientation.
         */
        Position other = (Position) pObject;
        return _x == other._x && _y == other._y;
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

    public void move(Direction.RelativeDir pRelDir, int pDistance)
    {
        _orientation = Direction.turnFromCardinalDir(_orientation, pRelDir);

        switch (_orientation)
        {
            case NORTH -> _y += pDistance;
            case EAST -> _x += pDistance;
            case SOUTH -> _y -= pDistance;
            case WEST -> _x -= pDistance;
        }
    }
}
