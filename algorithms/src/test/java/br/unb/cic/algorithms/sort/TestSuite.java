package br.unb.cic.algorithms.sort;

import java.util.Arrays;

import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.*;

public class TestSuite {

    @Test
    public void testInsertionSort() {
        int original[] = new int[]{5, 2, 4, 6, 1, 3};
        int expected[] = new int[]{1, 2, 3, 4, 5, 6};

        AbstractSort sort = new InsertionSort();

        int res[] = sort.sort(original);

        assertEquals(6, res.length);
        assertTrue(Arrays.equals(expected, res));
    }

    @Test
    public void testInsertionSortOnEmptyArray() {
        int original[] = new int[]{};
        int expected[] = new int[]{};

        AbstractSort sort = new InsertionSort();

        int res[] = sort.sort(original);

        assertEquals(0, res.length);
        assertTrue(Arrays.equals(expected, res));
    }

    @Test
    public void testMergeSort() {
        int original[] = new int[]{5, 2, 4, 6, 1, 3};
        int expected[] = new int[]{1, 2, 3, 4, 5, 6};

        AbstractSort sort = new MergeSort();

        int res[] = sort.sort(original);

        assertEquals(6, res.length);

        assertTrue(Arrays.equals(expected, res));
    }

    @Test
    public void testMerge() {
        int l[] = new int[]{1, 3, 4};
        int r[] = new int[]{2, 5, 6};

        int expected[] = new int[]{1, 2, 3, 4, 5, 6};

        MergeSort sort = new MergeSort();

        int res[] = sort.merge(l, r);

        assertEquals(6, res.length);
        assertTrue(Arrays.equals(expected, res));
    }
}
