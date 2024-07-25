package src.day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

class Day7
{
    private static boolean addressSupportsTls(AddressBreakdown pAddressBreakdown)
    {
        return pAddressBreakdown.supernetSequencesContainAbba()
                && !pAddressBreakdown.hypernetSeqsContainAbba();
    }

    private static boolean addressSupportsSsl(AddressBreakdown pAddressBreakdown)
    {
        List<AbaPattern> supernetAbaPatterns =
                pAddressBreakdown.getAbaPatternsFromSupernetSeqs();
        List<AbaPattern> hypernetAbaPatterns =
                pAddressBreakdown.getAbaPatternsFromHypernetSeqs();

        for (AbaPattern sap : supernetAbaPatterns)
        {
            for (AbaPattern hap : hypernetAbaPatterns)
            {
                if (sap.isBabTo(hap))
                {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] pArgs) throws IOException
    {
        String inputPath = pArgs[0];
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));

        int nbAddressesSupportTls = 0;
        int nbAddressesSupportSsl = 0;
        String inputLine;
        while ((inputLine = reader.readLine()) != null)
        {
            inputLine = inputLine.trim();

            AddressBreakdown addressBreakdown = PatternDetection.breakdownAddress(inputLine);

            if (addressSupportsTls(addressBreakdown))
            {
                nbAddressesSupportTls++;
            }

            if (addressSupportsSsl(addressBreakdown))
            {
                nbAddressesSupportSsl++;
            }
        }

        System.out.println("Puzzle 1: " + nbAddressesSupportTls);
        System.out.println("Puzzle 2: " + nbAddressesSupportSsl);
    }
}
