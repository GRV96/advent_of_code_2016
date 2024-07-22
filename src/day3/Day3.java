package src.day3;

import src.reading.LineReader;

public class Day3
{
    private static final int NB_COLUMNS = 3;
    private static final int NB_SIDES = 3;
    private static final String NUMBER_SEPARATOR = " +";

    public static void main(String[] pArgs)
    {
        String inputPath = pArgs[0];

        // i: column index
        // j: position in the specification
        int[][] sideSpecsPuzzle2 = new int[NB_COLUMNS][NB_SIDES];
        int jPuzzle2 = 0;

        int nbTrianglesPuzzle1 = 0;
        int nbTrianglesPuzzle2 = 0;

        LineReader lineReader = new LineReader(inputPath);
        String inputLine;

        while ((inputLine = lineReader.readLine()) != null)
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
        lineReader.close();

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
}
