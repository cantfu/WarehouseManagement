package cdut.WarehouseManagement.domain;

public class Goods {
	private String ID;
	private String name;
	private String supplier;
	private String pdate;
	private String deadline;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getPdata() {
		return pdate;
	}
	public void setPdata(String pdata) {
		this.pdate = pdata;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public String[] toArray()
	{
		return new String[]{ID,name,supplier,pdate,deadline};
	}
	
	public Goods(String ID,String name,String supplier,String pdate,String deadline) {
		this.ID=ID;
		this.name=name;
		this.supplier=supplier;
		this.pdate=pdate;
		this.deadline=deadline;
	}
}
