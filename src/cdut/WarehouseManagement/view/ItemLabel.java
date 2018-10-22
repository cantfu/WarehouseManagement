package cdut.WarehouseManagement.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class ItemLabel extends JLabel{
	public ItemLabel(String text)
	{
		super(text);
		this.setFont(new Font("微软雅黑",Font.PLAIN,24));
		this.setSize(100,50);
		this.setHorizontalAlignment(CENTER);
		this.setVerticalAlignment(CENTER);
		this.setForeground(Color.black);
	}
}
