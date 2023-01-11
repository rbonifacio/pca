package br.unb.cic.algorithms.dp.rc;

import org.junit.Assert;
import org.junit.Test;

public class TestSuite {
    @Test
    public void testRecursiveImplementation() {
        RodCutting rc = new RecursiveImplementation();
        int p[] = new int[] {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

        Assert.assertEquals(1, rc.cutRod(p, 1));
        Assert.assertEquals(5, rc.cutRod(p, 2));
        Assert.assertEquals(8, rc.cutRod(p, 3));
        Assert.assertEquals(10, rc.cutRod(p,4));
        Assert.assertEquals(13, rc.cutRod(p,5));
        Assert.assertEquals(17, rc.cutRod(p,6));
        Assert.assertEquals(18, rc.cutRod(p,7));
        Assert.assertEquals(22, rc.cutRod(p,8));
        Assert.assertEquals(25, rc.cutRod(p,9));
        Assert.assertEquals(30, rc.cutRod(p,10));
    }

    @Test
    public void testRecursiveMemoImplementation() {
        RodCutting rc = new RecursiveMemoImplementation();
        int p[] = new int[] {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

        Assert.assertEquals(1, rc.cutRod(p, 1));
        Assert.assertEquals(5, rc.cutRod(p, 2));
        Assert.assertEquals(8, rc.cutRod(p, 3));
        Assert.assertEquals(10, rc.cutRod(p,4));
        Assert.assertEquals(13, rc.cutRod(p,5));
        Assert.assertEquals(17, rc.cutRod(p,6));
        Assert.assertEquals(18, rc.cutRod(p,7));
        Assert.assertEquals(22, rc.cutRod(p,8));
        Assert.assertEquals(25, rc.cutRod(p,9));
        Assert.assertEquals(30, rc.cutRod(p,10));
    }

    @Test
    public void testBottomUpImplementation() {
        RodCutting rc = new BottomUpImplementation();
        int p[] = new int[] {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

        Assert.assertEquals(1, rc.cutRod(p, 1));
        Assert.assertEquals(5, rc.cutRod(p, 2));
        Assert.assertEquals(8, rc.cutRod(p, 3));
        Assert.assertEquals(10, rc.cutRod(p,4));
        Assert.assertEquals(13, rc.cutRod(p,5));
        Assert.assertEquals(17, rc.cutRod(p,6));
        Assert.assertEquals(18, rc.cutRod(p,7));
        Assert.assertEquals(22, rc.cutRod(p,8));
        Assert.assertEquals(25, rc.cutRod(p,9));
        Assert.assertEquals(30, rc.cutRod(p,10));
    }
}
