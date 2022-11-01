package br.unb.cic.algorithms.arrays;

import java.util.Objects;

import static br.unb.cic.algorithms.util.Arrays.*;

public class MaximumSubArray {

    private static final int LESS_INFINITE = Integer.MIN_VALUE;

    public Response response(int low, int high, int sum) {
        return new Response(low, high, sum);
    }

    class Response implements Comparable<Response> {
        int sum = 0;
        int low = 0;
        int high = 0;

        public Response(int low, int high, int sum) {
            this.low = low;
            this.high = high;
            this.sum = sum;
        }

        @Override
        public int compareTo(Response o) {
            return new Integer(sum).compareTo(new Integer(o.sum));
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Response response = (Response) o;
            return sum == response.sum && low == response.low && high == response.high;
        }

        public String toString() {
            return String.format("(%d, %d, %d)", low, high, sum);
        }

    }

    public Response maxSubArray(int array[]) {
        if(array.length == 1) {
            return new Response(0, 0, array[0]);
        }

        int mid = array.length / 2;

        Response left = maxSubArray(split(array, 0, mid));
        Response right = maxSubArray(split(array, mid));
        Response crossing = findMaxCrossingSubarray(array);

        if(left.compareTo(right) > 0 && left.compareTo(crossing) > 0) {
            return left;
        }
        else if(right.compareTo(left) > 0 && right.compareTo(crossing) > 0) {
            return right;
        }
        else {
            return crossing;
        }
    }

    public Response findMaxCrossingSubarray(int array[]) {
        int mid = array.length / 2;

        int leftSum = LESS_INFINITE;
        int leftIndex = mid;
        int currentSum = 0;

        for(int i = mid - 1; i >= 0; i--) {
            currentSum = currentSum + array[i];
            if(currentSum > leftSum) {
                leftSum = currentSum;
                leftIndex = i;
            }
        }

        int rightSum = LESS_INFINITE;
        int rightIndex = mid;
        currentSum = 0;

        for(int j = mid; j < array.length; j++) {
            currentSum = currentSum + array[j];
            if(currentSum > rightSum) {
                rightSum = currentSum;
                rightIndex = j;
            }
        }
        return new Response(leftIndex, rightIndex, leftSum+rightSum);
    }

}
