package src.day1;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.Set;

class Day1
{
    private static final char LEFT = 'L';
    private static final char RIGHT = 'R';

    public static void main(String[] pArgs)
    {
        String inputPath = pArgs[0];
        String inputLine = readPuzzleData(inputPath);

        String[] instructions = inputLine.split(", *");
        Situation situation = new Situation(0, 0, Direction.CardinalDir.NORTH);
        Coordinates firstCoordsVisitedTwice = null;
        Set<Coordinates> coordinateSet = new LinkedHashSet<>();
        coordinateSet.add(new Coordinates(situation.getCoordinates()));

        for(String instruction : instructions)
        {
            char relDir = instruction.charAt(0);
            int distance = Integer.parseInt(instruction.substring(1));
            Set<Coordinates> coordLine = move(situation, relDir, distance);

            if(firstCoordsVisitedTwice == null)
            {
                for (Coordinates coordinates : coordLine)
                {
                    if(!coordinateSet.add(coordinates))
                    {
                        firstCoordsVisitedTwice = coordinates;
                        break;
                    }
                }
            }
        }

        int manhattanDistancePuzzle1 = situation.calculateManhattanDistance();
        int manhattanDistancePuzzle2 =
                firstCoordsVisitedTwice == null ? -1 : firstCoordsVisitedTwice.calculateManhattanDistance();

        System.out.println("Puzzle 1: " + manhattanDistancePuzzle1);
        System.out.println("Puzzle 2: " + manhattanDistancePuzzle2);
    }

    private static Set<Coordinates> makeLineOfCoords(
            Coordinates pStart, Direction.CardinalDir pCardinalDir, int pDistance)
    {
        // The set will not include pStart.
        Set<Coordinates> line = new LinkedHashSet<>();

        for(int i=1; i<=pDistance; i++)
        {
            Coordinates nextCoordinates = pStart.move(pCardinalDir, i);
            line.add(nextCoordinates);
        }

        return line;
    }

    private static Set<Coordinates> move(Situation pSituation, char pRelDir, int pDistance)
    {
        Direction.RelativeDir relativeDir = pRelDir == LEFT ?
                Direction.RelativeDir.LEFT: Direction.RelativeDir.RIGHT;

        Coordinates startCoordinates = pSituation.getCoordinates();
        pSituation.move(relativeDir, pDistance);

        return makeLineOfCoords(startCoordinates, pSituation.getOrientation(), pDistance);
    }

    private static String readPuzzleData(String pPuzzlePath)
    {
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(pPuzzlePath));
            return reader.readLine();
        }
        catch (FileNotFoundException fnfe)
        {
            System.err.println("File not found:\n" + pPuzzlePath);
            return null;
        }
        catch (IOException ioe)
        {
            System.err.println("An I/O error occurred.");
            return null;
        }
    }
}
