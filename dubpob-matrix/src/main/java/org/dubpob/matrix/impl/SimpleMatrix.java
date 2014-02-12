package org.dubpob.matrix.impl;

import org.dubpob.matrix.Matrix;

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
}
