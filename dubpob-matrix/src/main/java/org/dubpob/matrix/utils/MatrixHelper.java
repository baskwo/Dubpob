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
}
