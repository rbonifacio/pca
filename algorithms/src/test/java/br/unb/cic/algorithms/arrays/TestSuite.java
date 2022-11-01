package br.unb.cic.algorithms.arrays;

import org.junit.Assert;
import org.junit.Test;

public class TestSuite {

    @Test
    public void maximumSubArray() {
        int array[] = new int[] {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};

        MaximumSubArray max = new MaximumSubArray();

        MaximumSubArray.Response res = max.maxSubArray(array);
        MaximumSubArray.Response expected = max.response(7, 10, 43);

        Assert.assertEquals(expected, res);

    }
}
