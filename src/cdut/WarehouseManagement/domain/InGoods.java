package cdut.WarehouseManagement.domain;

public class InGoods {
	
	private String BID;
	private String GID;
	private String Date;
	private String WID;

	public String getBID() {
		return BID;
	}

	public void setBID(String bID) {
		BID = bID;
	}

	public String getGID() {
		return GID;
	}

	public void setGID(String gID) {
		GID = gID;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getWID() {
		return WID;
	}

	public void setWID(String wID) {
		WID = wID;
	}
	
	public String[] toArray()
	{
		return new String[]{BID,GID,Date,WID};
	}
	
	public InGoods(String BID,String GID,String Date,String WID) {
		this.BID=BID;
		this.GID=GID;
		this.Date=Date;
		this.WID=WID;
	}
}
