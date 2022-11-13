package br.unb.cic.algorithms.matrices;


import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import br.unb.cic.algorithms.util.Matrices;

public class TestSuite {
	
	@Test
	public void testRecursiveMultiply2x2Matrix() {
		int[][] A = new int[2][2];
		int[][] B = new int[2][2];
		int[][] C = new int[2][2];
		A[0][0] = 1; A[0][1] = 2;
		A[1][0] = 3; A[1][1] = 4;
		
		B[0][0] = 2; B[0][1] = 0;
		B[1][0] = 1; B[1][1] = 2;
		
		C[0][0] = 4;  C[0][1] = 4;
		C[1][0] = 10; C[1][1] = 8;
		
		int[][] res = MatrixProduct.multiplyRecursive(A, B);
		Assert.assertTrue(Matrices.isEqual(C, res));
		
		int[][] res2 = MatrixProduct.multiplyStrassen(A, B);
		Assert.assertTrue(Matrices.isEqual(C, res2));
	}
	
	@Test
	public void testRecursiveMultiply5x5Matrix() {
		int matrixSize = 2<<3;
		int[][] A = new int[matrixSize][matrixSize];
		int[][] B = new int[matrixSize][matrixSize];
		for(int y=0;y<A.length;y++) {
			for(int x=0; x<A[0].length;x++) {
				A[y][x] = Integer.parseInt(y+""+x);
				B[y][x] = (int)(Math.random()*1000);
 			}
		}
		int[][] CbyRegularMult = Matrices.multiply(A, B);
		int[][] CbyRecursiveMult = MatrixProduct.multiplyRecursive(A, B);
		int[][] CbyStrassensMult = MatrixProduct.multiplyStrassen(A, B);
		
		Matrices.isEqual(CbyRegularMult, CbyRecursiveMult);
		Matrices.isEqual(CbyRegularMult, CbyStrassensMult);
	}
	
	@Test
	//@Ignore
	public void performanceComparison() {
		int matrixSize = 2<<10;
		int[][] A = new int[matrixSize][matrixSize];
		int[][] B = new int[matrixSize][matrixSize];
		for(int y=0;y<A.length;y++) {
			for(int x=0; x<A[0].length;x++) {
				A[y][x] = Integer.parseInt(y+""+x);
				B[y][x] = (int)(Math.random()*1000);
 			}
		}
		long startTime, timeSpentRegularMult, timeSpentRecursive, timeSpentStrassen;
		startTime = System.nanoTime();
		int[][] CbyRegularMult = Matrices.multiply(A, B);
		timeSpentRegularMult = System.nanoTime()-startTime;
		
		startTime = System.nanoTime();
		int[][] CbyRecursiveMult = MatrixProduct.multiplyRecursive(A, B);
		timeSpentRecursive = System.nanoTime()-startTime;
		
		startTime = System.nanoTime();
		int[][] CbyStrassensMult = MatrixProduct.multiplyStrassen(A, B);
		timeSpentStrassen = System.nanoTime()-startTime;
		
		Matrices.isEqual(CbyRegularMult, CbyRecursiveMult);
		Matrices.isEqual(CbyRegularMult, CbyStrassensMult);
		System.out.printf("Time spent n^3    method (): %d\n", timeSpentRegularMult);
		System.out.printf("Time spent n^3    recursive method: %d\n", timeSpentRecursive);
		System.out.printf("Time spent n^2.81 strassen'smethod: %d\n", timeSpentStrassen);
//		results for matrixSize = 2<<8		
//		Time spent n^3    method (default): 610286800
//		Time spent n^3    recursive method: 46992499100
//		Time spent n^2.81 strassen'smethod: 36378120300
	}

}
