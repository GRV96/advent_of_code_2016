package src.day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day2
{
    private static final char UP = 'U';
    private static final char DOWN = 'D';
    private static final char LEFT = 'L';
    private static final char RIGHT = 'R';

    public static void main(String[] pArgs)
    {
        String inputPath = pArgs[0];
        List<String> instructionLines = readPuzzleData(inputPath);
        int nbInstructionLines = instructionLines.size();

        AKeypad keypadPuzzle1 = new SquareKeypad();
        String accessCodePuzzle1 = "";

        AKeypad keypadPuzzle2 = new DiamondKeypad();
        String accessCodePuzzle2 = "";

        for (int i=0; i<nbInstructionLines; i++)
        {
            String instructionLine = instructionLines.get(i);
            int nbInstructions = instructionLine.length();

            for (int j=0; j<nbInstructions; j++)
            {
                char instruction = instructionLine.charAt(j);
                switch (instruction)
                {
                    case UP ->
                    {
                        keypadPuzzle1.moveRowIndex(-1);
                        keypadPuzzle2.moveRowIndex(-1);
                    }
                    case DOWN ->
                    {
                        keypadPuzzle1.moveRowIndex(1);
                        keypadPuzzle2.moveRowIndex(1);
                    }
                    case LEFT ->
                    {
                        keypadPuzzle1.moveColumnIndex(-1);
                        keypadPuzzle2.moveColumnIndex(-1);
                    }
                    case RIGHT ->
                    {
                        keypadPuzzle1.moveColumnIndex(1);
                        keypadPuzzle2.moveColumnIndex(1);
                    }
                }
            }

            accessCodePuzzle1 += keypadPuzzle1.getKey();
            accessCodePuzzle2 += keypadPuzzle2.getKey();
        }

        System.out.println("Puzzle 1: " + accessCodePuzzle1);
        System.out.println("Puzzle 2: " + accessCodePuzzle2);
    }

    private static List<String> readPuzzleData(String pPuzzlePath)
    {
        try
        {
            List<String> inputLines = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(pPuzzlePath));

            String inputLine;
            while ((inputLine = reader.readLine()) != null)
            {
                if (inputLine.length() > 0)
                {
                    inputLines.add(inputLine);
                }
            }

            return inputLines;
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
