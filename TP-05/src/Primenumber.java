public class Primenumber {
public static void ListPrime(int n){
    int num = 2;
    while(num <= n){
        if(isprime(num)){
            System.out.println("Number: " + " " + num );
        }
        num++;
    }
    System.out.println(" It is prime number.");
}
private static boolean isprime(int n){
    if(n <= 1){
        return false;
    }
    int divisor = 2;
    while (divisor <= n / 2){
        if (n % divisor == 0){
            return false;
        }
        divisor++;
    }
    return true;
}

    }

