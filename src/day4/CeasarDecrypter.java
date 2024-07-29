package src.day4;

import java.util.HashMap;
import java.util.Map;

class CeasarDecrypter
{
    private Map<Integer, Map<Character, Character>> _decryptionTables;

    public CeasarDecrypter()
    {
        _decryptionTables = new HashMap<>();
    }

    public char decryptCharacter(char pSomeCharacter, int pShift)
    {
        int decryptionKey = pShift % 26;
        Map<Character, Character> decryptionTable = _decryptionTables.computeIfAbsent(
                decryptionKey, CeasarDecrypter::makeDecryptionTable);
        Character decryptedCharacter = decryptionTable.get(pSomeCharacter);
        return decryptedCharacter == null ? pSomeCharacter : decryptedCharacter;
    }

    public String decryptMessage(String pMessage, int pShift)
    {
        int messageLength = pMessage.length();
        char[] decrpytedMessage = new char[messageLength];

        for (int i=0; i<messageLength; i++)
        {
            decrpytedMessage[i] = decryptCharacter(pMessage.charAt(i), pShift);
        }

        return new String(decrpytedMessage);
    }

    private static Map<Character, Character> makeDecryptionTable(int pShift)
    {
        Map<Character, Character> decryptionTable = new HashMap<>();
        decryptionTable.putAll(makeDecryptionTable(pShift, 'A', 'Z'));
        decryptionTable.putAll(makeDecryptionTable(pShift, 'a', 'z'));
        return decryptionTable;
    }

    private static Map<Character, Character> makeDecryptionTable(int pShift, char pStartChar, char pEndChar)
    {
        int decryptionKey = pShift % 26;
        Map<Character, Character> decryptionTable = new HashMap<>();

        for (int c=pStartChar; c<=pEndChar; c++)
        {
            int decryptedChar = c + decryptionKey;

            if (decryptedChar < pStartChar)
            {
                int delta = pStartChar - decryptedChar;
                decryptedChar = pEndChar - delta + 1;
            }
            else if (decryptedChar > pEndChar)
            {
                int delta = decryptedChar - pEndChar;
                decryptedChar = pStartChar + delta - 1;
            }

            decryptionTable.put((char) c, (char) decryptedChar);
        }

        return decryptionTable;
    }
}
