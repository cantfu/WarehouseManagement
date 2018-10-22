package cdut.WarehouseManagement.domain;

public class Warehouse {
	private String ID;//仓库ID
	private String Name;//仓库名称
	private String Capacity;//仓库容量
	private String address;//仓库地址
	private String Date;//仓库创建时间

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCapacity() {
		return Capacity;
	}

	public void setCapacity(String capacity) {
		Capacity = capacity;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String[] toArray()
	{
		return new String[]{ID,Name,Capacity,address,Date};
	}
	
	public Warehouse(String ID,String name,String capacity,String address,String date) {
		this.ID=ID;
		this.Name=name;
		this.Capacity=capacity;
		this.address = address;
		this.Date = date;
	}
}
