package src.day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Day9
{
    public static void main(String[] pArgs) throws IOException
    {
        String inputPath = pArgs[0];
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));
        String compressedContent = reader.readLine();

        Pattern markerPattern = Pattern.compile("\\(\\d+x\\d+\\)");
        Matcher markerMatcher = markerPattern.matcher(compressedContent);
        markerMatcher.find();

        System.out.println("Matches were found: " + markerMatcher.hasMatch());
    }
}
