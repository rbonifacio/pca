package br.unb.cic.algorithms.dp.rc;

import static br.unb.cic.algorithms.util.Max.max;

public class RecursiveMemoImplementation implements RodCutting {

    @Override
    public int cutRod(int[] p, int n) {
        int [] r = new int[p.length];

        for(int i = 0; i < r.length; i++) {
            r[i] = LESS_INFINITE;
        }
        return cutRodAux(p, n, r);
    }

    private int cutRodAux(int[] p, int n, int[] r) {
        if(r[n] >= 0) {
            return r[n];
        }
        int q = LESS_INFINITE;
        if(n == 0) {
            q = 0;
        }
        else {
            for(int i = 1; i <= n; i++) {
                q = max(q, p[i] + cutRodAux(p, n - i, r));
            }
        }
        r[n] = q;
        return q;
    }
}
