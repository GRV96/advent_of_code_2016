package src.day3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Day3
{
    private static final int NB_COLUMNS = 3;
    private static final int NB_SIDES = 3;
    private static final String NUMBER_SEPARATOR = " +";

    public static void main(String[] pArgs)
    {
        String inputPath = pArgs[0];
        List<String> inputLines = readPuzzleLines(inputPath);

        // i: column index
        // j: position in the specification
        int[][] sideSpecsPuzzle2 = new int[NB_COLUMNS][NB_SIDES];
        int jPuzzle2 = 0;

        int nbTrianglesPuzzle1 = 0;
        int nbTrianglesPuzzle2 = 0;
        for (String inputLine : inputLines)
        {
            int[] sideSpecPuzzle1 = makeSideSpecs(inputLine);
            if (isSideSpecTriangle(sideSpecPuzzle1))
            {
                nbTrianglesPuzzle1++;
            }

            for (int i=0; i<NB_COLUMNS; i++)
            {
                sideSpecsPuzzle2[i][jPuzzle2] = sideSpecPuzzle1[i];
            }

            jPuzzle2++;
            if (jPuzzle2 >= NB_SIDES)
            {
                jPuzzle2 = 0;

                for (int i=0; i<NB_COLUMNS; i++)
                {
                    if (isSideSpecTriangle(sideSpecsPuzzle2[i]))
                    {
                        nbTrianglesPuzzle2++;
                    }
                }
            }
        }

        System.out.println("Puzzle 1: " + nbTrianglesPuzzle1);
        System.out.println("Puzzle 2: " + nbTrianglesPuzzle2);
    }

    private static boolean isSideSpecTriangle(int[] pSideSpec)
    {
        boolean isTriangle = true;

        for (int i=0; i<NB_SIDES; i++)
        {
            int sideLengthSum = 0;

            for (int j=0; j<NB_SIDES; j++)
            {
                if (j != i)
                {
                    sideLengthSum += pSideSpec[j];
                }
            }

            if (sideLengthSum <= pSideSpec[i])
            {
                isTriangle = false;
                break;
            }
        }

        return isTriangle;
    }

    private static int[] makeSideSpecs(String pRawSpec)
    {
        int[] sideSpecs = new int[NB_SIDES];
        String[] splitSpecs = pRawSpec.split(NUMBER_SEPARATOR);

        for (int i=0; i<NB_SIDES; i++)
        {
            sideSpecs[i] = Integer.parseInt(splitSpecs[i]);
        }

        return sideSpecs;
    }

    private static <R> List<R> readPuzzleData(
            String pPuzzlePath, Function<String, R> pFunction)
    {
        try
        {
            List<R> data = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(pPuzzlePath));

            String inputLine;
            while ((inputLine = reader.readLine()) != null)
            {
                if (inputLine.length() > 0)
                {
                    inputLine = inputLine.trim();
                    R dataItem = pFunction.apply(inputLine);
                    data.add(dataItem);
                }
            }

            return data;
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

    private static List<String> readPuzzleLines(String pPuzzlePath)
    {
        try
        {
            List<String> puzzleLines = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(pPuzzlePath));

            String inputLine;
            while ((inputLine = reader.readLine()) != null)
            {
                if (inputLine.length() > 0)
                {
                    inputLine = inputLine.trim();
                    puzzleLines.add(inputLine);
                }
            }

            return puzzleLines;
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
