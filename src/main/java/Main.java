import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Math;

public class Main {

    public static long[] run(Sort arg, int[] arr) {
        return arg.main(arr);
    }

    //
    public static void main(String[] args) throws IOException {
        String[] experiments = {"experiment1.csv", "experiment4.csv"};
        for (int experiment = 0; experiment < 2; experiment++) {


            for (int i = 7; i < 18; i++) {

                long totalTimeInssort = 0;
                long totalTimeShellsort = 0;
                long totalTimeSelsort = 0;
                long totalCounterInssort = 0;
                long totalCounterSelsort = 0;
                long totalCounterShellsort = 0;

                Sort[] methods = {new InsertionSort(), new SelectionSort(), new ShellSort()};
                long[] time = {totalTimeInssort, totalTimeSelsort, totalTimeShellsort};
                long[] counters = {totalCounterInssort, totalCounterSelsort, totalCounterShellsort};

                for (int times = 0; times < 10; times++) {

                    int len = (int) Math.pow(2, i);
                    int[] ran_arr = new int[len];
                    if (experiment == 0 ) {
                        ran_arr = generateArray(len);
                    } else {
//                        int[] ran_arr = new int[len];
                        for (int j = 0; j < len; j++) {
                            ran_arr[j] = (int) ((Math.random() * 3) + 1);
                        }
                    }

                    for (int method = 0; method < methods.length; method++) {
                        int[] arr1 = ran_arr.clone();
                        long[] returnValues = run(methods[method], arr1);
                        time[method] += returnValues[0];
                        counters[method] += returnValues[1];
                    }
                }
                System.out.println("i am here");

                FileWriter fileWriter = new FileWriter(experiments[experiment], true);
                PrintWriter printWriter = new PrintWriter(fileWriter);

                for (int j = 0; j < methods.length; j++) {
                    System.out.println(methods[j].getName() + "," + Integer.toString(i) + ",");
                    System.out.println(time[j]);
                    printWriter.print("\n" + methods[j].getName() + "," + Integer.toString(i) + "," + Long.toString(counters[j]/10) + ",");
                    printWriter.printf(Long.toString((long) (time[j] / 10)));
                }
                printWriter.close();
            }

        }
        System.out.println("i doing 2 and 3");
        experiment2();
        experiment3();
    }

    public static void WriteToFile(int power, String filename, long[] times, long[] counters) throws IOException {
        FileWriter fileWriter = new FileWriter(filename, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        Sort[] methods = {new InsertionSort(),new SelectionSort(),new ShellSort()};

        for (int j = 0; j < methods.length; j ++) {
            printWriter.print("\n" + methods[j].getName() + "," + Integer.toString(power) + "," + Long.toString(counters[j]) + ",");
            printWriter.printf(Long.toString((long) times[j]));
        }
        printWriter.close();
    }

    public static void experiment2() throws IOException {
        for (int i = 7; i < 18; i++) {
            int[] ran_arr = generateArray((int) Math.pow(2, i));
            run(new ShellSort(), ran_arr);
            Sort[] methods = {new InsertionSort(), new SelectionSort(), new ShellSort()};
            long[] times = new long[3];
            long[] counters = new long[3];
            for (int j = 0; j < methods.length; j ++) {
                long[] returnValues = run(methods[j], ran_arr);
                times[j] = returnValues[0];
                counters[j] = returnValues[1];
            }
            WriteToFile(i, "experiment2.csv", times, counters);
        }
    }

    public static void experiment3() throws IOException {
        for (int i = 7; i < 18; i++) {
            int[] ran_arr = generateArray((int) Math.pow(2, i));
            run(new ShellSort(), ran_arr);
            Sort[] methods = {new InsertionSort(), new SelectionSort(), new ShellSort()};
            long[] counters = new long[3];
            // reverse an array
            for (int t = 0; t < ran_arr.length/2; t++) {
                int temp = ran_arr[t];
                ran_arr[t] = ran_arr[ran_arr.length - t -1];
                ran_arr[ran_arr.length - t - 1] = temp;
            }

            long[] times = new long[3];
            for (int j = 0; j < methods.length; j ++) {
                int[] arr1 = ran_arr.clone();
                long[] returnValues = run(methods[j], arr1);
                times[j] = returnValues[0];
                counters[j] = returnValues[1];
            }
            WriteToFile(i, "experiment3.csv", times, counters); // write to file function call
        }
    }

    public static int[] generateArray(int len) {
        int[] ran_arr = new int[len];
        for (int j = 0; j < len; j++) {
            ran_arr[j] = (int) (Math.random() * ((len - 1) + 1)) + 1;
        }
        return ran_arr;
    }
}
