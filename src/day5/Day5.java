package src.day5;

import java.security.NoSuchAlgorithmException;

public class Day5
{
    private static final String EXAMPLE_INPUT = "abc";
    private static final String PUZZLE_INPUT = "ojvtpuvg";

    private static final String FIVE_ZEROS = "00000";
    private static final int PASSWORD_LENGTH = 8;
    private static final int RELEVANT_INDEX = 5;

    public static void main(String[] pArgs) throws NoSuchAlgorithmException
    {
        Md5Hasher md5Hasher = new Md5Hasher();

        char[] passwordChars = new char[PASSWORD_LENGTH];
        int passwordIndex = 0;
        int increment = 0;
        while (passwordIndex < PASSWORD_LENGTH && increment < Integer.MAX_VALUE)
        {
            String md5Hash = md5Hasher.md5Hash(PUZZLE_INPUT + increment);
            increment++;

            if (md5Hash.startsWith(FIVE_ZEROS))
            {
                passwordChars[passwordIndex] = md5Hash.charAt(RELEVANT_INDEX);
                passwordIndex++;
            }
        }
        String password = new String(passwordChars);

        System.out.println("Puzzle 1: " + password);
    }
}
