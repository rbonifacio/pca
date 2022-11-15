package br.unb.cic.algorithms.arrays;

import br.unb.cic.algorithms.arrays.MaximumSubArray.Response;

public class MaximumSubArrayByBruteForce {
	
	public Response maxSubArray(int array[]) {
		
		int leftIndex = -1;
		int rightIndex = -1;
		int maxSum = -1;

		for (int i = 0; i < array.length; i++) {
			int currentSum = 0;
			for (int j = i; j < array.length; j++) {
				currentSum = currentSum+array[j];
				if(currentSum > maxSum) {
					leftIndex = i;
					rightIndex = j;
					maxSum = currentSum;
				}
			}
		}
		Response resp = new br.unb.cic.algorithms.arrays.MaximumSubArray().new Response(leftIndex, rightIndex, maxSum);
		return resp;
	}

}
