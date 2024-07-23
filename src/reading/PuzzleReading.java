package src.reading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class PuzzleReading
{
    public static <R> List<R> parsePuzzleData(
            String pPuzzlePath, Function<String, R> pFunction) throws IOException
    {
        List<R> data = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(pPuzzlePath));

        String puzzleLine;
        while ((puzzleLine = reader.readLine()) != null)
        {
            puzzleLine = puzzleLine.trim();

            if (!puzzleLine.isEmpty())
            {
                R dataItem = pFunction.apply(puzzleLine);
                data.add(dataItem);
            }
        }

        return data;
    }

    public static List<String> readFileLines(String pInputPath) throws IOException
    {
        List<String> inputLines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(pInputPath));

        String inputLine;
        while ((inputLine = reader.readLine()) != null)
        {
            inputLine = inputLine.trim();

            if (!inputLine.isEmpty())
            {
                inputLines.add(inputLine);
            }
        }

        return inputLines;
    }
}
