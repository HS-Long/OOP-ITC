public class Odd_number {
    public static void print_odd(int st_number, int end_number) {
        if (st_number % 2 == 0) {
            st_number++;
        }
        while (st_number <= end_number) {
            System.out.println("Odd number : " + st_number);
            st_number += 2;
        }
    }
}
