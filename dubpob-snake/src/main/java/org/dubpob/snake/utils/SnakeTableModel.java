package org.dubpob.snake.utils;

import javax.swing.table.AbstractTableModel;

public class SnakeTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 8135939482852488356L;
	
	private Object[][] data = null;
	
	public SnakeTableModel(int rowCount, int columnCount) {
		data = new Object[rowCount][columnCount];
	}

	@Override
	public int getColumnCount() {
		if(data == null) {
			return 0;
		}
		return data[0].length;
	}

	@Override
	public int getRowCount() {
		if(data == null) {
			return 0;
		}
		return data.length;
	}

	@Override
	public Object getValueAt(int row, int column) {
		return data[row][column];
	}
	
	@Override
	public void setValueAt(Object value, int row, int column) {
		data[row][column] = value;
		fireTableCellUpdated(row, column);
	}
	
	@Override
	public boolean isCellEditable(int row, int col) { 
		return false;
	}
	
	@Override
	public Class<?> getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

}
