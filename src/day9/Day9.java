package src.day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day9
{
    public static void main(String[] pArgs) throws IOException
    {
        String inputPath = pArgs[0];
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));
        String compressedContent = reader.readLine();
        System.out.println("Hello, world!\n" + compressedContent);
    }
}
