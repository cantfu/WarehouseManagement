package cdut.WarehouseManagement.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import cdut.WarehouseManagement.tools.JDBCUtils;

public class LoginWindow extends JFrame{
	private JSplitPane SplitePane;
	private JPanel topPanel;
	private JPanel bottomPanel;
	private JButton closeButton;
	private JTextField account;
	private JPasswordField password;
	private JButton logButton;
	private JLabel face;
	public static InputStream inputStream;
	private boolean state = false;
	private String ID="A00001";
	
	
	int x;
	int y;
	private void setX(int x)
	{
		this.x=x;
	}
	private void setY(int y)
	{
		this.y=y;
	}
	public LoginWindow() {
		initButton();
		initFace();
		initTopPanel();
		initBottomPanel();
		initSplitPane();
		initWindow();
	}
	
	private void initWindow()
	{
		setSize(540, 415);
		this.setUndecorated(true);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((d.width-540)/2,(d.height-415)/2);
		this.setIconImage(new ImageIcon("lib/cangku.png").getImage());
		this.add(SplitePane);
	}
	private void initFace()
	{
		face=new JLabel();
		face.setSize(100,100);
		face.setBackground(Color.black);
		face.setBorder(new LineBorder(new Color(220,220,220),1));
	}
	private void initButton()
	{
		closeButton=new JButton("\u00D7");
		closeButton.setContentAreaFilled(false);
		closeButton.setSize(40, 40);
		closeButton.setForeground(new Color(238,238,238));
		closeButton.setBackground(new Color(211,64,39));
		closeButton.setFocusPainted(false);
		closeButton.setBorder(new LineBorder(Color.white,0));
		closeButton.setFont(new Font("微软雅黑", Font.PLAIN,30));
		closeButton.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e)
			{
				setVisible(false);
				System.exit(1);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				closeButton.setContentAreaFilled(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				closeButton.setContentAreaFilled(false);
			}
		});
	}
	
    private void initTopPanel()
	{
		topPanel=new JPanel();
		ImageIcon image = new ImageIcon("lib/tut.gif");
		image.setImage(image.getImage().getScaledInstance(539, 230,Image.SCALE_DEFAULT));
		JLabel label=new JLabel();
		label.setIcon(image);
		label.setLayout(null);
		label.add(closeButton);
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				setX(e.getX());
				setY(e.getY());
			}
		});
		label.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				int x1 = getLocation().x;
				int y1 = getLocation().y;
				setLocation(x1 + e.getX() - x, y1 + e.getY() - y);
			}
		});
		closeButton.setLocation(500,0);
		topPanel.setLayout(new GridLayout(1, 1));
		topPanel.add(label);
	}
	
    private void initBottomPanel()
	{
		account=new JTextField();
		account.setBorder(new LineBorder(new Color(209,209,209),0));
		account.setText("  账   号");
		account.setForeground(new Color(209,209,209));
		account.setFont(new Font("微软雅黑",Font.PLAIN,17));
		account.addKeyListener(new KeyListener() {			
			@Override
			public void keyTyped(KeyEvent e) {
				String temp=account.getText();
				if(e.getKeyChar()>KeyEvent.VK_9||e.getKeyChar()<KeyEvent.VK_0||temp.length()==10)
					e.consume();
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
		account.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				String temp=account.getText();
				if(temp!="")
				{
					if(JDBCUtils.ReadImageAccount(temp)){
						byte[] bs;
						bs = JDBCUtils.toBArray(inputStream);
						ImageIcon imageIcon = new ImageIcon(bs);
						imageIcon.setImage((imageIcon.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT)));
						face.setIcon(imageIcon);						
				    }
					else
					{
						face.setIcon(null);
					}
				}
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				String temp=account.getText();
				if(temp!="")
				{
					if(JDBCUtils.ReadImageAccount(temp)){
						byte[] bs;
						bs = JDBCUtils.toBArray(inputStream);
						ImageIcon imageIcon = new ImageIcon(bs);
						imageIcon.setImage((imageIcon.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT)));
						face.setIcon(imageIcon);						
				    }
					else
					{
						face.setIcon(null);
					}
				}
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {

			}
		});
	
		account.addFocusListener(new FocusListener() {	
			@Override
			public void focusLost(FocusEvent e) {
				if(account.getText().equals(""))
				{
					account.setText("  账   号");
					account.setForeground(new Color(209,209,209));
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if(account.getText().equals("  账   号"))
				{
					account.setText(null);
				}
				account.setForeground(Color.black);
			}
		});
	
		
		password=new JPasswordField();
		password.setBorder(new LineBorder(new Color(209,209,209),0));
		password.setText("  密   码");
		char c=password.getEchoChar();
		password.setEchoChar((char) 0); 
		password.setForeground(new Color(209,209,209));
		password.setFont(new Font("微软雅黑",Font.PLAIN,17));
		password.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				char s = e.getKeyChar();
				String temp=password.getText();
				if(temp.length()<12&&((s<='9'&&s>='0')||(s<='Z'&&s>='A')||(s<='z'&&s>='a')))
				{}
				else if(s == KeyEvent.VK_ENTER){
					if(JDBCUtils.getAccountInfo(account.getText(), password.getText(),getThis()))
					{
						setState(true);
						setVisible(false);
						new MainWindow(getID()).setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(getThis(), "密码或账号错误！", "错误", JOptionPane.ERROR_MESSAGE); 
					}
				}
				else 
					e.consume();
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		
		
		password.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(password.getText().equals(""))
				{
					password.setEchoChar((char) 0);
					password.setText("  密   码");
					password.setForeground(new Color(209,209,209));
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if(password.getText().equals("  密   码"))
				{
					password.setText(null);
					password.setEchoChar(c);
				}
				password.setForeground(Color.black);
			}
		});
		
		bottomPanel=new JPanel();
		bottomPanel.setLayout(null);
		bottomPanel.add(face);
		face.setLocation(50, 18);
		JPanel inputPanel=new JPanel();
		inputPanel.setSize(242,76);
		inputPanel.setBorder(new LineBorder(new Color(220,220,220),1));
		GridLayout gridLayout=new GridLayout(2, 1);
		gridLayout.setVgap(1);
		inputPanel.setLayout(gridLayout);
		inputPanel.add(account);
		inputPanel.add(password);
		bottomPanel.add(inputPanel);
		bottomPanel.setBackground(new Color(235,242,249));
		inputPanel.setLocation(168,18);
		
		logButton=new JButton("登    录");
		logButton.setSize(242,38);
		bottomPanel.add(logButton);
		logButton.setLocation(168, 120);
		logButton.setBackground(new   Color(248,234,208));
		logButton.setFocusPainted(false);
		logButton.setBorder(new LineBorder(new Color(220,220,220),0));
		logButton.setFont(new Font("微软雅黑",Font.PLAIN,20));
		logButton.setForeground(new Color(35,172,151));
		logButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				if(JDBCUtils.getAccountInfo(account.getText(), password.getText(),getThis()))
				{
					setState(true);
					setVisible(false);
					new MainWindow(getID()).setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(getThis(), "密码或账号错误！", "错误", JOptionPane.ERROR_MESSAGE); 
				}
			}
		});
		
	}
	
	private void initSplitPane()
	{
		SplitePane=new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		SplitePane.setBorder(new LineBorder(Color.white,0));
		SplitePane.setDividerLocation(230);
		SplitePane.setDividerSize(0);
		SplitePane.setTopComponent(topPanel);
		SplitePane.setBottomComponent(bottomPanel);
		SplitePane.setBorder(new LineBorder(new Color(220,220,220),1));
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}

	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}

	public LoginWindow getThis(){
		return this;
	}
}
