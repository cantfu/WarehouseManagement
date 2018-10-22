package cdut.WarehouseManagement.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class MyTable extends JTable {
	DefaultTableModel defaultTableModel;
	TableRowSorter<TableModel> sorter;
	
	public MyTable(Object[][]rowData,Object[] columnNames) {
		super();
		defaultTableModel=new DefaultTableModel(rowData,columnNames){
			public boolean isCellEditable(int row, int column)
			{
				return false;
			}		
			public Class getColumnClass(int column){
			Class returnValue;
			if ((column >=0) && (column < getColumnCount()))  {
			returnValue = getValueAt(0, column).getClass();}
            else {
            returnValue = Object.class;}
            return returnValue;
			}
		};
		this.setModel(defaultTableModel);
		initTable();
        sorter=new TableRowSorter<TableModel>(defaultTableModel);		
		setRowSorter(sorter);//排序
	}
	private void initTable() {
		setBackground(new Color(255, 255, 255));
		setForeground(new Color(127, 133, 136));
		setBorder(new LineBorder(new Color(255, 255, 255), 0));
		setFont(new Font("微软雅黑", Font.PLAIN, 18));
		setRowHeight(50);
		setShowGrid(false);
		setRowSelectionAllowed(true);
		setColor(this);
		JTableHeader header = getTableHeader();
		header.setResizingAllowed(false);
		header.setBackground(new Color(38, 52, 66));
		header.setForeground(new Color(255, 255, 255));
		header.setBorder(new LineBorder(new Color(255, 255, 255), 0));
		header.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		header.setPreferredSize(new Dimension(header.getWidth(), 50));
		header.setReorderingAllowed(false);
		setTableHeader(header);
	}

	private void setColor(MyTable table) {
		try {
			DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
				public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
						boolean hasFocus, int row, int column) {
						if (row % 2 == 0)
							setBackground(Color.white); // 设置奇数行底色
						else if (row % 2 == 1)
							setBackground(new Color(247, 247, 249)); // 设置偶数行底色
						this.setHorizontalAlignment(JLabel.CENTER);
						return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				}
			};
			for (int i = 0; i < table.getColumnCount(); i++) {
				table.getColumn(table.getColumnName(i)).setCellRenderer(tcr);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
