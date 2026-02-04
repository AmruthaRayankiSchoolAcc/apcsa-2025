package sorting;

public class Main {
    public static void main(String[] args)
    {
        // Task:
        // 1. Implement missing sorting algorithms.
        //    - InsertionSort.java
        //    - SelectionSort.java
        //
        //  2. Add a method to class Main to generate a random array.
        //  3. Provide random input to test suite and ensure your implementations
        //     of InsertionSort and Selection sort continue to work.
        //  4. Increase the loop count for TestSuite to get better performance results.

        int[] testInput = randomArray(800);

        // Increase the loop count to get better results once it works.
         TestSuite.run(testInput, 1000);
        //TestSuite.run(testInput, 1);
    }

    public static int[] randomArray(int length)
    {
        // TODO: make this return an actual random array of the provided length.
        int[] puzzle = new int[length];
	    for (int r = 0; r < length; r++) {
			puzzle[r] = (int) (Math.random() * 9) + 1;
	    }
        return puzzle;
    }

}
