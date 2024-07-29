package src.day9;

class CompressionMarker
{
    public int sequenceLength;
    public int nbRepetitions;

    public CompressionMarker(int pSequenceLength, int pNbRepetitions)
    {
        sequenceLength = pSequenceLength;
        nbRepetitions = pNbRepetitions;
    }

    @Override
    public String toString()
    {
        return "(" + sequenceLength + "x" + nbRepetitions + ")";
    }
}
