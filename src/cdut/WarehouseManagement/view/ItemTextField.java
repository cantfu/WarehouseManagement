package cdut.WarehouseManagement.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class ItemTextField extends JTextField{
	
	public ItemTextField()
	{
		super();
		this.setBorder(new LineBorder(new Color(173,173,173),1));
		setSize(520,45);
		setFont(new Font("微软雅黑", Font.PLAIN,24));
		setForeground(Color.black);
		setOpaque(false);
		initListener();
	}
	public ItemTextField(int width,int height)
	{
		super();
		this.setBorder(new LineBorder(new Color(173,173,173),1));
		setSize(width,height);
		setFont(new Font("微软雅黑", Font.PLAIN,24));
		setForeground(Color.black);
		setOpaque(false);
		initListener();
	}
	
	private void initListener()
	{
		addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent e) {
				 if(isEnabled())
				 {
					 setBorder(new LineBorder(new Color(21,131,221),1));
				 }
			 }
			 public void mouseExited(MouseEvent e) {
				 if(isEnabled())
				 {
					 setBorder(new LineBorder(new Color(173,173,173),1));
				 }
			 }
		});
	}
}
