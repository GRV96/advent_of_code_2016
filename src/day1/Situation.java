package src.day1;

class Situation
{
    private Coordinates _coordinates;
    private Direction.CardinalDir _orientation;

    public Situation(int pX, int pY, Direction.CardinalDir pOrientation)
    {
        _coordinates = new Coordinates(pX, pY);
        _orientation = pOrientation;
    }

    public Situation(Situation pOther)
    {
        _coordinates = new Coordinates(pOther._coordinates);
        _orientation = pOther._orientation;
    }

    public int calculateManhattanDistance()
    {
        return _coordinates.calculateManhattanDistance();
    }

    public Coordinates getCoordinates()
    {
        return _coordinates;
    }

    public Direction.CardinalDir getOrientation()
    {
        return _orientation;
    }

    public void move(Direction.RelativeDir pRelDir, int pDistance)
    {
        _orientation = Direction.turnFromCardinalDir(_orientation, pRelDir);
        _coordinates = _coordinates.move(_orientation, pDistance);
    }
}
