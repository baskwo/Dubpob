package org.dubpob.bird;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class App {
	private static App app = new App();
	private JFrame frame;
	private static Timer timer = null;
	public static int highScore = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					app.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void changeToBoard(JPanel panel) {
		app.frame.remove(panel);
		app.frame.add(new Board());
		app.frame.validate();
		
		ActionListener gameLoop = new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
		    	app.frame.repaint();
		   }
		};
		
		timer = new Timer(1000/60, gameLoop);
		timer.start();
	}
	
	public static void changeToMenu(JPanel panel) {
		app.frame.remove(panel);
		app.frame.add(new Menu());
		app.frame.validate();
	}
	
	public static void startTimer() {
		timer.start();
	}
	
	public static void stopTimer() {
		timer.stop();
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.frame = new JFrame();
		this.frame.setBounds(100, 100, 300, 530);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.add(new Menu());
	}

}
