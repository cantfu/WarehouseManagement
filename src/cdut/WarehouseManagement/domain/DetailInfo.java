package cdut.WarehouseManagement.domain;

public class DetailInfo {
	private String ID;
	private String Name;
	private String Sex;
	private String Birthday;
	private String Tel;
	private String Year;
	private String Email;
	private String Hometown;
	private String Address;
	private String Duty;
	private String School;
	private String Remark;
	private byte[] Photo;
	
	public DetailInfo(){}

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
	public String getBirthday() {
		return Birthday;
	}
	public void setBirthday(String birthday) {
		Birthday = birthday;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	public String getYear() {
		return Year;
	}
	public void setYear(String year) {
		Year = year;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getHometown() {
		return Hometown;
	}
	public void setHometown(String hometown) {
		Hometown = hometown;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getDuty() {
		return Duty;
	}
	public void setDuty(String duty) {
		Duty = duty;
	}
	public String getSchool() {
		return School;
	}
	public void setSchool(String school) {
		School = school;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	public byte[] getPhoto() {
		return Photo;
	}
	public void setPhoto(byte[] photo) {
		Photo = photo;
	}
}
