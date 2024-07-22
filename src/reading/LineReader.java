package src.reading;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LineReader
{
    private final String _filePath;
    private BufferedReader _reader;

    public LineReader(String pFilePath)
    {
        _filePath = pFilePath;
        reset();
    }

    public void close()
    {
        try
        {
            if (_reader != null)
            {
                _reader.close();
            }
        }
        catch (IOException e)
        {
            // Nothing to do
        }
    }

    public String readLine()
    {
        if (_reader == null)
        {
            return null;
        }

        String line = null;
        try
        {
            line = _reader.readLine();

            if(line != null)
            {
                line = line.trim();
            }
        }
        catch (IOException ioe)
        {
            // Do nothing.
        }

        return line;
    }

    public void reset()
    {
        try
        {
            _reader = new BufferedReader(new FileReader(_filePath));
        }
        catch (FileNotFoundException fnfe)
        {
            // The reader stays null.
        }
    }
}