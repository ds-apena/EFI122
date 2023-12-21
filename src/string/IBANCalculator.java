package string;

import java.math.BigInteger;

public class IBANCalculator {
    
    public String generateIBAN(String countryCode, String blz, String accountNr) {
        printHeader();
        accountNr = validateAccountNr(accountNr);

        String iban;

        if (countryCode.contentEquals("DE")) {
            iban = generateIBAN_GermanCheckCode(blz, accountNr);
        } else {
            iban = generateIBAN_CountryCheckCode(blz, accountNr, countryCode);
        }

        String countryCodeNumber = calculateCountryCodeNumber(countryCode);
        iban = replaceCountryCodeByNumericValue(iban, countryCode, countryCodeNumber);
        String checkCode = calculateCheckCode(iban, countryCode);
        return generateValidIBAN(checkCode, iban);
    }

    private void printHeader() {
        System.out.println("-------------------------------------Willkommen zum IBAN Rechner ----------------------------------");
        System.out.println();
        System.out.println("""
                            Geben Sie eine Kontonummer mit dem entsprechenden Ländercode und die Bankleitzahl ein. Daraus wird\n
                            die entsprechende IBAN berechnet.
                            """);
    }

    private String validateAccountNr(String accountNr) {
        boolean validAccountLength = false;

        while (!validAccountLength) {
            if (accountNr.length() < 10) {
                accountNr = "0".concat(accountNr);
            } else {
                validAccountLength = true;
            }
        }

        return accountNr;
    }

    private String generateIBAN_GermanCheckCode(String blz, String accountNr) {
        return blz.concat(accountNr).concat("DE").concat("00");
    }

    private String generateIBAN_CountryCheckCode(String blz, String accountNr, String countryCheckCode) {
        return blz.concat(accountNr).concat(countryCheckCode).concat("00");
    }

    private String calculateCountryCodeNumber(String countryCode) {
        String countryCodeNr = "";

        for (int i = 0; i < countryCode.length(); i++) {
            int charVal = countryCode.charAt(i) - 55;
            countryCodeNr = countryCodeNr.concat(String.valueOf(charVal));
        }

        return countryCodeNr;
    }

    private String replaceCountryCodeByNumericValue(String iban, String countryCode, String countryCodeNr) {
        return iban.replace(countryCode, countryCodeNr);
    }

    private String calculateCheckCode(String iban, String countryCode) {
        BigInteger ib = new BigInteger(iban);
        BigInteger pz1 = ib.mod(BigInteger.valueOf(97));
        BigInteger pz2 = BigInteger.valueOf(98).subtract(pz1);

        String checkCode = countryCode;

        if (pz2.toString().length() < 2) {
            checkCode = checkCode.concat("0").concat(pz2.toString());
        } else {
            checkCode = checkCode.concat(pz2.toString());
        }

        return checkCode;
    }

    private String generateValidIBAN(String checkCode, String iban) {
        return checkCode.concat(iban.substring(0, 18));
    }
}
