package cdut.WarehouseManagement.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowFilter.ComparisonType;
import javax.swing.border.LineBorder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class MyPanel extends JPanel{
	MainWindow mainWindow;
	String[] conditions;
	String[] propsNames;
	String tableName;
	Class<?> clazz;
	ThreeButton add;
	ThreeButton modify;
	ThreeButton delete;
	ThreeButton filter;//筛选
	JTextField textField = new JTextField("");//筛选条件
	public MyPanel(String tableName,String[] propsNames,Class clazz,MainWindow mainWindow) {
		this.mainWindow=mainWindow;
		this.tableName=tableName;
		this.propsNames=propsNames;
		this.clazz=clazz;
		intiPanel();
	}
	
	private void intiPanel()
	{
		this.setBorder(new LineBorder(new Color(234,239,242),15));
		this.setBackground(new Color(255,255,255));
		this.setLayout(new GridLayout(1,1));
		this.add(initButtons());
	}
	private JPanel initButtons()
	{
		JPanel jPanel=new JPanel();
		jPanel.setBackground(Color.white);
		jPanel.setBorder(new LineBorder(Color.white,10));
		GridLayout gridLayout=new GridLayout(1,5);
		gridLayout.setHgap(20);
		gridLayout.setVgap(20);
		jPanel.setLayout(gridLayout);
		add=new ThreeButton("新建");
		modify=new ThreeButton("修改");
		delete=new ThreeButton("删除");
		filter=new ThreeButton("筛选");
		add.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				commonFunction("addRecord");
			}
		});
		modify.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				commonFunction("modifyRecord");
			}
		});
		delete.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				commonFunction("deleteRecord");
			}
		});

		filter.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e)
			{
				String text = textField.getText();
				if (text.length() == 0){
					mainWindow.rightBottomPart.getMyTable().sorter.setRowFilter(null);
			}
			else{
				mainWindow.rightBottomPart.getMyTable().sorter.setRowFilter(RowFilter.regexFilter(text));

			}
			}
		});
		textField.setFont(new Font("微软雅黑",Font.PLAIN,26));
		jPanel.add(textField);
		jPanel.add(filter);
		jPanel.add(add);
		jPanel.add(modify);
		jPanel.add(delete);
		return jPanel;
	}
	
	private void commonFunction(String methodName)
	{
		try {
			ArrayList<Class<String>> paramType=new ArrayList<>();
			for(int i=0;i<propsNames.length;++i)
			{
				paramType.add(String.class);
			}
			Constructor constructor=clazz.getConstructor();
			Method method=clazz.getMethod(methodName,paramType.toArray(new Class[]{String.class}));
			new LiteFrame(propsNames,constructor,method,mainWindow);
		} catch (Exception e1)
		{
			e1.printStackTrace();
		}
	}
	
	class LiteFrame extends JDialog{
		ArrayList<LabelField> labelfields;
		String[] propsNames;
		Constructor constructor;
		Method method;
		boolean show=true;
		public LiteFrame(String[] propsNames,Constructor constructor,Method method,JFrame c) {
			super(c,method.getName(),true);
			labelfields=new ArrayList<>();
			this.propsNames=propsNames;
			this.constructor=constructor;
			this.method=method;
			initFields();
			initFieldsValues();
			initWindow();
			this.setSize(600,propsNames.length*100+50);
			this.setLocation(c.getWidth()/2-this.getWidth()/2,c.getHeight()/2-this.getHeight()/2);
			this.setVisible(show);
			this.setAlwaysOnTop(true);
		}
		
		private void initFields()
		{
			
			for(int i=0;i<propsNames.length;++i)
			{
				LabelField field=new LabelField();
				field.setLabelText(propsNames[i]);
				if(method.getName()=="deleteRecord")
				{
					field.field.setEditable(false);
					field.field.setBackground(Color.white);
				}
				labelfields.add(field);
			}
		}
		
		private void initFieldsValues()
		{
			MyTable myTable=mainWindow.rightBottomPart.getMyTable();
			
			int[] selectedRowsIndexes=myTable.getSelectedRows();
			
			if(method.getName()=="modifyRecord"&&selectedRowsIndexes.length==1)
			{
				for(int i=0;i<labelfields.size();++i)
				{
					labelfields.get(i).field.setText((String)myTable.getValueAt(selectedRowsIndexes[0], i));
				}
			}
			else if(method.getName()=="deleteRecord"&&selectedRowsIndexes.length==1){
				for(int i=0;i<labelfields.size();++i)
				{
					labelfields.get(i).field.setText((String)myTable.getValueAt(selectedRowsIndexes[0], i));
				}
			}
			else if((method.getName()=="modifyRecord"||method.getName()=="deleteRecord")&&selectedRowsIndexes.length>1)
			{
				JOptionPane.showMessageDialog(mainWindow, "不可一次操作多行", "错误", JOptionPane.ERROR_MESSAGE); 
				this.show=false;
			}
			else if(method.getName()!="addRecord"&&selectedRowsIndexes.length<1)
			{
				JOptionPane.showMessageDialog(mainWindow, "未选择操作对象", "错误", JOptionPane.ERROR_MESSAGE); 
				this.show=false;
			}
		}
		private Method getMethodforInfo()
		{
			Method method=null;
			try {
				method=clazz.getMethod("get"+tableName+"Info");
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return method;
		}
		private void initWindow()
		{
			JPanel jPanel=new JPanel();
			GridLayout grid=new GridLayout(1,4);
			grid.setHgap(30);
			jPanel.setLayout(grid);
			ThreeButton button=new ThreeButton("确定");
			button.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e)
				{
					try {
						method.invoke(constructor.newInstance(),getPropsValues());
						mainWindow.rightBottomPart=(MyScrollPane)getMethodforInfo().invoke(constructor.newInstance());
						mainWindow.setRightBottomPart(mainWindow.rightBottomPart);
						mainWindow.thirdSplitPane.setDividerLocation(110);
						closeWindow();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			jPanel.add(new JPanel());
			jPanel.add(button);
			ThreeButton button2=new ThreeButton("取消");
			button2.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e)
				{
					closeWindow();
				}
			});
			jPanel.add(button2);
			jPanel.add(new JPanel());
			GridLayout grid2=new GridLayout(labelfields.size()+1, 1);
			grid2.setVgap(20);
			JPanel jPanel2=new JPanel();
			jPanel2.setLayout(grid2);
			jPanel2.setBorder(new LineBorder(new Color(238,238,238),20));
			for(int i=0;i<labelfields.size();++i)
			{
				jPanel2.add(labelfields.get(i));
			}
			jPanel2.add(jPanel);
			this.add(jPanel2);
		}
		
		private void closeWindow()
		{
			this.setVisible(false);
		}
		
		public String[] getPropsValues()
		{
			ArrayList<String> values=new ArrayList<>();
			for(int i=0;i<labelfields.size();++i)
			{
				values.add(labelfields.get(i).field.getText());
			}
			return values.toArray(new String[]{});
		}
	}
	
	class LabelField extends JPanel{
		public JTextField field;
		JLabel jLabel;
		public LabelField() {
			super();
			this.jLabel=new JLabel();
			this.jLabel.setFont(new Font("微软雅黑",Font.PLAIN,26));
			this.field=new JTextField();
			this.field.setFont(new Font("微软雅黑",Font.PLAIN,26));
			this.field.setBorder(new LineBorder(Color.white,0));
			initPanel();
		}
		public void setLabelText(String propName)
		{
			jLabel.setText(propName);
			jLabel.setHorizontalAlignment(JLabel.CENTER);
			jLabel.setBackground(new Color(255,255,255));
		}
		private void initPanel()
		{
			GridLayout gridLayout=new GridLayout(1,2);
			gridLayout.setHgap(20);
			this.setLayout(gridLayout);
			this.add(jLabel);
			this.add(field);
		}
	}

	class ThreeButton extends JButton{
		public ThreeButton(String name) {
			super(name);
			initButton();
		}
		
		private void initButton(){
			this.setBorder(new LineBorder(Color.white,0));
			this.setFocusPainted(false);
			this.setBackground(new   Color(248,234,208));
			this.setForeground(new Color(35,172,151));
			this.setFont(new Font("微软雅黑",Font.PLAIN,22));
		}
	}
}
