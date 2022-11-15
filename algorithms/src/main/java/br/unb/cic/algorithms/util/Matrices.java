package br.unb.cic.algorithms.util;

import java.util.LinkedList;
import java.util.List;

public class Matrices {

	public static boolean isEqual(int[][] A, int[][] B) {
		if (A == null || B == null) {
			return false;
		}
		if (A.length != B.length) {
			return false;
		}
		for (int i = 0; i < A.length; i++) {
			if (A[i] == null || B[i] == null) {
				return false;
			}
			if (A[i].length != B[i].length) {
				return false;
			}
			for (int j = 0; j < A[i].length; j++) {
				if (A[i][j] != B[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean isSquare(int[][] matrix) {
		if (matrix == null) {
			return false;
		}

		int rows = matrix.length;
		int cols = matrix.length > 0 ? matrix[0].length : 0;

		if (rows != cols) {
			return false;
		}
		return true;
	}

	public static void copyMatrix(int[][] src, int[][] dst, int srcStartY, int srcStartX, int dstStartY, int dstStartX,
			int lenY, int lenX) {
		for (int y = 0; y < lenY; y++) {
			for (int x = 0; x < lenX; x++) {
				try {
				dst[dstStartY + y][dstStartX + x] = src[srcStartY + y][srcStartX + x];
				}catch(ArrayIndexOutOfBoundsException e) {
					System.out.println(src);
					throw new RuntimeException("error");
				}
			}
		}
	}

	public static List<int[][]> splitIn4(int[][] M) {
		List<int[][]> result = new LinkedList<int[][]>();
		int nY = M.length;
		int midY = nY / 2;
		int nX = M[0].length;
		int midX = nX / 2;
		int[][] part1 = new int[midY][midX];
		copyMatrix(M, part1, 0, 0, 0, 0, midY, midX);
		int[][] part2 = new int[midY][nX - midX];
		copyMatrix(M, part2, 0, midX, 0, 0, midY, nX - midX);
		int[][] part3 = new int[nY - midY][midX];
		copyMatrix(M, part3, midY, 0, 0, 0, nY - midY, midX);
		int[][] part4 = new int[nY - midY][nX - midX];
		copyMatrix(M, part4, midY, midX, 0, 0, nY - midY, nX - midX);
		result.add(part1);
		result.add(part2);
		result.add(part3);
		result.add(part4);
		return result;
	}

	public static int[][] join4(int[][] A11, int[][] A12, int[][] A21, int[][] A22) {
		int ylen = A11.length + A21.length;
		int xlen = A11[0].length + A12[0].length;
		if (ylen != xlen) {
			throw new IllegalArgumentException("Matrices should join into a square matrix...");
		}
		int[][] C = new int[ylen][xlen];
		int n = C.length;
		int mid = n / 2;
		copyMatrix(A11, C, 0, 0, 0, 0, mid, mid);
		copyMatrix(A12, C, 0, 0, 0, mid, mid, n - mid);
		copyMatrix(A21, C, 0, 0, mid, 0, n - mid, mid);
		copyMatrix(A22, C, 0, 0, mid, mid, n - mid, n - mid);
		return C;
	}

	public static int[][] multiply(int[][] A, int[][] B) {
		// @formatter:off
		//  Being C = A*B We define C_ij as the following: ASCII art made with
		//  https://arthursonzogni.com/Diagon/#Math With input expression being C_ij =
		//  sum(A_ik*B_kj,k=0,n)
		//  
		//	       n            
		//	      ___           
		// C   =  ╲    A   ⋅ B  
		//  ij    ╱     ik    kj
		//	      ‾‾‾           
		//	     k = 0
		// @formatter:on
		// preconditions
		if (!Matrices.isSquare(A) || !Matrices.isSquare(B)) {
			throw new IllegalArgumentException("A and B should be square matrices");
		}
		if (A.length != B.length) {
			throw new IllegalArgumentException("A and B should have the same size");
		}

		int n = A.length;

		int[][] C = new int[n][n];
		// see page 75
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					C[i][j] = C[i][j] + A[i][k] * B[k][j];
				}
			}
		}
		return C;
	}

	public static int[][] scalarMultiply(int m, int[][] A) {
		int[][] C = new int[A.length][A.length];
		for (int y = 0; y < A.length; y++) {
			for (int x = 0; x < A[0].length; x++) {
				C[y][x] = A[y][x] * m;
			}
		}
		return C;
	}

	public static int[][] add(int[][] A, int[][] B) {
		// preconditions
		if (!Matrices.isSquare(A) || !Matrices.isSquare(B)) {
			throw new IllegalArgumentException("A and B should be square matrices");
		}
		if (A.length != B.length) {
			throw new IllegalArgumentException("A and B should have the same size");
		}
		int n = A.length;
		int[][] C = new int[n][n];
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				C[y][x] = A[y][x] + B[y][x];
			}
		}
		return C;
	}
	
	public static int[][] sub(int[][] A, int[][] B) {
		// preconditions
		if (!Matrices.isSquare(A) || !Matrices.isSquare(B)) {
			throw new IllegalArgumentException("A and B should be square matrices");
		}
		if (A.length != B.length) {
			throw new IllegalArgumentException("A and B should have the same size");
		}
		int n = A.length;
		int[][] C = new int[n][n];
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				C[y][x] = A[y][x] - B[y][x];
			}
		}
		return C;
	}

}
