package edu.neu.coe.info6205.union_find;

import java.util.Random;

public class HWQUPC_Solution {
    public static int count(int n) {
        UF_HWQUPC uf = new UF_HWQUPC(n);
        Random random = new Random();
        int connections = 0;
        while (uf.components() != 1) {
            int p = random.nextInt(n);
            int q = random.nextInt(n);
                uf.union(p, q);
                connections++;
        }
        return connections;
    }

    public static void main(String[] args) {
        int run = 50;
        int n = 100;
        for (int i = 1; i < 20; i++) {
            int totalConnections = 0;
            for (int j = 0; j < run; j++) {
                totalConnections += count(n);
            }
            int avgConnections = totalConnections / run;
            System.out.printf("Number of pairs generated to reduce the number of components from %d to 1 is %d\n", n,avgConnections);
            n *= 2;
        }
    }
}