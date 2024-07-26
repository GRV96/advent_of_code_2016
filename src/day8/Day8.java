package src.day8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Day8
{
    private static final String CMD_RECT = "rect";
    private static final String CMD_ROTATE = "rotate";

    private static final String COLUMN = "column";
    private static final String ROW = "row";

    private static final String SPACE = " ";
    private static final String X = "x";

    private static void executeRectCommand(Screen pScreen, String[] pSplitCommand)
    {
        String[] splitDimensions = pSplitCommand[1].split(X);
        int nbColumns = Integer.parseInt(splitDimensions[0]);
        int nbRows = Integer.parseInt(splitDimensions[1]);
        pScreen.turnRectangleOn(nbColumns, nbRows);
    }

    private static void executeRotateCommand(Screen pScreen, String[] pSplitCommand)
    {
        int index = Integer.parseInt(pSplitCommand[2].substring(2));
        int shift = Integer.parseInt(pSplitCommand[4]);

        switch (pSplitCommand[1])
        {
            case COLUMN -> pScreen.rotateColumn(index, shift);
            case ROW -> pScreen.rotateRow(index, shift);
        }
    }

    public static void main(String[] pArgs) throws IOException
    {
        String inputPath = pArgs[0];
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));

        Screen screen = new Screen(50, 6);
        String inputLine;
        while ((inputLine = reader.readLine()) != null)
        {
            inputLine = inputLine.trim();

            String[] splitCommand = inputLine.split(SPACE);
            switch (splitCommand[0])
            {
                case CMD_RECT -> executeRectCommand(screen, splitCommand);
                case CMD_ROTATE -> executeRotateCommand(screen, splitCommand);
            }
        }

        System.out.println("Puzzle 1: " + screen.countPixelsOn());
        System.out.println("Puzzle 2:");
        screen.printPixels();
    }

    private static void printCommandAndResult(String pCommand, Screen pScreen)
    {
        System.out.println(pCommand);
        pScreen.printPixels();
        System.out.println();
    }
}
