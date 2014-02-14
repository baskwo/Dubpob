package org.dubpob.matrix.impl;

import org.dubpob.matrix.Matrix;
import org.dubpob.matrix.utils.MatrixHelper;

public class SimpleMatrix extends Matrix {
	private int[][] matrix = null;
	
	
	public SimpleMatrix(int height,int width) {
		matrix = new int[height][width];
		this.height = height;
		this.width = width;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
	
	@Override
	public String getTrace() {
		if(height == width) {
			int trace = 0;
			for(int i = 0; i < height; i++) {
				trace += matrix[i][i];
			}
			return Integer.toString(trace);
		}
		return "";
	}

	@Override
	public int getDeterminant() {
		int value = 0;
		if(width == height && matrix != null) {
			switch(width) {
				case 1:
					value = matrix[0][0];
				break;
				case 2:
					value = (matrix[0][0]*matrix[1][1]) - (matrix[0][1]*matrix[1][0]);
				break;
				default://Always first line (i=0)
					for(int j = 0; j < width; j++) {
						value += (j % 2 == 0 ? 1 : -1)*matrix[0][j]*MatrixHelper.getMinor(0, j, this).getDeterminant();
					}
				break;
			}
		}
		return value;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < getHeight(); i++) {
			builder.append("[ ");
			for(int j = 0; j < getWidth(); j++) {
				builder.append(matrix[i][j] + " ");
			}
			builder.append("]").append("\n");
		}
		return builder.toString();
	}
}
