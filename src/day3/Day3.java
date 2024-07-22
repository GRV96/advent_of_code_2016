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
    public static final int NB_SIDES = 3;
    private static final String NUMBER_SEPARATOR = " +";

    public static void main(String[] pArgs)
    {
        String inputPath = pArgs[0];
        List<int[]> sideSpecs = readPuzzleData(inputPath, Day3::makeSideSpecs);

        int nbTriangles = 0;
        for (int[] sideSpec : sideSpecs)
        {
            if (isSideSpecTriangle(sideSpec))
            {
                nbTriangles++;
            }
        }

        System.out.println("Puzzle 1: " + nbTriangles);
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

    private static <R> List<R> readPuzzleData(String pPuzzlePath, Function<String, R> pFunction)
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
}
