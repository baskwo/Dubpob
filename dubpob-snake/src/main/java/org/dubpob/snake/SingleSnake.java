package org.dubpob.snake;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import org.dubpob.snake.utils.SnakeKeysListener;
import org.dubpob.snake.utils.SnakeTableModel;
import org.dubpob.snake.utils.SnakeTableRenderer;

import java.awt.Color;

public class SingleSnake extends JFrame {
	
	private static final long serialVersionUID = -1505821658878077702L;
	
	private static SingleSnake instance = null;
	
	public static SingleSnake getInstance() {
		if(instance == null) {
			instance = new SingleSnake();
		}
		return instance;
	}
	
	public static final int SIZE = 10;
	
	private JPanel contentPane;
	private JTable table;


	public SingleSnake() {
		initComponents();
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addKeyListener(new SnakeKeysListener());
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		this.contentPane.add(getTable());
		this.contentPane.setBackground(Color.BLACK);
		this.setResizable(false);
		this.contentPane.setPreferredSize(new Dimension(16*SIZE, 16*SIZE));
		this.pack();
	}
	
	private JTable getTable() {
		if (table == null) {
			table = new JTable(getTableModel());
			table.setBackground(Color.WHITE);
			table.setEnabled(false);
			table.setRowSelectionAllowed(false);
			table.setDefaultRenderer(Integer.class, new SnakeTableRenderer());
			table.setBounds(0, 0, 434, 262);
			table.setRowHeight(16);
			
			for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
		        TableColumn column = table.getColumnModel().getColumn(i);
		        column.setMinWidth(16);
	            column.setMaxWidth(16);
		        column.setPreferredWidth(16);
		    }
		}
		return table;
	}
	
	private TableModel getTableModel() {
		SnakeTableModel model = new SnakeTableModel(SIZE,SIZE);
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				model.setValueAt(-1, i, j);
			}
		}
		return model;
	}
}
