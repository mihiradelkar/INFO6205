package edu.neu.coe.info6205.sort.elementary;

import edu.neu.coe.info6205.util.Benchmark_Timer;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Driver {

    private enum ArrayCondition {
        RANDOM, SORTED, HALF_SORTED, REVERSED
    }

    private static final Random randomGen = new Random();

    public static Integer[] prepareArray(int size, ArrayCondition condition) {
        Integer[] data = new Integer[size];
        for (int i = 0; i < size; i++) {
            data[i] = randomGen.nextInt(200000) - 100000; // Generating numbers within specific range
        }
        switch (condition) {
            case SORTED:
                Arrays.sort(data);
                break;
            case REVERSED:
                Arrays.sort(data, Comparator.reverseOrder());
                break;
            case HALF_SORTED:
                Arrays.sort(data, size / 2, size);
                break;
            default:
                break;
        }
        return data;
    }

    public static void performAnalysis(int arraySize, int trialRuns) {
        DecimalFormat timeFormat = new DecimalFormat("0.######");
        Benchmark_Timer<Integer[]> timer = new Benchmark_Timer<>("InsertionSort Benchmark", null, t -> {
            InsertionSort<Integer> sortAlgorithm = new InsertionSort<>();
            sortAlgorithm.sort(t, 0, t.length);
        }, null);

        double randomAvg = timer.runFromSupplier(() -> prepareArray(arraySize, ArrayCondition.RANDOM), trialRuns);
        double sortedAvg = timer.runFromSupplier(() -> prepareArray(arraySize, ArrayCondition.SORTED), trialRuns);
        double halfSortedAvg = timer.runFromSupplier(() -> prepareArray(arraySize, ArrayCondition.HALF_SORTED), trialRuns);
        double reversedAvg = timer.runFromSupplier(() -> prepareArray(arraySize, ArrayCondition.REVERSED), trialRuns);
        System.out.println("---------------------------------------------------");
        System.out.println("ArraySize: " + arraySize);
        System.out.println("Random: " + timeFormat.format(randomAvg));
        System.out.println("Sorted: " + timeFormat.format(sortedAvg));
        System.out.println("HalfSorted: " + timeFormat.format(halfSortedAvg));
        System.out.println("Reversed: " + timeFormat.format(reversedAvg));
    }

    public static void main(String[] params) {
        for (String param : params) {
            int size = Integer.parseInt(param);
            performAnalysis(size, 50); // Performing 50 trials per array size as specified
        }
    }
}
