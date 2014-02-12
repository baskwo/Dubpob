package org.dubpob.matrix;

public abstract class Matrix {
	protected int height = 0;
	protected int width = 0;
	
	public abstract String getTrace();
	public abstract int getDeterminant();

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
