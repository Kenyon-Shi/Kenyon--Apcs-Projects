package sorting;

public class InsertionSort implements Sorter {

    private long steps = 0;

    @Override
    public void sort(int[] input) {

        // Insertion Sort implementation
        steps = 0;

        for (int i = 1; i < input.length; i++) {
            int key = input[i]; steps++;
            int j = i - 1;

            while (j >= 0) {
                steps++; // comparison
                if (input[j] > key) {
                    input[j + 1] = input[j]; steps++;
                    j--;
                } else {
                    break;
                }
            }

            input[j + 1] = key; steps++;
        }

        System.out.println("Insertion Sort steps: " + steps);
    }
}
