package src.day1;

public class Coordinates
{
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
        if(pObject == null)
        {
            return false;
        }

        Coordinates other = (Coordinates) pObject;
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

    public Coordinates move(int pDeltaX, int pDeltaY)
    {
        return new Coordinates(_x + pDeltaX, _y + pDeltaY);
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
