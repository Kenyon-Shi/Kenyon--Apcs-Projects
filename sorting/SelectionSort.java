package sorting;

public class SelectionSort implements Sorter {

    private long steps = 0;

    @Override
    public void sort(int[] input) {

        // Selection Sort implementation
        steps = 0;

        for (int i = 0; i < input.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < input.length; j++) {
                steps++; // comparison
                if (input[j] < input[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = input[i]; steps++;
                input[i] = input[minIndex]; steps++;
                input[minIndex] = temp; steps++;
            }
        }

        System.out.println("Selection Sort steps: " + steps);
    }
}
