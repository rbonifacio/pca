package br.unb.cic.algorithms.util;

import static  java.util.Arrays.copyOfRange;

public class Arrays {

    public static int[] split(int array[], int start) {
        return split(array, start, array.length);
    }

    public static int[] split(int array[], int start, int end) {
        return java.util.Arrays.copyOfRange(array, start, end);
    }
}
