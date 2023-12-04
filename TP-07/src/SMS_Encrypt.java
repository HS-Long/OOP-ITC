import java.util.ArrayList;
import java.util.Scanner;

public class SMS_Encrypt {
    private  String subject;
    private String fromPhoneNumber;
    private String receiverNumber;
    private String type;
    private String content;
    private String status;

    public SMS_Encrypt(String subject, String fromPhoneNumber, String receiverNumber, String type, String content, String status) {
        this.subject = subject;
        this.fromPhoneNumber = fromPhoneNumber;
        this.receiverNumber = receiverNumber;
        this.type = type;
        this.content = content;
        this.status = status;
    }
    public SMS_Encrypt(){
        this.subject = "";
        this.fromPhoneNumber ="";
        this.receiverNumber = "";
        this.type = "";
        this.content = "";
        this.status = "new";
    }
    public SMS_Encrypt(String fromPhoneNumber, String receiverNumber, String content) {
        this.subject = "";
        this.fromPhoneNumber = fromPhoneNumber;
        this.receiverNumber = receiverNumber;
        this.type = "Text"; // Default type is Text
        this.content = content;
        this.status = "new"; // Default status is new
    }

    public String getSubject() {
        return subject;
    }

    public String getFromPhoneNumber() {
        return fromPhoneNumber;
    }

    public String getReceiverNumber() {
        return receiverNumber;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public String getStatus() {
        return status;
    }
}
class SMSlist{
    private ArrayList<SMS_Encrypt> smslist;
    private static final int maxCharactersPerSMS = 160; // Example value, you can adjust as needed
    public SMSlist() {
        this.smslist = new ArrayList<>();
    }

    // Overloaded method to add an SMS to the list
    public void addSMS(SMS_Encrypt sms) {
        smslist.add(sms);
    }

    // Overloaded method to retrieve an SMS from the list based on index
    public SMS_Encrypt getSMS(int index) {
        if (index >= 0 && index < smslist.size()) {
            return smslist.get(index);
        } else {
            return null; // Index out of bounds
        }
    }

    // Overloaded method to check if an SMS is within character limits
    public boolean isWithinCharacterLimits(String content) {
        return content.length() <= maxCharactersPerSMS;
    }

    // Method to remove an SMS by index
    public void removeSMS(int index) {
        if (index >= 0 && index < smslist.size()) {
            smslist.remove(index);
            System.out.println("SMS at index " + index + " removed.");
        } else {
            System.out.println("Invalid index. SMS not removed.");
        }
    }

    // Method to display all SMSes
    public void displaySMSList() {
        System.out.println("SMS List:");
        for (int i = 0; i < smslist.size(); i++) {
            System.out.println("Index " + i + ": " + smslist.get(i).getFromPhoneNumber() +
                    " -> " + smslist.get(i).getReceiverNumber() +
                    " (Status: " + smslist.get(i).getStatus() + ")");
        }
    }


    public static void sendNewSMS(SMSlist smsList, Scanner scanner) {
        // Gather SMS information
        System.out.print("Enter subject: ");
        String subject = scanner.next();

        System.out.print("Enter from phone number: ");
        String fromPhoneNumber = scanner.next();

        System.out.print("Enter receiver number: ");
        String receiverNumber = scanner.next();

        System.out.print("Enter content: ");
        String content = scanner.next();

        // Check if content is within character limits
        if (smsList.isWithinCharacterLimits(content)) {
            // Create and add new SMS to the list
            SMS_Encrypt newSMS = new SMS_Encrypt(subject, fromPhoneNumber, receiverNumber, "Text", content, "new");
            smsList.addSMS(newSMS);

            System.out.println("SMS sent successfully.");
        } else {
            System.out.println("Error: SMS content exceeds character limits.");
        }
    }

    public static void viewSMSDetail(SMSlist smsList, Scanner scanner) {
        System.out.print("Enter the index of the SMS to view: ");
        int index = scanner.nextInt();

        SMS_Encrypt sms = smsList.getSMS(index);
        if (sms != null) {
            System.out.println("\nSMS Detail:");
            System.out.println("Subject: " + sms.getSubject());
            System.out.println("From: " + sms.getFromPhoneNumber());
            System.out.println("To: " + sms.getReceiverNumber());
            System.out.println("Type: " + sms.getType());
            System.out.println("Content: " + sms.getContent());
            System.out.println("Status: " + sms.getStatus());
        } else {
            System.out.println("Invalid index. SMS not found.");
        }
    }

    public static void removeSMSByIndex(SMSlist smsList, Scanner scanner) {
        System.out.print("Enter the index of the SMS to remove: ");
        int index = scanner.nextInt();
        smsList.removeSMS(index);
    }
}

