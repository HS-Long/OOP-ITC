import java.util.ArrayList;
import java.util.Scanner;

public class Ex3_Service {
    ArrayList<Ex3_PC_Inventory> PCs = new ArrayList<Ex3_PC_Inventory>();
    Scanner scanner = new Scanner(System.in);
    private String ID;
    private boolean isDamaged;

    public Ex3_Service(){
        // default inventory
        addPC("PC01", true);
        addPC("PC02", false);
        addPC("PC03", false);
        addPC("PC04", true);
        addPC("PC05", false);
        addPC("PC06", false);
        addPC("PC07", true);
        addPC("PC08", false);
        addPC("PC09", false);
        addPC("PC10", true);
        addPC("PC11", false);
        addPC("PC12", false);
        addPC("PC13", false);
        addPC("PC14", true);
        addPC("PC15", false);
        addPC("PC16", false);
        addPC("PC17", false);
        addPC("PC18", false);
        addPC("PC19", true);
        addPC("PC20", false);
        addPC("PC21", false);
        addPC("PC22", true);
        addPC("PC23", false);
        addPC("PC24", true);
        addPC("PC25", true);
        addPC("PC26", false);
        addPC("PC27", false);
        addPC("PC28", false);
        addPC("PC29", true);
        addPC("PC30", false);
    }

    public void addPC(String id, Boolean con1){
        Ex3_PC_Inventory PC = new Ex3_PC_Inventory(id, con1);
        this.PCs.add(PC);
    }

    public void addPC(){
        System.out.println("--------------------------");
        System.out.print("Enter ID: ");
        ID = scanner.nextLine();
        System.out.print("Enter condition (0 for Damaged, 1 for Good condition): ");
        int condition;
        do{
            condition = scanner.nextInt();
            if (condition == 0) {
                isDamaged = true;
            } else if (condition == 1) {
                isDamaged = false;
            } else {
                System.out.print("Invalid condition please input again: ");
            }
        }while (condition != 0 || condition != 1);
        System.out.println("--------------------------");
        Ex3_PC_Inventory PC = new Ex3_PC_Inventory(ID, isDamaged);
        this.PCs.add(PC);
    }

    public void listAllPCs(){
        if (PCs.size() == 0) {
            System.out.println("No PC");
        } else {
            for (int i = 0; i < PCs.size(); i++) {
                System.out.println("ID: " + PCs.get(i).getID());
                if (PCs.get(i).getCondition()) {
                    System.out.println("Condition: Damaged");
                } else {
                    System.out.println("Condition: Good");
                }
                System.out.println("--------------------------");
            }
        }
    }

    public void listAllGoodPCs(){
        if (PCs.size() == 0) {
            System.out.println("No PC");
        } else {
            for (int i = 0; i < PCs.size(); i++) {
                if (!PCs.get(i).getCondition()) {
                    System.out.println("ID: " + PCs.get(i).getID());
                    System.out.println("Condition: Good");
                }
                System.out.println("--------------------------");
            }
        }
    }

    public void listAllDamagedPCs(){
        if (PCs.size() == 0) {
            System.out.println("No PC");
        } else {
            for (int i = 0; i < PCs.size(); i++) {
                if (PCs.get(i).getCondition()) {
                    System.out.println("ID: " + PCs.get(i).getID());
                    System.out.println("Condition: Damaged");
                }
                System.out.println("--------------------------");
            }
        }
    }

    public void MarkAsDamaged(){
        System.out.print("Enter ID: ");
        String ID = scanner.nextLine();
        boolean check = false;
        for (int i = 0; i < PCs.size(); i++) {
            if (PCs.get(i).getID().equals(ID)) {
                PCs.get(i).setCondition(true);
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("--------------------------");
            System.out.println("PC not found");
            System.out.println("--------------------------");
        }
    }

    public void MarkAsNotDamage(){
        System.out.print("Enter ID: ");
        String ID = scanner.nextLine();
        boolean check = false;
        for (int i = 0; i < PCs.size(); i++) {
            if (PCs.get(i).getID().equals(ID)) {
                PCs.get(i).setCondition(false);
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("--------------------------");
            System.out.println("PC not found");
            System.out.println("--------------------------");
        }
    }
}
