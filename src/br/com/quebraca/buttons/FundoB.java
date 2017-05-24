package br.com.quebraca.buttons;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class FundoB extends JPanel {
	private static final long serialVersionUID = -7609370604002887963L;

	private String pathImage = "";

	public FundoB() {
	}

	public FundoB(String pathImage) {
		this.pathImage = pathImage;
	}

	@Override

	public void paintComponent(Graphics g) {

		Graphics2D gr = (Graphics2D) g.create();

		try {

			BufferedImage buffer = ImageIO.read(new File(pathImage));
			gr.drawImage(buffer, null, 0, 0);

		} catch (IOException ex) {
			Logger.getLogger(FundoB.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
}
