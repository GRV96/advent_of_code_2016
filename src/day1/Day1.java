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
        Situation situation = new Situation(0, 0, Direction.CardinalDir.NORTH);
        Situation firstPosVisitedTwice = null;
        HashSet<Situation> positionSet = new HashSet<>();
        positionSet.add(new Situation(situation));

        for(String instruction: instructions)
        {
            char relDir = instruction.charAt(0);
            int distance = Integer.parseInt(instruction.substring(1));
            moveSituation(situation, relDir, distance);

            Situation situationCopy = new Situation(situation);
            if(firstPosVisitedTwice == null && !positionSet.add(situationCopy))
            {
                firstPosVisitedTwice = situationCopy;
            }
        }

        int manhattanDistancePuzzle1 = situation.calculateManhattanDistance();
        int manhattanDistancePuzzle2 =
                firstPosVisitedTwice == null ? -1 : firstPosVisitedTwice.calculateManhattanDistance();
        System.out.println("Puzzle 1: " + manhattanDistancePuzzle1);
        System.out.println("Puzzle 2: " + manhattanDistancePuzzle2);
    }

    private static void moveSituation(Situation pSituation, char pRelDir, int pDistance)
    {
        Direction.RelativeDir relativeDir = pRelDir == LEFT ?
                Direction.RelativeDir.LEFT: Direction.RelativeDir.RIGHT;

        pSituation.move(relativeDir, pDistance);
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
            System.err.println("An I/O error occured.");
            return null;
        }
    }
}
