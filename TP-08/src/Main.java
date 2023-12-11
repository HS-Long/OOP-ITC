import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

         Scanner scann = new Scanner(System.in);

        int choicee;
        do {
            System.out.println("\nWelcome to My Project!");
            System.out.println("1. Sequence.");
            System.out.println("2. Purchase.");
            System.out.println("3. Question.");
            System.out.println("4. Exit.");
            System.out.print("Enter your choice: ");
            choicee = scann.nextInt();
            switch (choicee) {
                case 1:

                    Scanner scanner = new Scanner(System.in);
                    SequenceDownUp sequenceDownUp = new SequenceDownUp();
                    System.out.print("Input a positive number: ");
                    int inputNumber = scanner.nextInt();
                    sequenceDownUp.printSequence(inputNumber);
                    break;

                case 2:

                    Scanner scan = new Scanner(System.in);
                    System.out.print("Input total buying cost: ");
                    double cost = scan.nextDouble();
                    Purchase purchase = new Purchase(cost);
                    double discount = purchase.getDiscount();
                    double total = purchase.getTotal();
                    if (cost > 0) {
                        System.out.printf("Total cost: %.2f $\n", cost);
                        System.out.printf("Total discount: %.2f $\n", discount);
                        System.out.println("-------------------------");
                        System.out.printf("Total payment: %.2f $\n", total);

                    } else {
                        System.out.println("Cost must be positive");
                    }
                    break;

                case 3:
                    Question q1 = new Question("You enter into the first room, here it is a lot of gold. "
                            + "Whether you will take it?",
                            "A. Yes", "B. No", "B");

                    Question q2 = new Question("You pass in a following room. It is "
                            + "full of diamonds, whether you will take diamonds?",
                            "A. Yes", "B. No", "B");

                    Question q3 = new Question("You enter the third room. A person "
                            + "was attacking by a dragon! To move further, not "
                            + "paying to them of attention?",
                            "A. Yes", "B. No", "B");

                    Scanner sc = new Scanner(System.in);
                    System.out.println(q1.getText());
                    String ans1 = sc.nextLine();
                    if (!q1.checkAnswer(ans1)) {
                        System.out.println("Gold remains to you, but you have ruined test. GAME is over!!!");
                        return;
                    }
                    System.out.println("Congratulation, you have passed the first test honor!");
                    System.out.println(q2.getText());
                    String ans2 = sc.nextLine();
                    if (!q2.checkAnswer(ans2)) {
                        System.out.println("Diamonds remain to you, but you have ruined the second test");
                        return;
                    }
                    System.out.println("Congratulation, you have passed the second test of honor!!!");
                    System.out.println(q3.getText());
                    String ans3 = sc.nextLine();
                    if (!q3.checkAnswer(ans3)) {
                        System.out.println("You try to pass past, but a dragon notice your presence "
                                + "and transforms you into ashes. You are dead!!! GAME is over!!!");
                        return;
                    }
                    System.out.println("Congratulation, you have pass all tests of honor. "
                            + "Princess gets to you!!!");
                    break;
                case 4:
                    System.out.println("Goodbye!.");
                    break;
                default:
                    System.out.println("Invalid choice");
            }

            }while(choicee != 4);
        }
    }



