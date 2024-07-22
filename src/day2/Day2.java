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
        List<String> inputLines = readPuzzleData(inputPath);
        int nbInputLines = inputLines.size();

        SquareKeypad keypad = new SquareKeypad();
        String accessCode = "";

        for (int i=0; i<nbInputLines; i++)
        {
            String inputLine = inputLines.get(i);
            int nbInstructions = inputLine.length();

            for (int j=0; j<nbInstructions; j++)
            {
                char instruction = inputLine.charAt(j);
                switch (instruction)
                {
                    case UP -> keypad.moveRowIndex(-1);
                    case DOWN -> keypad.moveRowIndex(1);
                    case LEFT -> keypad.moveColumnIndex(-1);
                    case RIGHT -> keypad.moveColumnIndex(1);
                }
            }

            int digit = keypad.getKey();
            accessCode += digit;
        }

        System.out.println("Puzzle 1: " + accessCode);
        System.out.println("Puzzle 2: " + -1);
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
            System.err.println("An I/O error occured.");
            return null;
        }
    }
}
