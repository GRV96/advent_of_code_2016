package src.reading;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LineReader
{
    private final String _filePath;
    private BufferedReader _reader;

    public LineReader(String pFilePath) throws FileNotFoundException
    {
        _filePath = pFilePath;
        reset();
    }

    public void close() throws IOException
    {
        if (_reader != null)
        {
            _reader.close();
        }
    }

    public String readLine() throws IOException
    {
        if (_reader == null)
        {
            return null;
        }

        String line = _reader.readLine();

        if(line != null)
        {
            line = line.trim();
        }

        return line;
    }

    public void reset() throws FileNotFoundException
    {
        _reader = new BufferedReader(new FileReader(_filePath));
    }
}
