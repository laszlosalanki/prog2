import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.*;

public class JFC extends Frame implements KeyListener {
	
	GraphicsEnvironment ge;
	GraphicsDevice gd;
	
	
	JTextArea jta;
	JLabel lbl;
	
	public JFC() {
		
		ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		gd = ge.getDefaultScreenDevice();
		jta = new JTextArea();
		lbl = new JLabel();
		
		setUndecorated(true);
		setResizable(false);

		jta.setText("Debreceni Egyetem");
		jta.setEditable(false);
		
		BufferedImage img = readImage();
		int w = img.getWidth();
		int h = img.getHeight();
		while(w > 1024 || h > 1024) {
			w /= 1.5;
			h /= 1.5;
		}
		Image tmp = img.getScaledInstance(w, h, Image.SCALE_AREA_AVERAGING);
		ImageIcon ii = new ImageIcon(tmp);
		lbl.setIcon(ii);
		
		if(gd.isFullScreenSupported()) {
			gd.setFullScreenWindow(this);
			addKeyListener(this);
		}

		gd.getFullScreenWindow().setLayout(new FlowLayout());
		gd.getFullScreenWindow().add(jta);
		gd.getFullScreenWindow().add(lbl);
		gd.getFullScreenWindow().getFocusableWindowState();
		
	}
	
	public BufferedImage readImage() {
		BufferedImage image = null;
		try {
			//beolvasando kep
			image = ImageIO.read(new File("kep.png"));
		} catch (IOException e) {
			
		}
		return image;
	}
	
	public void keyTyped(KeyEvent ke) {
		char key = ke.getKeyChar();
		if(key == 'x')
			System.exit(0);
	}
	
	public void keyPressed(KeyEvent ke) {
		
	}
	
	public void keyReleased(KeyEvent ke) {
		
	}
	
	public static void main(String[] args) {
		new JFC();
	}
}
