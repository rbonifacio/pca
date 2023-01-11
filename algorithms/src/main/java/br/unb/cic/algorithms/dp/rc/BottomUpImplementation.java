package br.unb.cic.algorithms.dp.rc;

import static br.unb.cic.algorithms.util.Max.max;

public class BottomUpImplementation implements RodCutting {
    @Override
    public int cutRod(int[] p, int n) {
        int r[] = new int[p.length];
        r[0] = 0;
        for(int j = 1; j <= n; j++) {
            int q = LESS_INFINITE;
            for(int i = 1; i <= j; i++) {
                q = max(q, p[i] + r[j-i]);
            }
            r[j] = q;
        }
        return r[n];
    }
}
