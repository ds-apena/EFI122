package schleifen;

import java.util.Scanner;

public class Handy {
    private String manufacturer;
    private String model;
    private String IMEI;
    private String pinCode;
    private String PUK; //Personal Unblocking Key

    public Handy(String manufacturer, String model, String IMEI, String pinCode, String PUK) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.IMEI = IMEI;
        this.pinCode = pinCode;
        this.PUK = PUK; 
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public String getIMEI() {
        return IMEI;
    }

    public String getPUK() {
        return PUK;
    }

    public boolean loginUser(Scanner sc) {
        int numberOfTries = 0;
        boolean validCode = false;
        while (numberOfTries < 3 && !validCode) {
            System.out.print("Bitte geben Sie Ihren PIN-Code ein: ");
            String pinCode = sc.next();
            try {
                if (!checkPINCode(pinCode)) {
                    numberOfTries++;
                    System.out.println("Code falsch eingegeben. Bitte versuchen Sie erneut!");
                } else {
                    validCode = true;
                    System.out.println("Anmeldung erfolgreich!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        int noOfTries_PUK = 0;
        while (noOfTries_PUK < 10 && !validCode) {
            System.out.print("Geben Sie Ihren PUK (Personal Unblocking Key) ein:");
            String PUK = sc.next();
            try {
                if(!checkPUK(PUK)) {
                    noOfTries_PUK++;
                    System.out.println("Ungültiger PUK. Versuchen Sie erneut.");
                    if (noOfTries_PUK == 9) {
                        System.out.println("PUK 10x falsch eingegeben. Bitte kontaktieren Sie den Service. ");
                    }
                } else {
                    validCode = true;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return validCode;
    }

    private boolean checkPUK(String PUK) throws Exception {
        if (PUK.matches("\\d+") && PUK.length() == 6) {
            return PUK.equals(this.PUK);
        } else {
            throw new Exception("Ungültiger PUK. Überprüfen Sie, ob dieser der richtigen Länge entspricht (6 Zeichen).");
        }
    }
    
    

    private boolean checkPINCode(String pinCode) throws Exception {
        int pinCodeLength = pinCode.length();
        if (pinCode.matches("\\d+") && (pinCodeLength >=4 && pinCodeLength <= 6) ) {
            return pinCode.equals(this.pinCode);
        } else {
            throw new Exception("Dies entspricht keinem gültigen Code.");
        }
    }

}
