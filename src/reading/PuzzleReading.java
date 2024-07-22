package src.reading;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class PuzzleReading
{
    private static final String FILE_NOT_FOUND = "File not found:\n";
    private static final String IO_ERROR_OCCURRED = "An I/O error occurred.";

    public static <R> List<R> parsePuzzleData(
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
            System.err.println(FILE_NOT_FOUND + pPuzzlePath);
            return null;
        }
        catch (IOException ioe)
        {
            System.err.println(IO_ERROR_OCCURRED);
            return null;
        }
    }

    public static List<String> readFileLines(String pPuzzlePath)
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
            System.err.println(FILE_NOT_FOUND + pPuzzlePath);
            return null;
        }
        catch (IOException ioe)
        {
            System.err.println(IO_ERROR_OCCURRED);
            return null;
        }
    }
}
