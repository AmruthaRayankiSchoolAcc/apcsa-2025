package sorting;

public class SelectionSort implements Sorter {

    public void sort(int[] input) {
        int n = input.length;
        for (int i = 0; i < n - 1; ++i) {
            int min_idx = i;

            for (int j = i + 1; j < n; ++j) {
                if (input[j] < input[min_idx]) {
                    min_idx = j; 
                }
            }

            int temp = input[i];
            input[i] = input[min_idx];
            input[min_idx] = temp;
        }
        //System.out.println("Selection Sort!!!");
    }
}