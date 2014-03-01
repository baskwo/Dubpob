package org.dubpob.matrix.utils;

import org.dubpob.matrix.TypeMatrix;

public class MatrixHelper {
	@SuppressWarnings("rawtypes")
	public static TypeMatrix getMinor(int i, int j, TypeMatrix m) {
		TypeMatrix minor = removeRowCol(i, j, m);
		return minor;
	}
	
	@SuppressWarnings("rawtypes")
	public static TypeMatrix removeRow(int a,TypeMatrix matrix) {
		TypeMatrix m = new TypeMatrix(matrix.getHeight()-1,matrix.getWidth());
		for(int i = 0; i < matrix.getHeight(); i++) {
			for(int j = 0; j < matrix.getWidth(); j++) {
				if(i == a)
					continue;
				else if(i > a)
					m.getMatrix()[i-1][j] = matrix.getMatrix()[i][j];
				else
					m.getMatrix()[i][j] = matrix.getMatrix()[i][j];
			}
		}
		return m;
	}
	
	@SuppressWarnings("rawtypes")
	public static TypeMatrix removeCol(int b,TypeMatrix matrix) {
		TypeMatrix m = new TypeMatrix(matrix.getHeight(),matrix.getWidth()-1);
		for(int i = 0; i < matrix.getHeight(); i++) {
			for(int j = 0; j < matrix.getWidth(); j++) {
				if(j == b)
					continue;
				else if(j > b)
					m.getMatrix()[i][j-1] = matrix.getMatrix()[i][j];
				else
					m.getMatrix()[i][j] = matrix.getMatrix()[i][j];
			}
		}
		return m;
	}
	
	@SuppressWarnings("rawtypes")
	public static TypeMatrix removeRowCol(int a,int b,TypeMatrix matrix) {
		TypeMatrix m = removeRow(a,removeCol(b,matrix));
		return m;
	}
	
	@SuppressWarnings("rawtypes")
	public static TypeMatrix getCofactors(TypeMatrix m) {
		TypeMatrix cof = new TypeMatrix(m.getHeight(), m.getWidth());
		for(int i = 0; i < m.getHeight(); i++) {
			for(int j = 0; j < m.getWidth(); j++) {
				TypeMatrix minor = getMinor(i,j,m);
				cof.getMatrix()[i][j] = (float) (Math.pow(-1, i+j)*minor.getDeterminant());
			}
		}
		return cof;
	}
	
	@SuppressWarnings("rawtypes")
	public static TypeMatrix getAdjudant(TypeMatrix m) {
		TypeMatrix adj = getAdjudantFromCofactors(getCofactors(m));
		return adj;
	}
	
	@SuppressWarnings("rawtypes")
	private static TypeMatrix getAdjudantFromCofactors(TypeMatrix m) {
		return transpose(m);
	}
	
	@SuppressWarnings("rawtypes")
	public static TypeMatrix transpose(TypeMatrix m) {
		TypeMatrix transpo = new TypeMatrix(m.getHeight(), m.getWidth());
		for(int i = 0; i < m.getHeight(); i++) {
			for(int j = 0; j < m.getWidth(); j++) {
				transpo.getMatrix()[j][i] = m.getMatrix()[i][j];
			}
		}
		return transpo;
	}
	
	@SuppressWarnings("rawtypes")
	public static TypeMatrix getInverse(TypeMatrix m) {
		float det = m.getDeterminant();
		if(det == 0)
			return null;
		TypeMatrix inv = multiply(getAdjudant(m),1/det);
		return inv;
	}
	
	@SuppressWarnings("rawtypes")
	public static TypeMatrix multiply(TypeMatrix A, TypeMatrix B) {
		if(B.getHeight() != A.getWidth())
			return null;
		TypeMatrix matrix = new TypeMatrix(A.getHeight(), B.getWidth());
		for(int i = 0; i < matrix.getHeight(); i++) {
			for(int j = 0; j < matrix.getWidth(); j++) {
				float result = 0;
				for(int m = 0; m < A.getWidth(); m++) {
					result += A.getMatrix()[i][m].floatValue()*B.getMatrix()[m][j].floatValue();
				}
				matrix.getMatrix()[i][j] = result;
			}
		}
		return matrix;
	}
	
	@SuppressWarnings("rawtypes")
	public static TypeMatrix multiply(TypeMatrix A, float K) {
		TypeMatrix matrix = new TypeMatrix(A.getHeight(), A.getWidth());
		
		for(int i = 0; i < A.getHeight(); i++) {
			for(int j = 0; j < A.getWidth(); j++) {
				matrix.getMatrix()[i][j] = A.getMatrix()[i][j].floatValue()*K;
			}
		}
		
		return matrix;
	}
	
	@SuppressWarnings("rawtypes")
	public static TypeMatrix add(TypeMatrix A, TypeMatrix B) {
		if(A.getHeight() != B.getHeight() || A.getWidth() != B.getWidth())
			return null;
		TypeMatrix matrix = new TypeMatrix(A.getHeight(), A.getWidth());
		
		for(int i = 0; i < A.getHeight(); i++) {
			for(int j = 0; j < A.getWidth(); j++) {
				matrix.getMatrix()[i][j] = A.getMatrix()[i][j].floatValue() + B.getMatrix()[i][j].floatValue();
			}
		}
		
		return matrix;
	}
	
	@SuppressWarnings("rawtypes")
	public static TypeMatrix subtract(TypeMatrix A, TypeMatrix B) {
		if(A.getHeight() != B.getHeight() || A.getWidth() != B.getWidth())
			return null;
		TypeMatrix matrix = new TypeMatrix(A.getHeight(), A.getWidth());
		
		for(int i = 0; i < A.getHeight(); i++) {
			for(int j = 0; j < A.getWidth(); j++) {
				matrix.getMatrix()[i][j] = A.getMatrix()[i][j].floatValue() - B.getMatrix()[i][j].floatValue();
			}
		}
		
		return matrix;
	}
}
