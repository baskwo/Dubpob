package org.dubpob.matrix.utils;

import org.dubpob.matrix.impl.SimpleMatrix;

public class MatrixHelper {
	public static SimpleMatrix getMinor(int i, int j, SimpleMatrix m) {
		SimpleMatrix minor = new SimpleMatrix(m.getHeight() - 1,m.getWidth() - 1);
		for(int a = 0; a < m.getHeight(); a++) {
			for(int b = 0; b < m.getWidth(); b++) {
				if(a == i || b == j)
					continue;
				else if(b > j && a > i)
					minor.getMatrix()[a-1][b-1] = m.getMatrix()[a][b];
				else if(b > j)
					minor.getMatrix()[a][b-1] = m.getMatrix()[a][b];
				else if(a > i) 
					minor.getMatrix()[a-1][b] = m.getMatrix()[a][b];
				else
					minor.getMatrix()[a][b] = m.getMatrix()[a][b];
				
			}
		}
		return minor;
	}
	
	public static SimpleMatrix multiply(SimpleMatrix A, SimpleMatrix B) {
		if(B.getHeight() != A.getWidth())
			return null;
		SimpleMatrix matrix = new SimpleMatrix(A.getHeight(), B.getWidth());
		for(int i = 0; i < matrix.getHeight(); i++) {
			for(int j = 0; j < matrix.getWidth(); j++) {
				int result = 0;
				for(int m = 0; m < A.getWidth(); m++) {
					result += A.getMatrix()[i][m]*B.getMatrix()[m][j];
				}
				matrix.getMatrix()[i][j] = result;
			}
		}
		return matrix;
	}
	
	public static SimpleMatrix multiply(SimpleMatrix A, int K) {
		SimpleMatrix matrix = new SimpleMatrix(A.getHeight(), A.getWidth());
		
		for(int i = 0; i < A.getHeight(); i++) {
			for(int j = 0; j < A.getWidth(); j++) {
				matrix.getMatrix()[i][j] = A.getMatrix()[i][j]*K;
			}
		}
		
		return matrix;
	}
	
	public static SimpleMatrix add(SimpleMatrix A, SimpleMatrix B) {
		if(A.getHeight() != B.getHeight() || A.getWidth() != B.getWidth())
			return null;
		SimpleMatrix matrix = new SimpleMatrix(A.getHeight(), A.getWidth());
		
		for(int i = 0; i < A.getHeight(); i++) {
			for(int j = 0; j < A.getWidth(); j++) {
				matrix.getMatrix()[i][j] = A.getMatrix()[i][j] + B.getMatrix()[i][j];
			}
		}
		
		return matrix;
	}
	
	public static SimpleMatrix subtract(SimpleMatrix A, SimpleMatrix B) {
		if(A.getHeight() != B.getHeight() || A.getWidth() != B.getWidth())
			return null;
		SimpleMatrix matrix = new SimpleMatrix(A.getHeight(), A.getWidth());
		
		for(int i = 0; i < A.getHeight(); i++) {
			for(int j = 0; j < A.getWidth(); j++) {
				matrix.getMatrix()[i][j] = A.getMatrix()[i][j] - B.getMatrix()[i][j];
			}
		}
		
		return matrix;
	}
}
