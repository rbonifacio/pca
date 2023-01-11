package br.unb.cic.algorithms.dp.rc;

import java.util.HashMap;
import java.util.Map;

import static br.unb.cic.algorithms.util.Max.max;

public class RecursiveImplementation implements RodCutting {
    @Override
    public int cutRod(int[] p, int n) {
        if(n == 0) {
            return 0;
        }
        int q = LESS_INFINITE;
        for(int i = 1; i <= n; i++) {
            q = max(q, p[i] + cutRod(p, n - i));
        }
        return q;
    }

}
