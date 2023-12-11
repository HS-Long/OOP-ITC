import java.util.Scanner;

public class Exercise3 {
    Scanner scanner = new Scanner(System.in);
    Ex3_Service Ex3 = new Ex3_Service();
    private int choice1 = 0;
    public Exercise3(){
        do{
            System.out.println("0. Exit");
            System.out.println("1. Add PC");
            System.out.println("2. List all PCs");
            System.out.println("3. List all good PCs");
            System.out.println("4. List all damaged PCs");
            System.out.println("5. Mark PC as damaged");
            System.out.println("6. Mark PC as fixed");
            System.out.print("Please enter your choice: ");
            choice1 = scanner.nextInt();

            switch (choice1){
                case 1:
                    Ex3.addPC();
                    break;
                case 2:
                    Ex3.listAllPCs();
                    break;
                case 3:
                    Ex3.listAllGoodPCs();
                    break;
                case 4:
                    Ex3.listAllDamagedPCs();
                    break;
                case 5:
                    Ex3.MarkAsDamaged();
                    break;
                case 6:
                    Ex3.MarkAsNotDamage();
                    break;
                case 0:
                    System.out.println("GoodBye!");
                    break;
                default:
                    System.out.println("Invalid Input!");
                    break;
            }

        }while(choice1 != 0);
    }
}
