package edu.neu.coe.info6205.randomwalk;

import edu.neu.coe.info6205.randomwalk.RandomWalk;

public class Driver {
    public static void main(String[] args) {
        System.out.println("Random Walk for 10 vales of m");
        int m = 10; //starting value of m
        for (int i = 0; i < 10; i++) {
            // Calling the RandomWalk main method with the current value of m
            RandomWalk.main(new String[]{String.valueOf(m)});
            m += 10;
        }
    }
}
