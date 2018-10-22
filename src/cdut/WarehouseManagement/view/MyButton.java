package cdut.WarehouseManagement.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class MyButton extends JButton {
	static MyButton temp;
	public MyButton(String text) {
		this.setText(text);
		this.setFont(new Font("微软雅黑", Font.PLAIN,25));
		this.setFocusPainted(false);
		this.setBackground(new   Color(248,234,208));
		this.setForeground(new Color(35,172,151));
		this.setBorder(new LineBorder(new Color(42,56,70),0));
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setForeground(new Color(255,255,255));
				setBackground(new Color(209,194,139));
				setTemp();
			}
		});
	}
	
	private void setTemp()
	{
		if(temp!=this)
		{
			temp.setBackground(new   Color(248,234,208));
			temp.setForeground(new Color(37,171,150));
			temp=this;
		}
	}
}
