package org.dubpob.matrix.impl;

import org.dubpob.matrix.TypeMatrix;

public class SimpleMatrix extends TypeMatrix<Float> {
	
	
	public SimpleMatrix(int height,int width,String m) {
		super(height,width);
		matrix = new Float[height][width];
		
		String[] lines = m.split("\n");
		
		if(lines.length != height) {
			try {
				throw new Exception("Error on matrix lines");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		for(int i = 0; i < lines.length; i++) {
			String line = lines[i];
			String[] columns = line.split(" ");
			
			if(columns.length != width) {
				try {
					throw new Exception("Error on matrix columns");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			for(int j = 0; j < columns.length; j++) {
				matrix[i][j] = Float.parseFloat(columns[j]);
			}
		}
	}
	
}
