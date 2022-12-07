import java.util.Scanner;

public class PAC1Ex1 {

    public static void main(String[] args) {

        int number;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a positive number: ");
        number = scanner.nextInt(); //assigns the variable "number" the integer entered by keyboard

        if(number <= 0) {
            System.out.println("[ERROR]: The given number is not positive");
        }else if(isPrime(number)){
            System.out.println("The number "+number+" is a prime number");
        }else{
            System.out.println("The number "+number+" is not a prime number");
        }
    }

    public static boolean isPrime(int number) {

    boolean isNotPrime = false;
        for(int i = 2; i <= number /2 && !isNotPrime; i++) {
            if(number % i == 0) {
                isNotPrime = true;
            }
        }
        return !isNotPrime;
    }
}
