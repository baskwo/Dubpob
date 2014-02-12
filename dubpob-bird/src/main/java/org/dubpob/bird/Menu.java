package org.dubpob.bird;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Menu extends JPanel implements MouseListener {
	private Image background = null;
	private Image play = null;
	
	public Menu() {
		createImage();
		super.addMouseListener(this);
	}
	
	private void createImage() {
		try {
			background = ImageIO.read(new File("Flappy-Bird.jpg"));
			play = ImageIO.read(new File("playButton.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		if(background != null)
			g2.drawImage(background, 0, 0, null);
		if(play != null)
			g2.drawImage(play, 90, 215, null);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		Point p = arg0.getLocationOnScreen();
		if(p.x >= 90 && p.y >= 215) {
			App.changeToBoard(this);
		}
			
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
