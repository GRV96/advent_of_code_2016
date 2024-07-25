package src.location;

public class Direction
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

    public static CardinalDir turnFromCardinalDir(CardinalDir pCardinalDir, RelativeDir pRelDir)
    {
        CardinalDir newDirection = pCardinalDir;

        switch (pCardinalDir)
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
