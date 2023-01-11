package br.unb.cic.algorithms.util;

public class Max {

    public static  int max(int ... values) {
        int max = values[0];
        for(int i = 1; i < values.length; i++) {
            if(values[i] > max) {
                max = values[i];
            }
        }
        return max;
    }

}
