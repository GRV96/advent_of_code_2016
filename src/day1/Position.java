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

    public int calculateManhattanDistance()
    {
        return _x + _y;
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
        _orientation = Direction.turnFromCarDir(_orientation, pRelDir);

        switch (_orientation)
        {
            case NORTH -> _y += pDistance;
            case EAST -> _x += pDistance;
            case SOUTH -> _y -= pDistance;
            case WEST -> _x -= pDistance;
        }
    }
}
