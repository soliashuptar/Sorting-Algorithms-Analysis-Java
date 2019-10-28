public class InsertionSort implements Sort {

    public long[] main(int[] arr) {
        long startTimeInssort = System.nanoTime(); // time in nano secs
        int counter = 0;

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            counter += 1; // comparison counter

            while (j > 0 && arr[j] > key) {
                counter += 1;
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;

        }
        long endTimeInssort  = System.nanoTime();
        long totalTimeInssort = (endTimeInssort - startTimeInssort);
        long[] returnArray = {totalTimeInssort, counter};
        return returnArray;
    }

    public String getName() {
        return "Insertion Sort";
    }
}