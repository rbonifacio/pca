package br.unb.cic.algorithms.util;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.unb.cic.algorithms.matrices.MatrixProduct;


public class TestSuite {
	
	
	@Test
	public void testMatricesUtil() {
		// @formatter:off
		int[][] Amatrix = new int[2][2];
		int[][] Bmatrix = new int[2][2];
		int[][] Cmatrix = new int[2][2];
		Amatrix[0][0] = 1; Amatrix[0][1] = 2;
		Amatrix[1][0] = 3; Amatrix[1][1] = 4;
		
		Bmatrix[0][0] = 2; Bmatrix[0][1] = 0;
		Bmatrix[1][0] = 1; Bmatrix[1][1] = 2;
		
		Cmatrix[0][0] = 4; Cmatrix[0][1] = 4;
		Cmatrix[1][0] = 10; Cmatrix[1][1] = 8;
		
		Assert.assertTrue(Matrices.isEqual(Amatrix, Amatrix));
		Assert.assertFalse(Matrices.isEqual(Amatrix, Bmatrix));
		
		Matrices.copyMatrix(Amatrix, Bmatrix, 0, 0, 0, 0, 2, 2);
		Assert.assertTrue(Matrices.isEqual(Amatrix, Bmatrix));
		
		List<int[][]> dividedBy4 = Matrices.splitIn4(Amatrix);
		Assert.assertArrayEquals(dividedBy4.get(0)[0], new int[] {1});
		Assert.assertArrayEquals(dividedBy4.get(1)[0], new int[] {2});
		Assert.assertArrayEquals(dividedBy4.get(2)[0], new int[] {3});
		Assert.assertArrayEquals(dividedBy4.get(3)[0], new int[] {4});
		
		int[][] joinedAgain = Matrices.join4(dividedBy4.get(0), dividedBy4.get(1), dividedBy4.get(2), dividedBy4.get(3));
		Assert.assertTrue(Matrices.isEqual(joinedAgain, Amatrix));
		
		int[][] Dmatrix = new int[5][5];
		Dmatrix[0][0] = 55; Dmatrix[0][1] = 41; Dmatrix[0][2] = 16; Dmatrix[0][3] = 52;  Dmatrix[0][4] = 1;
		Dmatrix[1][0] = 21; Dmatrix[1][1] = 98; Dmatrix[1][2] = 86; Dmatrix[1][3] = 62;  Dmatrix[1][4] = 2;
		Dmatrix[2][0] = 62; Dmatrix[2][1] = 23; Dmatrix[2][2] = 67; Dmatrix[2][3] = 55;  Dmatrix[2][4] = 3;
		Dmatrix[3][0] = 12; Dmatrix[3][1] = 11; Dmatrix[3][2] = 82; Dmatrix[3][3] = 29;  Dmatrix[3][4] = 4;
		Dmatrix[4][0] = 10; Dmatrix[4][1] = 22; Dmatrix[4][2] = 13; Dmatrix[4][3] = 23;  Dmatrix[4][4] = 5;
		
		int[][] Ematrix = new int[5][5];
		Ematrix[0][0] = 55; Ematrix[0][1] = 41; Ematrix[0][2] = 16; Ematrix[0][3] = 52;  Ematrix[0][4] = 1;
		Ematrix[1][0] = 21; Ematrix[1][1] = 98; Ematrix[1][2] = 86; Ematrix[1][3] = 62;  Ematrix[1][4] = 2;
		Ematrix[2][0] = 62; Ematrix[2][1] = 23; Ematrix[2][2] = 67; Ematrix[2][3] = 55;  Ematrix[2][4] = 3;
		Ematrix[3][0] = 12; Ematrix[3][1] = 11; Ematrix[3][2] = 82; Ematrix[3][3] = 29;  Ematrix[3][4] = 4;
		Ematrix[4][0] = 10; Ematrix[4][1] = 22; Ematrix[4][2] = 13; Ematrix[4][3] = 23;  Ematrix[4][4] = 5;
		
		int[][] Fmatrix = new int[5][5];
		Assert.assertTrue(Matrices.isEqual(Dmatrix, Dmatrix));
		Assert.assertFalse(Matrices.isEqual(Dmatrix, Fmatrix));
		Matrices.copyMatrix(Dmatrix, Fmatrix, 0, 0, 0, 0, 5, 5);
		Assert.assertTrue(Matrices.isEqual(Dmatrix, Fmatrix));
		
		List<int[][]> DdividedBy4 = Matrices.splitIn4(Dmatrix);
		//this is the expectd division:
		//[55, 41, | 16, 52, 1], 
		//[21, 98, | 86, 62, 2], 
		//_______________________
		//[62, 23, | 67, 55, 3], 
		//[12, 11, | 82, 29, 4], 
		//[10, 22, | 13, 23, 5]
		int[][] DjoinedAgain = Matrices.join4(DdividedBy4.get(0), DdividedBy4.get(1), DdividedBy4.get(2), DdividedBy4.get(3));
		Assert.assertTrue(Matrices.isEqual(DjoinedAgain, Dmatrix));
		System.out.println(DdividedBy4);
		// @formatter:on
	}
	
	@Test
	public void split4Tests() {
		// @formatter:off
		int[][] A = new int[3][2];
		for(int y=0;y<A.length;y++) {
			for(int x=0; x<A[0].length;x++) {
				A[y][x] = Integer.parseInt(y+""+x);
			}
		}
		List<int[][]> Asplited = Matrices.splitIn4(A);
		System.out.println(Asplited);
	}
	
	@Test
	public void regularMultiplyAndAdditinTests() {
		// @formatter:off
		int[][] A = new int[2][2];
		int[][] B = new int[2][2];
		int[][] C = new int[2][2];
		int[][] D = new int[2][2];
		A[0][0] = 1; A[0][1] = 2;
		A[1][0] = 3; A[1][1] = 4;
		
		B[0][0] = 2; B[0][1] = 0;
		B[1][0] = 1; B[1][1] = 2;
		
		C[0][0] = 4;  C[0][1] = 4;
		C[1][0] = 10; C[1][1] = 8;
		
		int[][] res = Matrices.multiply(A, B);
		Assert.assertTrue(Matrices.isEqual(C, res));
		
		D[0][0] = 6;  D[0][1] = 4;
		D[1][0] = 11; D[1][1] = 10;
		Assert.assertTrue(Matrices.isEqual(D, Matrices.add(B, C)));
		
		// @formatter:on
	}

}
