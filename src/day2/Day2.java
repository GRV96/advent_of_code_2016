package src.day2;

import src.reading.PuzzleReading;

import java.util.List;

public class Day2
{
    private static final char UP = 'U';
    private static final char DOWN = 'D';
    private static final char LEFT = 'L';
    private static final char RIGHT = 'R';

    public static void main(String[] pArgs)
    {
        String inputPath = pArgs[0];
        List<String> instructionLines = PuzzleReading.readFileLines(inputPath);
        int nbInstructionLines = instructionLines.size();

        AKeypad keypadPuzzle1 = new SquareKeypad();
        String accessCodePuzzle1 = "";

        AKeypad keypadPuzzle2 = new DiamondKeypad();
        String accessCodePuzzle2 = "";

        for (int i=0; i<nbInstructionLines; i++)
        {
            String instructionLine = instructionLines.get(i);
            int nbInstructions = instructionLine.length();

            for (int j=0; j<nbInstructions; j++)
            {
                char instruction = instructionLine.charAt(j);
                switch (instruction)
                {
                    case UP ->
                    {
                        keypadPuzzle1.moveRowIndex(-1);
                        keypadPuzzle2.moveRowIndex(-1);
                    }
                    case DOWN ->
                    {
                        keypadPuzzle1.moveRowIndex(1);
                        keypadPuzzle2.moveRowIndex(1);
                    }
                    case LEFT ->
                    {
                        keypadPuzzle1.moveColumnIndex(-1);
                        keypadPuzzle2.moveColumnIndex(-1);
                    }
                    case RIGHT ->
                    {
                        keypadPuzzle1.moveColumnIndex(1);
                        keypadPuzzle2.moveColumnIndex(1);
                    }
                }
            }

            accessCodePuzzle1 += keypadPuzzle1.getKey();
            accessCodePuzzle2 += keypadPuzzle2.getKey();
        }

        System.out.println("Puzzle 1: " + accessCodePuzzle1);
        System.out.println("Puzzle 2: " + accessCodePuzzle2);
    }
}
