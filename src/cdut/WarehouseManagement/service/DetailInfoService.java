package cdut.WarehouseManagement.service;

import cdut.WarehouseManagement.dao.DetailInfoDao;
import cdut.WarehouseManagement.domain.DetailInfo;

public class DetailInfoService {
	private DetailInfoDao detailInfoDao=new DetailInfoDao();
	public void modifyRecord(DetailInfo info) {
		detailInfoDao.modifyRecord(info);
	}
	public DetailInfo getRecord(String iD) {
		return detailInfoDao.getRecord(iD);
	}

}
