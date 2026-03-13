import java.util.*;

class NegativeNumberException extends Exception {
    public NegativeNumberException(String message) {
        super(message);
    }
}

public class  Exception1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 1, n, sum = 0, m;

        System.out.print("Enter the count: ");
        n = sc.nextInt();

        while (i <= n) {
            System.out.print("Enter number " + i + " : ");

            try {
                m = sc.nextInt();

                if (m < 0) {
                    throw new NegativeNumberException("Value must be positive");
                }

                sum = sum + m;
                i++;
            }
            catch (NegativeNumberException e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }

        System.out.println("Average = " + sum/n);
    }
}
