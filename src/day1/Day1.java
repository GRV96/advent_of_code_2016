package src.day1;

import java.io.*;

public class Day1
{
    public static void main(String[] pArgs)
    {
        String inputPath = pArgs[0];

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(inputPath));
            String inputLine = reader.readLine();
            System.out.println(inputLine);
        }
        catch (FileNotFoundException fnfe)
        {
            System.err.println("File not found:\n" + inputPath);
            return;
        }
        catch (IOException ioe)
        {
            System.err.println("An I/O error occured.");
            return;
        }
    }
}
