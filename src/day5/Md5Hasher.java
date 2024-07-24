package src.day5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

public class Md5Hasher
{
    private static final String ALGORITHM_MD5 = "MD5";

    private HexFormat _hexFormatter;
    private MessageDigest _md5MessageDigest;

    public Md5Hasher() throws NoSuchAlgorithmException
    {
        _hexFormatter = HexFormat.of();
        _md5MessageDigest = MessageDigest.getInstance(ALGORITHM_MD5);
    }

    public String md5Hash(String pInputToHash)
    {
        _md5MessageDigest.update(pInputToHash.getBytes());
        byte[] digest = _md5MessageDigest.digest();
        _md5MessageDigest.reset();
        return _hexFormatter.formatHex(digest);
    }
}
