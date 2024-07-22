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

            String puzzleLine;
            while ((puzzleLine = reader.readLine()) != null)
            {
                puzzleLine = puzzleLine.trim();

                if (puzzleLine.length() > 0)
                {
                    R dataItem = pFunction.apply(puzzleLine);
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

    public static List<String> readFileLines(String pInputPath)
    {
        try
        {
            List<String> inputLines = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(pInputPath));

            String inputLine;
            while ((inputLine = reader.readLine()) != null)
            {
                if (inputLine.length() > 0)
                {
                    inputLine = inputLine.trim();
                    inputLines.add(inputLine);
                }
            }

            return inputLines;
        }
        catch (FileNotFoundException fnfe)
        {
            System.err.println(FILE_NOT_FOUND + pInputPath);
            return null;
        }
        catch (IOException ioe)
        {
            System.err.println(IO_ERROR_OCCURRED);
            return null;
        }
    }
}
