package org.dubpob.matrix;

import org.dubpob.matrix.utils.MatrixHelper;

public class TypeMatrix<T extends Number> {
	protected Number[][] matrix = null;
	
	protected int height = 0;
	protected int width = 0;
	
	public TypeMatrix(int height, int width) {
		this.height = height;
		this.width = width;
		matrix = new Number[height][width];
	}
	
	public Number[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(Number[][] matrix) {
		this.matrix = matrix;
	}

	public String getTrace() {
		if(height == width) {
			float trace = 0;
			for(int i = 0; i < height; i++) {
				trace += matrix[i][i].floatValue();
			}
			return Float.toString(trace);
		}
		return "";
	}

	public float getDeterminant() {
		float value = 0;
		if(width == height && matrix != null) {
			switch(width) {
				case 1:
					value = matrix[0][0].floatValue();
				break;
				case 2:
					value = (matrix[0][0].floatValue()*matrix[1][1].floatValue()) - (matrix[0][1].floatValue()*matrix[1][0].floatValue());
				break;
				default://Always first line (i=0)
					for(int j = 0; j < width; j++) {
						value += (j % 2 == 0 ? 1 : -1)*matrix[0][j].floatValue()*MatrixHelper.getMinor(0, j, this).getDeterminant();
					}
				break;
			}
		}
		return value;
	}

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
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
}
