package src.day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Day9
{
    private static long calculatedDecompressedLength(
            String pCompressedContent, Matcher pMarkerMatcher)
    {
        return calculatedDecompressedLength(
                pCompressedContent, pMarkerMatcher, 0, pCompressedContent.length());
    }

    private static long calculatedDecompressedLength(
            String pCompressedContent, Matcher pMarkerMatcher, int pStartIndex, int pEndIndex)
    {
        long decompressedLength = 0;

        int decompressionIndex = pStartIndex;
        while (pMarkerMatcher.find(decompressionIndex))
        {
            int groupStart = pMarkerMatcher.start(0);
            int groupEnd = pMarkerMatcher.end(0);

            if (groupStart >= pEndIndex)
            {
                break;
            }

            CompressionMarker compressionMarker = makeCompressionMarker(
                    pCompressedContent, groupStart, groupEnd);
            // The sequence to repeat starts at index groupEnd.
            int sequenceEnd = groupEnd + compressionMarker.sequenceLength;

            decompressedLength += compressionMarker.nbRepetitions
                    * calculatedDecompressedLength(
                            pCompressedContent, pMarkerMatcher, groupEnd, sequenceEnd);

            decompressionIndex = sequenceEnd;
        }

        if (decompressionIndex < pEndIndex)
        {
            decompressedLength += pEndIndex - decompressionIndex;
        }

        return decompressedLength;
    }

    public static void main(String[] pArgs) throws IOException
    {
        String inputPath = pArgs[0];
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));
        String compressedContent = reader.readLine();

        Pattern markerPattern = Pattern.compile("(\\(\\d+x\\d+\\))");
        Matcher markerMatcher = markerPattern.matcher(compressedContent);

        int decompressedStrLengthPuzzle1 = 0;
        int decompressionIndex = 0;
        while (markerMatcher.find(decompressionIndex))
        {
            int groupStart = markerMatcher.start(0);
            int groupEnd = markerMatcher.end(0);

            if (groupStart < decompressionIndex)
            {
                continue;
            }

            CompressionMarker compressionMarker = makeCompressionMarker(
                    compressedContent, groupStart, groupEnd);
            // The sequence to repeat starts at index groupEnd.
            int sequenceEnd = groupEnd + compressionMarker.sequenceLength;

            if (groupStart > decompressionIndex)
            {
                decompressedStrLengthPuzzle1 += groupStart - decompressionIndex;
            }

            decompressedStrLengthPuzzle1 +=
                    compressionMarker.nbRepetitions * (sequenceEnd - groupEnd);

            decompressionIndex = sequenceEnd;
        }

        System.out.println("Puzzle 1: " + decompressedStrLengthPuzzle1);

        long decompressedStrLengthPuzzle2 =
                calculatedDecompressedLength(compressedContent, markerMatcher);
        System.out.println("Puzzle 2: " + decompressedStrLengthPuzzle2);
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
