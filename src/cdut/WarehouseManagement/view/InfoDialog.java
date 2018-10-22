package cdut.WarehouseManagement.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileFilter;

import cdut.WarehouseManagement.controller.DetailInfoController;
import cdut.WarehouseManagement.domain.DetailInfo;
import cdut.WarehouseManagement.tools.JDBCUtils;;

public class InfoDialog extends JDialog {
	private String ID;
	private ItemLabel imageLabel;
	private ItemLabel  name=new ItemLabel("姓  名");
	private ItemTextField nameField = new ItemTextField(250,45);
	private ItemLabel sex=new ItemLabel("性  别");
	private ItemTextField sexField=new ItemTextField(250,45);
	private ItemLabel brithday=new ItemLabel("生  日");
	private ItemTextField brithdayField=new ItemTextField(250,45);
	private ItemLabel post=new ItemLabel("岗  位");
	private ItemTextField postField = new ItemTextField();
	private ItemLabel year=new ItemLabel("工  龄");
	private ItemTextField yearField = new ItemTextField();
	private ItemLabel hometown=new ItemLabel("籍  贯");
	private ItemTextField hometownField = new ItemTextField();
	private ItemLabel location=new ItemLabel("地  址");
	private ItemTextField locationField = new ItemTextField();
	private ItemLabel school=new ItemLabel("学  校");
	private ItemTextField schoolField = new ItemTextField();
	private ItemLabel cellPhone=new ItemLabel("手  机");
	private ItemTextField cellPhoneField = new ItemTextField(250,45);
	private ItemLabel email=new ItemLabel("邮  箱");
	private ItemTextField emailField=new ItemTextField();
	private ItemLabel remark=new ItemLabel("说  明");
	private JTextArea remarkField = new JTextArea();
	private BackgroundPanel backgroundPanel = new BackgroundPanel();
	private JPanel header=new JPanel();
	private JPanel tail=new JPanel();
	private InfoButton edit=new InfoButton("编辑");
	private InfoButton save=new InfoButton("保存");
	private InfoButton ok=new InfoButton("确认");
	private ArrayList<JComponent>  Comps=new ArrayList<>();
	private DetailInfoController detailInfoController=new DetailInfoController();
	public static InputStream inputStream;
    private byte[] Photo;

	public InfoDialog(JFrame owner, String id) {
		super(owner, "详细信息", true);
		setSize(760, 1020);
	//	setResizable(false);
		setLocation(500,0);
		this.ID = id;
		this.add(backgroundPanel);
		initImag();
		initInfoButton();
		setInfo();
		initWindowComp();		
	//	setCompsEnableFalse();
		setVisible(true);
	}
	private void setInfo()
	{
		DetailInfo info=detailInfoController.getRecord(ID);
		nameField.setText(info.getName());
		sexField.setText(info.getSex());
		brithdayField.setText(info.getBirthday());
		postField.setText(info.getDuty());
		yearField.setText(info.getYear());
		hometownField.setText(info.getHometown());
		locationField.setText(info.getAddress());
		schoolField.setText(info.getSchool());
		cellPhoneField.setText(info.getTel());
		emailField.setText(info.getEmail());
		remarkField.setText(info.getRemark());
		if(info.getPhoto()!=null)
		{
			ImageIcon imageIcon = new ImageIcon(info.getPhoto());
			imageIcon.setImage((imageIcon.getImage().getScaledInstance(imageLabel.getWidth(),imageLabel.getHeight(), Image.SCALE_DEFAULT)));
			imageLabel.setText(null);
			imageLabel.setIcon(imageIcon);
		}
		
	}
	
    private DetailInfo getInfo(){
		DetailInfo info=new DetailInfo();
		if(ID.equals("")||nameField.getText().equals("")||sexField.getText().equals("")||brithdayField.getText().equals("")||postField.getText().equals("")||yearField.getText().equals("")||
				hometownField.getText().equals("")||locationField.getText().equals("")||schoolField.getText().equals("")||cellPhoneField.getText().equals("")||emailField.getText().equals("")||remarkField.getText().equals(""))
		{
			JOptionPane.showMessageDialog(this, "请填写完整信息！", "错误", JOptionPane.ERROR_MESSAGE); 
			return null;
		}
		info.setID(ID);
		info.setName(nameField.getText());
		info.setSex(sexField.getText());
		info.setBirthday(brithdayField.getText());
		info.setDuty(postField.getText());
		info.setYear(yearField.getText());
		info.setHometown(hometownField.getText());
		info.setAddress(locationField.getText());
		info.setSchool(schoolField.getText());
		info.setTel(cellPhoneField.getText());
		info.setEmail(emailField.getText());
		info.setRemark(remarkField.getText());
		info.setPhoto(Photo);
		return info;
	}
	

	
	private void initWindowComp() {
		backgroundPanel.setBackground(Color.white);
		backgroundPanel.setLayout(null);
		backgroundPanel.add(imageLabel);
		imageLabel.setLocation(50, 50);
		Comps.add(imageLabel);
		
		backgroundPanel.add(name);
		name.setLocation(320,50);
		backgroundPanel.add(nameField);
		nameField.setLocation(450,55);
		Comps.add(nameField);
		
		backgroundPanel.add(sex);
		sex.setLocation(320,120);
		backgroundPanel.add(sexField);
		sexField.setLocation(450,125);
		Comps.add(sexField);
		
		backgroundPanel.add(brithday);
		brithday.setLocation(320,190);
		backgroundPanel.add(brithdayField);
		brithdayField.setLocation(450,195);
		Comps.add(brithdayField);
		
		backgroundPanel.add(cellPhone);
		cellPhone.setLocation(320,260);
		backgroundPanel.add(cellPhoneField);
		cellPhoneField.setLocation(450,265);
		Comps.add(cellPhoneField);
		
		backgroundPanel.add(year);
		year.setLocation(50, 330);
		backgroundPanel.add(yearField);
		yearField.setLocation(180, 335);
		Comps.add(yearField);
		
		backgroundPanel.add(email);
		email.setLocation(50, 400);
		backgroundPanel.add(emailField);
		emailField.setLocation(180, 405);
		Comps.add(emailField);
		
		backgroundPanel.add(hometown);
		hometown.setLocation(50,470);
		backgroundPanel.add(hometownField);
		hometownField.setLocation(180,475);
		Comps.add(hometownField);
		
		backgroundPanel.add(location);
		location.setLocation(50, 540);
		backgroundPanel.add(locationField);
		locationField.setLocation(180, 545);
		Comps.add(locationField);
		
		backgroundPanel.add(post);
		post.setLocation(50, 610);
		backgroundPanel.add(postField);
		postField.setLocation(180, 615);
		Comps.add(postField);
		
		backgroundPanel.add(school);
		school.setLocation(50,680);
		backgroundPanel.add(schoolField);
		schoolField.setLocation(180,685);
		Comps.add(schoolField);
		
		backgroundPanel.add(remark);
		remark.setLocation(50,750);
		backgroundPanel.add(remarkField);
		remarkField.setLocation(180,755);
		remarkField.setFont(new Font("微软雅黑",Font.PLAIN,24));
		remarkField.setSize(520, 140);
		remarkField.setBorder(new LineBorder(new Color(173,173,173),1));
		Comps.add(remarkField);
		
		header.setSize(760, 30);
		header.setBackground(new Color(35,172,151));
		backgroundPanel.add(header);
		header.setLocation(0,0);
		
		tail.setSize(760,60);
		tail.setBackground(new Color(35,172,151));
		tail.setLayout(null);
		backgroundPanel.add(tail);
		tail.setLocation(0,912);
		
		tail.add(edit);
		edit.setLocation(460, 5);
		
		tail.add(save);
		save.setLocation(560, 5);
		
		tail.add(ok);
		ok.setLocation(660,5);
	}
	private void initInfoButton()
	{
		edit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				setCompsEnableTrue();
			}
		});
		
		save.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				if(getInfo()!=null)
				{
					detailInfoController.modifyRecord(getInfo());
					setCompsEnableFalse();
				}
			}
		});
		ok.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				if(getInfo()!=null)
				{
					detailInfoController.modifyRecord(getInfo());
					setCompsEnableFalse();
					setVisible(false);
				}
			}
		});
	}
	private void setCompsEnableFalse()
	{
		for(JComponent c : Comps)
		{
			c.setEnabled(false);
			c.setBorder(new LineBorder(Color.white,0));
		}
	}
	private void setCompsEnableTrue()
	{
		for(JComponent c : Comps)
		{
			c.setEnabled(true);
			c.setBorder(new LineBorder(new Color(173,173,173),1));
		}
	}
	
    private void initImag() {
		imageLabel = new ItemLabel("上传照片");
		imageLabel.setSize(200, 250);
		imageLabel.setBorder(new LineBorder(Color.gray, 1));
		imageLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(imageLabel.isEnabled())
				{
					JFileChooser choose=null;
					choose = new JFileChooser("C:\\");
					choose.setAcceptAllFileFilterUsed(false);
					choose.setMultiSelectionEnabled(false);
					choose.setFileFilter(new FileFilter() {

						@Override
						public String getDescription() {
							return "jpg,png";
						}

						@Override
						public boolean accept(File f) {
							String name = f.getName().toLowerCase();
							if (name.endsWith(".jpg") || name.endsWith("png")) {
								return true;
							} else {
								return false;
							}
						}
					});
					choose.setDialogTitle("选择图片");
					setChooserStyle(choose);
					choose.showOpenDialog(null);
					File image = choose.getSelectedFile();
					if(image!=null)
					{
						try {
							InputStream in = new FileInputStream(image.getPath());
							Photo = JDBCUtils.toBArray(in);
							try {
								in.close();
							} catch (IOException e1) {
								// TODO 自动生成的 catch 块
								e1.printStackTrace();
							}
							ImageIcon imageIcon = new ImageIcon(Photo);
							imageIcon.setImage((imageIcon.getImage().getScaledInstance(imageLabel.getWidth(),imageLabel.getHeight(), Image.SCALE_DEFAULT)));
							imageLabel.setText(null);
							imageLabel.setIcon(imageIcon);
						} catch (FileNotFoundException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}				
					}
				}
			}
		});
		}

	public static void setChooserStyle(JFileChooser choose) {
		if (UIManager.getLookAndFeel().isSupportedLookAndFeel()) {
			final String platform = UIManager.getSystemLookAndFeelClassName();
			if (!UIManager.getLookAndFeel().getName().equals(platform)) {
				try {
					UIManager.setLookAndFeel(platform);
					SwingUtilities.updateComponentTreeUI(choose);
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		}
	}
	class BackgroundPanel extends JScrollPane{
		public BackgroundPanel() {}
		
		public void paintComponent(Graphics g) {
			   int x = 0, y = 0;
			   ImageIcon icon = new ImageIcon("lib/背景.jpg");
			   g.drawImage(icon.getImage(), x, y, getSize().width,getSize().height, this);// 图片会自动缩放
		}
	}
	class InfoButton extends JButton{
		public InfoButton(String text)
		{
			super(text);
			this.setFont(new Font("微软雅黑",Font.PLAIN,24));
			this.setForeground(Color.white);
			this.setSize(90, 50);
			this.setHorizontalAlignment(CENTER);
			this.setFocusPainted(false);
			this.setBackground(new Color(35,172,151));
			this.setBorder(null);
			this.addMouseListener(new MouseAdapter() {
				 public void mouseEntered(MouseEvent e) {
					 setForeground(Color.blue);
				 }
				 public void mouseExited(MouseEvent e) {
					  setForeground(Color.white);
				 }
			});
		}
	}
}
