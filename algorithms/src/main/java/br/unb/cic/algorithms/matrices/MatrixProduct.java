package br.unb.cic.algorithms.matrices;

import java.util.List;

import br.unb.cic.algorithms.util.Matrices;

/**
 * 
 *
 * @author leosol
 *
 */
public class MatrixProduct {

	public static int[][] multiplyRecursive(int[][] A, int[][] B) {
		// preconditions
		if (!Matrices.isSquare(A) || !Matrices.isSquare(B)) {
			throw new IllegalArgumentException("A and B should be square matrices");
		}
		if (A.length != B.length) {
			throw new IllegalArgumentException("A and B should have the same size");
		}
		int n = A.length;
		if (n == 1) {
			int[][] C = new int[1][1];
			C[0][0] = A[0][0] * B[0][0];
			return C;
		} else {
			List<int[][]> AParts = Matrices.splitIn4(A);
			List<int[][]> BParts = Matrices.splitIn4(B);
			int[][] A11 = AParts.get(0);
			int[][] A12 = AParts.get(1);
			int[][] A21 = AParts.get(2);
			int[][] A22 = AParts.get(3);

			int[][] B11 = BParts.get(0);
			int[][] B12 = BParts.get(1);
			int[][] B21 = BParts.get(2);
			int[][] B22 = BParts.get(3);

			int[][] C11 = Matrices.add(multiplyRecursive(A11, B11), multiplyRecursive(A12, B21));
			int[][] C12 = Matrices.add(multiplyRecursive(A11, B12), multiplyRecursive(A12, B22));
			int[][] C21 = Matrices.add(multiplyRecursive(A21, B11), multiplyRecursive(A22, B21));
			int[][] C22 = Matrices.add(multiplyRecursive(A21, B12), multiplyRecursive(A22, B22));

			return Matrices.join4(C11, C12, C21, C22);
		}
	}

	public static int[][] multiplyStrassen(int[][] A, int[][] B) {
		// preconditions
		if (!Matrices.isSquare(A) || !Matrices.isSquare(B)) {
			throw new IllegalArgumentException("A and B should be square matrices");
		}
		if (A.length != B.length) {
			throw new IllegalArgumentException("A and B should have the same size");
		}
		int n = A.length;
		if (n == 1) {
			int[][] C = new int[1][1];
			C[0][0] = A[0][0] * B[0][0];
			return C;
		} else {
			List<int[][]> AParts = Matrices.splitIn4(A);
			List<int[][]> BParts = Matrices.splitIn4(B);
			int[][] A11 = AParts.get(0);
			int[][] A12 = AParts.get(1);
			int[][] A21 = AParts.get(2);
			int[][] A22 = AParts.get(3);

			int[][] B11 = BParts.get(0);
			int[][] B12 = BParts.get(1);
			int[][] B21 = BParts.get(2);
			int[][] B22 = BParts.get(3);
			
			int[][] S01 = Matrices.sub(B12, B22);
			int[][] S02 = Matrices.add(A11, A12);
			int[][] S03 = Matrices.add(A21, A22);
			int[][] S04 = Matrices.sub(B21, B11);
			int[][] S05 = Matrices.add(A11, A22);
			int[][] S06 = Matrices.add(B11, B22);
			int[][] S07 = Matrices.sub(A12, A22);
			int[][] S08 = Matrices.add(B21, B22);
			int[][] S09 = Matrices.sub(A11, A21);
			int[][] S10 = Matrices.add(B11, B12);
			
			int[][] P1 = multiplyStrassen(A11, S01);
			int[][] P2 = multiplyStrassen(S02, B22);
			int[][] P3 = multiplyStrassen(S03, B11);
			int[][] P4 = multiplyStrassen(A22, S04);
			int[][] P5 = multiplyStrassen(S05, S06);
			int[][] P6 = multiplyStrassen(S07, S08);
			int[][] P7 = multiplyStrassen(S09, S10);
			
			int[][] C11 = Matrices.add(Matrices.sub(Matrices.add(P5, P4), P2), P6);
			int[][] C12 = Matrices.add(P1,P2);
			int[][] C21 = Matrices.add(P3,P4);
			int[][] C22 = Matrices.sub(Matrices.add(P5,P1), Matrices.add(P3, P7));

			return Matrices.join4(C11, C12, C21, C22);
		}
	}

}
