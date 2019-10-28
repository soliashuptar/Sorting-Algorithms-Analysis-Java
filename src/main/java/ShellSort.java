public class ShellSort implements Sort{

    public long[] main(int[] arr) {
        long startTimeShellsort = System.nanoTime();
        int n = arr.length;
        int counter = 0;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                counter += 1;
                int key = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > key) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                    if (j < gap) {
                        counter -= 1;
                    }
                    counter += 1;
                }
                arr[j] = key;
            }
        }
        long endTimeShellsort  = System.nanoTime();
        long totalTimeShellsort = (endTimeShellsort - startTimeShellsort);
        long[] returnArray = {totalTimeShellsort, counter};
        return returnArray;
    }

    public String getName() {
        return "Shell Sort";
    }
}