package edu.neu.coe.info6205.myPrograms;

public class QuickFind {
    private int[] root, rank;

    public QuickFind(int size) {
        rank = new int[size];
        root = new int[size];

        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = i;
        }
    }

    public int find(int x) {
        //TO-DO:
        while(x != root[x])
        {
            root[x] = root[root[x]];
            x = root[x];
        }
        return x;
    }

    public void union(int x, int y) {
        //TO-DO:
        {
            int i = root[x];
            int j = root[y];
            if(rank[i] < rank[j])
            {
                root[i] = j;
                rank[j] += rank[i];
            }
            else
            {
                root[j] = i;
                rank[i] += rank[j];
            }
        }

    }


    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
