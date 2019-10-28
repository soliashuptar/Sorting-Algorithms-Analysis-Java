public class SelectionSort implements Sort {

    public long[] main(int[] arr) {
        long startTimeSelsort = System.nanoTime();
        int counter = 0;
        for (int i = 0; i < arr.length -1 ; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                counter += 1;
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        long endTimeSelsort = System.nanoTime();
        long totalTimeSelsort = (endTimeSelsort - startTimeSelsort);
        long[] returnArray = {totalTimeSelsort, counter};
        return returnArray;
    }

        public String getName () {
            return "Selection Sort";
        }
    }