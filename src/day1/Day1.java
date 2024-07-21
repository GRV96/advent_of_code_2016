package src.day1;

import java.io.*;
import java.util.HashSet;

class Day1
{
    private static final char LEFT = 'L';
    private static final char RIGHT = 'R';

    public static void main(String[] pArgs)
    {
        String inputPath = pArgs[0];
        String inputLine = readPuzzleData(inputPath);

        String[] instructions = inputLine.split(", *");
        Position position = new Position(0, 0, Direction.CardinalDir.NORTH);
        Position firstPosVisitedTwice = null;
        HashSet<Position> positionSet = new HashSet<>();
        positionSet.add(new Position(position));

        for(String instruction: instructions)
        {
            char relDir = instruction.charAt(0);
            int distance = Integer.parseInt(instruction.substring(1));
            movePosition(position, relDir, distance);

            Position positionCopy = new Position(position);
            if(firstPosVisitedTwice == null && !positionSet.add(positionCopy))
            {
                firstPosVisitedTwice = positionCopy;
            }
        }

        int manhattanDistancePuzzle1 = position.calculateManhattanDistance();
        int manhattanDistancePuzzle2 =
                firstPosVisitedTwice == null ? -1 : firstPosVisitedTwice.calculateManhattanDistance();
        System.out.println("Puzzle 1: " + manhattanDistancePuzzle1);
        System.out.println("Puzzle 2: " + manhattanDistancePuzzle2);
    }

    private static void movePosition(Position pPosition, char pRelDir, int pDistance)
    {
        Direction.RelativeDir relativeDir = pRelDir == LEFT ?
                Direction.RelativeDir.LEFT: Direction.RelativeDir.RIGHT;

        pPosition.move(relativeDir, pDistance);
    }

    private static String readPuzzleData(String pPuzzlePath)
    {
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(pPuzzlePath));
            String dataLine = reader.readLine();
            return dataLine;
        }
        catch (FileNotFoundException fnfe)
        {
            System.err.println("File not found:\n" + pPuzzlePath);
            return null;
        }
        catch (IOException ioe)
        {
            System.err.println("An I/O error occured.");
            return null;
        }
    }
}
