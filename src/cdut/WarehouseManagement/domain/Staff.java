package cdut.WarehouseManagement.domain;

public class Staff {
	private String ID;
	private String Name;
	private String Sex;
	private String Age;
	private String Tel;
	private String Duty;
	public Staff(String ID,String Name,String Sex,String Age,String Tel,String Duty)
	{
		this.ID=ID;
		this.Name=Name;
		this.Sex=Sex;
		this.Age=Age;
		this.Tel=Tel;
		this.Duty=Duty;
	}
	public String getDuty() {
		return Duty;
	}
	public void setDuty(String duty) {
		Duty = duty;
	}
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
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	public String[] toArray()
	{
		return new String[]{ID,Name,Sex,Age,Tel,Duty};
	}
}
