package br.unb.cic.algorithms.sort;

import static br.unb.cic.algorithms.util.Arrays.*;

public class MergeSort implements AbstractSort {

    @Override
    public int[] sort(int a[]) {
        if (a.length <= 1) return a; // base case of recursion.

        int mid = a.length / 2;

        int left[] = this.sort(split(a, 0, mid));
        int right[] = this.sort(split(a, mid));

        return merge(left, right);
    }

    public int[] merge(int l[], int r[]) {
        int size = l.length + r.length;
        int res[] = new int[size];
        int i = 0, j = 0, k = 0;

        while ((i < l.length) && (j < r.length)) {
            if (l[i] <= r[j]) {
                res[k++] = l[i++];
            } else {
                res[k++] = r[j++];
            }
        }
        while (i < l.length) {
            res[k++] = l[i++];
        }
        while (j < r.length) {
            res[k++] = r[j++];
        }
        return res;
    }
}
