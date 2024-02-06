package edu.neu.coe.info6205.myPrograms;
import org.junit.Assert;
import org.junit.Test;

public class QuickFindTest {
    @Test
    public void connectionTest1() {
        QuickFind uf = new QuickFind(10);
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        Assert.assertEquals(uf.connected(1,5), true);
        Assert.assertEquals(uf.connected(5,7), true);
        Assert.assertEquals(uf.connected(4,9), false);

        uf.union(9, 4);
        Assert.assertEquals(uf.connected(4,9), true);
    }

    @Test
    public void connectionTest2() {
        QuickFind uf = new QuickFind(10);
        uf.union(1, 5);
        uf.union(1, 7);
        uf.union(7, 3);
        uf.union(3, 9);
        uf.union(2, 4);
        uf.union(9, 5);
        Assert.assertEquals(uf.connected(1, 4), false);
        Assert.assertEquals(uf.connected(5, 7), true);
        Assert.assertEquals(uf.connected(1, 9), true);
        Assert.assertEquals(uf.connected(2, 9), false);
    }

    @Test
    public void connectionTest3() {
        QuickFind uf = new QuickFind(8);
        uf.union(1, 2);
        uf.union(2, 3);
        uf.union(3, 4);
        uf.union(4, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        Assert.assertEquals(uf.connected(2, 5), true);
        Assert.assertEquals(uf.connected(1, 6), true);
        Assert.assertEquals(uf.connected(4, 7), true);
        Assert.assertEquals(uf.connected(6, 3), true);
    }

    @Test
    public void connectionTest4() {
        QuickFind uf = new QuickFind(9);
        uf.union(1, 2);
        uf.union(3, 4);
        uf.union(5, 6);
        uf.union(7, 8);
        Assert.assertEquals(uf.connected(1, 5), false);
        Assert.assertEquals(uf.connected(5, 8), false);
        Assert.assertEquals(uf.connected(4, 7), false);

        uf.union(1, 8);
        Assert.assertEquals(uf.connected(1, 8), true);
    }

    @Test
    public void connectionTest5() {
        QuickFind uf = new QuickFind(6);
        uf.union(1, 1);
        uf.union(2, 2);
        uf.union(3, 3);
        uf.union(4, 4);
        uf.union(5, 5);
        Assert.assertEquals(uf.connected(1, 3), false);
        Assert.assertEquals(uf.connected(2, 2), true);
        Assert.assertEquals(uf.connected(4, 5), false);
        Assert.assertEquals(uf.connected(1, 2), false);
    }
}
