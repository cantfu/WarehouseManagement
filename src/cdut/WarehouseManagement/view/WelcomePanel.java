package cdut.WarehouseManagement.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class WelcomePanel extends JPanel{
	Image image;
	public WelcomePanel(Image image){
		this.image= image;
		this.setBorder(new LineBorder(new Color(42,56,70),0));
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(image,0,0,this.getWidth(),this.getHeight(),this);
	}
}
