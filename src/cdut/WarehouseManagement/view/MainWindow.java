package cdut.WarehouseManagement.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.LineBorder;

import cdut.WarehouseManagement.controller.*;
import cdut.WarehouseManagement.service.StaffService;
/**
 * 仓库管理主界面
 */
public class MainWindow extends JFrame {
	private String UserID;//当前登录账户ID
	
	MyButton welcomePage;
	MyButton productInfo;
	MyButton inputManage;
	MyButton outputManage;
	MyButton housewareManage;
	MyButton staffManage;
	MyButton accountManage;


	MyTable myTable;
	JPanel leftPanel;
	WelcomePanel welcomePanel;
	JSplitPane firstSplitPane;
	JSplitPane secondSplitPane;
	JSplitPane thirdSplitPane;
	MyScrollPane rightBottomPart;
	MyPanel rightTopPart;
	GoodsController goodsController=new GoodsController();
	InGoodsController inGoodsController=new InGoodsController();
	OutGoodsController outGoodsController=new OutGoodsController();
	WarehouseController warehouseController=new WarehouseController();
	StaffController staffController=new StaffController();
	public MainWindow(String id) {
		UserID = id;
		initButtons();
		initLeftPanel();
		initWelcomePanel();
		initThridSplitPanel();
		initSecondSplitPanel();
		initFirstSplitPanel();
		initWindow();
		setLocationRelativeTo(null);
		
	}
	private void initWelcomePanel()
	{
		welcomePanel=new WelcomePanel(Toolkit.getDefaultToolkit().createImage("lib/Huanying2.jpg"));
	}
	private void initButtons()
	{
		welcomePage=new MyButton("首页");
		productInfo=new MyButton("货物信息");
		inputManage=new MyButton("入库管理");
		outputManage=new MyButton("出库管理");
		housewareManage=new MyButton("仓库管理");
		staffManage=new MyButton("人员信息");
		accountManage=new MyButton("账户信息");
		MyButton.temp=welcomePage;
		welcomePage.setForeground(new Color(255,255,255));
		welcomePage.setBackground(new Color(209,194,139));
		welcomePage.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				setRightBottomPart(welcomePanel);
				firstSplitPane.setDividerLocation(200);
				thirdSplitPane.setDividerLocation(0);
			}
		});
		productInfo.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				rightBottomPart=goodsController.getGoodsInfo();
				
				setRightBottomPart(rightBottomPart);
				firstSplitPane.setDividerLocation(200);
				rightTopPart=new MyPanel("Goods",new String[]{"货物编号","货物名称","供应商","生产日期","保质日期"}, goodsController.getClass(),getThis());
				setRightTopPart(rightTopPart);
				thirdSplitPane.setDividerLocation(110);
			}
		});
	    
		inputManage.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
					rightBottomPart=inGoodsController.getInGoodsInfo();
					setRightBottomPart(rightBottomPart);
					firstSplitPane.setDividerLocation(200);
					rightTopPart=new MyPanel("InGoods",new String[]{"入库员编号","货物编号","入库日期","仓库编号"}, inGoodsController.getClass(),getThis());
					setRightTopPart(rightTopPart);
					thirdSplitPane.setDividerLocation(110);
			}
		});
		
		outputManage.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				rightBottomPart=outGoodsController.getOutGoodsInfo();
				setRightBottomPart(rightBottomPart);
				firstSplitPane.setDividerLocation(200);
				rightTopPart=new MyPanel("OutGoods",new String[]{"出库员编号","货物编号","出库日期","仓库编号"}, outGoodsController.getClass(),getThis());
				setRightTopPart(rightTopPart);
				thirdSplitPane.setDividerLocation(110);
			}
		});
	
	    housewareManage.addMouseListener(new MouseAdapter() {
	    	public void mouseClicked(MouseEvent e)
			{
				rightBottomPart=warehouseController.getWarehouseInfo();
				setRightBottomPart(rightBottomPart);
				firstSplitPane.setDividerLocation(200);
				rightTopPart=new MyPanel("Warehouse",new String[]{"仓库编号","仓库名称","仓库容量","仓库地址","建立日期"}, warehouseController.getClass(),getThis());
				setRightTopPart(rightTopPart);
				thirdSplitPane.setDividerLocation(110);
			}
		});
	    
	    staffManage.addMouseListener(new MouseAdapter() {
	    	public void mouseClicked(MouseEvent e)
			{
	    		staffController.setMainWindow(getThis());
			rightBottomPart=staffController.getStaffInfo();
			setRightBottomPart(rightBottomPart);
			firstSplitPane.setDividerLocation(200);
			rightTopPart=new MyPanel("Staff",new String[]{"员工编号","姓名","性别","年龄","联系方式","职位"}, staffController.getClass(),getThis());
			setRightTopPart(rightTopPart);
			thirdSplitPane.setDividerLocation(110);
			}
		});
	
	    accountManage.addMouseListener(new MouseAdapter() {
	    	public void mouseClicked(MouseEvent e)
			{
	    		setRightBottomPart(welcomePanel);
				firstSplitPane.setDividerLocation(200);
				thirdSplitPane.setDividerLocation(0);
	    		new InfoDialog(getThis(),UserID);
			}
		});
	}
	
	private MainWindow getThis()
	{
		return this;
	}
	
	private void initLeftPanel()
	{
		leftPanel=new JPanel();
		leftPanel.setBackground(new Color(248,234,208));
		GridLayout gridLayout=new GridLayout(7, 1);
		gridLayout.setVgap(0);
		leftPanel.setLayout(gridLayout);
		leftPanel.add(welcomePage);
		leftPanel.add(productInfo);
		if(UserID.contains("A")||UserID.contains("B"))
		{
			leftPanel.add(inputManage);
		}
		else
		{
			leftPanel.add(outputManage);
		}
		leftPanel.add(housewareManage);
		if(UserID.contains("A"))
		{
			leftPanel.add(staffManage);
		}
		leftPanel.add(accountManage);
	}
	
	private void initFirstSplitPanel()
	{
		firstSplitPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		firstSplitPane.setBorder(new LineBorder(new Color(42,56,70),0));
		firstSplitPane.setDividerSize(0);
		firstSplitPane.setDividerLocation(200);
		firstSplitPane.setLeftComponent(secondSplitPane);
		firstSplitPane.setRightComponent(thirdSplitPane);
	}
	private void initSecondSplitPanel(){
		secondSplitPane=new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		secondSplitPane.setBorder(new LineBorder(new Color(42,56,70),0));
		secondSplitPane.setDividerLocation(540);
		secondSplitPane.setDividerSize(0);
		secondSplitPane.setTopComponent(leftPanel);
		JPanel jPanel=new JPanel();
		jPanel.setBackground(new   Color(248,234,208));
		secondSplitPane.setBottomComponent(jPanel);
	}
	private void initThridSplitPanel(){
		thirdSplitPane=new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		thirdSplitPane.setBorder(new LineBorder(new Color(42,56,70),0));
		thirdSplitPane.setDividerLocation(110);
		thirdSplitPane.setDividerSize(0);
		thirdSplitPane.setBottomComponent(welcomePanel);
	}
	private void initWindow()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(1,1));
		this.add(firstSplitPane);
		this.setSize(1200,750);
		this.setLocation(100, 100);
		this.setTitle("仓库管理系统");
		this.setIconImage(new ImageIcon("lib/cangku.png").getImage());
	}
	
	public void setRightBottomPart(JComponent  panel)
	{
		thirdSplitPane.setBottomComponent(panel);
	}
	
	private void setRightTopPart(JComponent  panel)
	{
		thirdSplitPane.setTopComponent(panel);
	}
}
