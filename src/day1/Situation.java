package src.day1;

import src.location.Coordinates;
import src.location.Direction;

class Situation
{
    private static final String ARROW = " -> ";

    private Coordinates _coordinates;
    private Direction.CardinalDir _orientation;

    public Situation(int pX, int pY, Direction.CardinalDir pOrientation)
    {
        _coordinates = new Coordinates(pX, pY);
        _orientation = pOrientation;
    }

    @Override
    public String toString()
    {
        return _coordinates.toString() + ARROW + _orientation;
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
