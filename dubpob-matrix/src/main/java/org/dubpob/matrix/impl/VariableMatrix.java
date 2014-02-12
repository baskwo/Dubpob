package org.dubpob.matrix.impl;

import org.dubpob.matrix.Matrix;
import org.dubpob.matrix.utils.Variable;

public class VariableMatrix extends Matrix {
	private Variable[][] matrix = null;
	
	public VariableMatrix(int height,int width) {
		matrix = new Variable[height][width];
		this.height = height;
		this.width = width;
	}

	public Variable[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(Variable[][] matrix) {
		this.matrix = matrix;
	}

	@Override
	public String getTrace() {
		return "";
	}

	@Override
	public int getDeterminant() {
		return 0;
	}
}
