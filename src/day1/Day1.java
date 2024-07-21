package src.day1;

import java.io.*;

class Day1
{
    private static final char LEFT = 'L';
    private static final char RIGHT = 'R';

    public static void main(String[] pArgs)
    {
        String inputPath = pArgs[0];

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(inputPath));
            String inputLine = reader.readLine();

            String[] instructions = inputLine.split(", *");
            Position position = new Position(0, 0, Direction.CardinalDir.NORTH);

            for(String instruction: instructions)
            {
                char relDir = instruction.charAt(0);
                int distance = Integer.parseInt(instruction.substring(1));
                movePosition(position, relDir, distance);
            }

            System.out.println("Puzzle 1: " + position.calculateManhattanDistance());
        }
        catch (FileNotFoundException fnfe)
        {
            System.err.println("File not found:\n" + inputPath);
            return;
        }
        catch (IOException ioe)
        {
            System.err.println("An I/O error occured.");
            return;
        }
    }

    private static void movePosition(Position pPosition, char pRelDir, int pDistance)
    {
        Direction.RelativeDir relativeDir = pRelDir == LEFT ?
                Direction.RelativeDir.LEFT: Direction.RelativeDir.RIGHT;

        pPosition.move(relativeDir, pDistance);
    }
}
