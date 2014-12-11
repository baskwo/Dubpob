package org.dubpob.snake.utils;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class SnakeTableRenderer extends JLabel implements TableCellRenderer {
	private static final long serialVersionUID = 6837905402135387734L;
	
	public SnakeTableRenderer() {
		setOpaque(true);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		
		Integer val = (int)value;
		switch(val) {
			case 0:
				setBackground(Color.GREEN);
				break;
			case 1:
				setBackground(Color.BLUE);
				break;
			case 2:
				setBackground(Color.RED);
				break;
				
			default:
				setBackground(Color.LIGHT_GRAY);
				break;
		}
		
		return this;
	}

}
