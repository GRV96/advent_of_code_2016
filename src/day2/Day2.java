package src.day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Day2
{
    public static void main(String[] pArgs)
    {
        String inputPath = pArgs[0];
        String input = readPuzzleData(inputPath);
        System.out.println("Hello, world!");
    }

    private static String readPuzzleData(String pPuzzlePath)
    {
        try
        {
            String completeInput = "";
            BufferedReader reader = new BufferedReader(new FileReader(pPuzzlePath));

            String inputLine;
            do
            {
                inputLine = reader.readLine();
                completeInput += inputLine;
            }
            while (inputLine != null);

            return completeInput;
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
