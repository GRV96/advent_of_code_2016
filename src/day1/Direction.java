package src.day1;

class Direction
{
    public enum CardinalDir
    {
        NORTH,
        EAST,
        SOUTH,
        WEST
    }

    public enum RelativeDir
    {
        LEFT,
        RIGHT
    }

    public static CardinalDir turnFromCarDir(CardinalDir pCarDir, RelativeDir pRelDir)
    {
        CardinalDir newDirection = pCarDir;

        switch (pCarDir)
        {
            case NORTH ->
            {
                switch (pRelDir)
                {
                    case LEFT -> newDirection = CardinalDir.WEST;
                    case RIGHT -> newDirection = CardinalDir.EAST;
                }
            }
            case EAST ->
            {
                switch (pRelDir)
                {
                    case LEFT -> newDirection = CardinalDir.NORTH;
                    case RIGHT -> newDirection = CardinalDir.SOUTH;
                }
            }
            case SOUTH ->
            {
                switch (pRelDir)
                {
                    case LEFT -> newDirection = CardinalDir.EAST;
                    case RIGHT -> newDirection = CardinalDir.WEST;
                }
            }
            case WEST ->
            {
                switch (pRelDir)
                {
                    case LEFT -> newDirection = CardinalDir.SOUTH;
                    case RIGHT -> newDirection = CardinalDir.NORTH;
                }
            }
        }

        return newDirection;
    }
}
