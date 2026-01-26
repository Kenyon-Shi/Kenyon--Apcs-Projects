package warmup;

public class Main {
    public static void main(String[] args) {

        int limit = 4_000_000;

        int a = 1;     // first Fibonacci term
        int b = 2;     // second Fibonacci term

        long sum = 0;  

        while (a <= limit) {

            if (a % 2 == 0) {
                sum += a;
            }

            int next = a + b;
            a = b;
            b = next;
        }

        System.out.println("Sum = " + sum);
    }
}
