package src.day5;

import java.security.NoSuchAlgorithmException;

public class Day5
{
    private static final String EXAMPLE_INPUT = "abc";
    private static final String PUZZLE_INPUT = "ojvtpuvg";

    private static final String FIVE_ZEROS = "00000";
    private static final int PASSWORD_LENGTH = 8;
    private static final char CHAR_ZERO = '0';
    private static final char NUL_CHAR = '\0';

    public static void main(String[] pArgs) throws NoSuchAlgorithmException
    {
        Md5Hasher md5Hasher = new Md5Hasher();

        char[] passwordCharsPuzzle1 = new char[PASSWORD_LENGTH];
        int passwordIndexPuzzle1 = 0;
        char[] passwordCharsPuzzle2 = new char[PASSWORD_LENGTH];
        int nbPasswordCharsFoundPuzzle2 = 0;
        int increment = 0;
        while (nbPasswordCharsFoundPuzzle2 < PASSWORD_LENGTH && increment < Integer.MAX_VALUE)
        {
            String md5Hash = md5Hasher.md5Hash(PUZZLE_INPUT + increment);
            increment++;

            if (md5Hash.startsWith(FIVE_ZEROS))
            {
                char charAt5 = md5Hash.charAt(5);

                if (passwordIndexPuzzle1 < PASSWORD_LENGTH)
                {
                    passwordCharsPuzzle1[passwordIndexPuzzle1] = charAt5;
                    passwordIndexPuzzle1++;
                }

                int passwordIndexPuzzle2 = charAt5 - CHAR_ZERO;
                if (passwordIndexPuzzle2 < PASSWORD_LENGTH
                        && passwordCharsPuzzle2[passwordIndexPuzzle2] == NUL_CHAR)
                {
                    char passwordCharPuzzle2 = md5Hash.charAt(6);
                    passwordCharsPuzzle2[passwordIndexPuzzle2] = passwordCharPuzzle2;
                    nbPasswordCharsFoundPuzzle2++;
                }
            }
        }

        System.out.println("Puzzle 1: " + new String(passwordCharsPuzzle1));
        System.out.println("Puzzle 2: " + new String(passwordCharsPuzzle2));
    }
}
