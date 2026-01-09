package warmup;

public class Main {
    public static void main(String[] args) {

        int limit = 1000;      // numbers below this
        int sum = 0;

        for (int i = 1; i < limit; i++) {

            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }

        }

        System.out.println("Sum = " + sum);
    }
}
