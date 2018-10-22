package cdut.WarehouseManagement.domain;

public class OutGoods {
	private String OID;
	private String GID;
	private String Date;
	private String WID;

	public String getOID() {
		return OID;
	}

	public void setOID(String oID) {
		OID = oID;
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
		return new String[]{OID,GID,Date,WID};
	}
	
	public OutGoods(String OID,String GID,String Date,String WID) {
		this.OID=OID;
		this.GID=GID;
		this.Date=Date;
		this.WID=WID;
	}
}
