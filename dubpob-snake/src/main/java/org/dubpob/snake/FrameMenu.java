package org.dubpob.snake;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

public class FrameMenu extends JFrame {

	private static final long serialVersionUID = 2083223231502693468L;
	private JPanel contentPane;
	private JButton btnSinglePlayer;
	private JButton btnMultiplayer;
	private JButton btnQuit;
	private JButton btnOptions;
	
	private static FrameMenu instance = null;
	
	public static FrameMenu getInstance() {
		if(instance == null) {
			instance = new FrameMenu();
		}
		return instance;
	}

	public static void main(String[] args) {
		for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                try {
					UIManager.setLookAndFeel(info.getClassName());
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
                break;
            }
        }
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					getInstance().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameMenu() {
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 149, 191);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		this.contentPane.add(getBtnSinglePlayer());
		this.contentPane.add(getBtnMultiplayer());
		this.contentPane.add(getBtnQuit());
		this.contentPane.add(getBtnOptions());
	}
	private JButton getBtnSinglePlayer() {
		if (btnSinglePlayer == null) {
			btnSinglePlayer = new JButton("Single Player");
			btnSinglePlayer.addActionListener(new BtnSinglePlayerActionListener());
			btnSinglePlayer.setBounds(10, 11, 104, 23);
		}
		return btnSinglePlayer;
	}
	private JButton getBtnMultiplayer() {
		if (btnMultiplayer == null) {
			btnMultiplayer = new JButton("Multiplayer");
			btnMultiplayer.setBounds(10, 45, 104, 23);
		}
		return btnMultiplayer;
	}
	private class BtnSinglePlayerActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			getInstance().setVisible(false);
			SingleSnake snake = SingleSnake.getInstance();
			snake.setVisible(true);
		}
	}
	private class BtnQuitActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			getInstance().dispatchEvent(new WindowEvent(getInstance(), WindowEvent.WINDOW_CLOSING));
		}
	}
	private JButton getBtnQuit() {
		if (btnQuit == null) {
			btnQuit = new JButton("Quit");
			btnQuit.addActionListener(new BtnQuitActionListener());
			btnQuit.setBounds(10, 113, 104, 23);
		}
		return btnQuit;
	}
	private JButton getBtnOptions() {
		if (btnOptions == null) {
			btnOptions = new JButton("Options");
			btnOptions.setBounds(10, 79, 104, 23);
		}
		return btnOptions;
	}
}
