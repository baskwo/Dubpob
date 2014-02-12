package org.dubpob.bird;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

@SuppressWarnings("serial")
public class Board extends JPanel implements MouseInputListener {
	
	private Image background = null;
	private Image bird = null;
	private int x = 40;
	private int y = 0;
	
	public Board() {
		createImage();
		super.addMouseListener(this);
	}
	
	private void createImage() {
		try {
			background = ImageIO.read(new File("Flappy-Bird.jpg"));
			bird = ImageIO.read(new File("bird.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		if(background != null)
			g2.drawImage(background, 0, 0, null);
		if(bird != null)
			g2.drawImage(bird, x, y, null);
		if(y > 400) {
			System.out.println("Dead");
			App.stopTimer();
			App.changeToMenu(this);
		}
		y += 5;
		
	}


	public void mouseClicked(MouseEvent arg0) {
		
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
		if(y < 65) {
			y = 0;
			return;
		}
		y -= 65;
	}

	public void mouseReleased(MouseEvent arg0) {
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
	}
}
