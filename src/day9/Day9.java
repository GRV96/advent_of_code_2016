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

        Pattern markerPattern = Pattern.compile("(\\(\\d+x\\d+\\))");
        Matcher markerMatcher = markerPattern.matcher(compressedContent);
        markerMatcher.find();

        StringBuilder decompressedStrBuilder = new StringBuilder();
        int decompressionIndex = 0;
        int nbGroups = markerMatcher.groupCount();
        for (int groupIndex=0; groupIndex<nbGroups; groupIndex++)
        {
            int groupStart = markerMatcher.start(groupIndex);
            int groupEnd = markerMatcher.end(groupIndex);

            CompressionMarker compressionMarker = makeCompressionMarker(
                    compressedContent, groupStart, groupEnd);
            int sequenceStart = groupStart + groupEnd - 1;
            int sequenceEnd = sequenceStart + compressionMarker.sequenceLength;

            if (groupStart > decompressionIndex)
            {
                String nonCompressedSequence =
                        compressedContent.substring(decompressionIndex, groupStart);
                decompressedStrBuilder.append(nonCompressedSequence);
            }

            String sequence = compressedContent.substring(sequenceStart, sequenceEnd);
            decompressedStrBuilder.append(sequence.repeat(compressionMarker.nbRepetitions));

            decompressionIndex = sequenceEnd;
        }

        String decompressedContent = decompressedStrBuilder.toString();
        System.out.println("Puzzle 1: " + decompressedContent.length());
    }

    private static CompressionMarker makeCompressionMarker(
            String pCompressedContent, int pMatchGroupStart, int pMatchGroupEnd)
    {
        int xIndex = pCompressedContent.indexOf('x', pMatchGroupStart);
        int sequenceLength = Integer.parseInt(
                pCompressedContent.substring(pMatchGroupStart+1, xIndex));
        int nbRepetitions = Integer.parseInt(
                pCompressedContent.substring(xIndex+1, pMatchGroupEnd-1));
        return new CompressionMarker(sequenceLength, nbRepetitions);
    }
}
