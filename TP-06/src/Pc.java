import java.util.Scanner;

public class Pc {
    private String pcNumber;
    private boolean isDamaged;

    public Pc(String pcNumber) {
        this.pcNumber = pcNumber;
        this.isDamaged = false;
    }

    public String getPCNumber() {
        return pcNumber;
    }

    public boolean isDamaged() {
        return isDamaged;
    }

    public void markAsDamaged() {
        isDamaged = true;
    }

    public void markAsNotDamaged() {
        isDamaged = false;
    }

    public static void listAllPCs(Pc[] pcs) {
        System.out.println("List of all PCs in Room 306F:");
        for (Pc pc : pcs) {
            System.out.println("PC Number: " + pc.getPCNumber() + " - Status: " +
                    (pc.isDamaged() ? "Damaged" : "Good"));
        }
    }

    public static void listDamagedPCs(Pc[] pcs) {
        System.out.println("List of damaged PCs in Room 306F:");
        for (Pc pc : pcs) {
            if (pc.isDamaged()) {
                System.out.println("PC Number: " + pc.getPCNumber());
            }
        }
    }

    public static void listGoodPCs(Pc[] pcs) {
        System.out.println("List of good PCs in Room 306F:");
        for (Pc pc : pcs) {
            if (!pc.isDamaged()) {
                System.out.println("PC Number: " + pc.getPCNumber());
            }
        }
    }

    public static void markPCAsDamaged(Pc[] pcs, Scanner scanner) {
        System.out.print("Enter the PC number to mark as damaged: ");
        String pcNumber = scanner.next();

        for (Pc pc : pcs) {
            if (pc.getPCNumber().equalsIgnoreCase(pcNumber)) {
                pc.markAsDamaged();
                System.out.println("PC " + pcNumber + " marked as damaged.");
                return;
            }
        }

        System.out.println("PC not found. Please enter a valid PC number.");
    }

    public static void markPCAsNotDamaged(Pc[] pcs, Scanner scanner) {
        System.out.print("Enter the PC number to mark as not damaged: ");
        String pcNumber = scanner.next();

        for (Pc pc : pcs) {
            if (pc.getPCNumber().equalsIgnoreCase(pcNumber)) {
                pc.markAsNotDamaged();
                System.out.println("PC " + pcNumber + " marked as not damaged.");
                return;
            }
        }

        System.out.println("PC not found. Please enter a valid PC number.");
    }
}
