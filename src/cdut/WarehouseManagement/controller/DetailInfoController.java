package cdut.WarehouseManagement.controller;

import cdut.WarehouseManagement.domain.DetailInfo;
import cdut.WarehouseManagement.service.DetailInfoService;

public class DetailInfoController {
	private DetailInfoService infoService=new DetailInfoService();
	public void modifyRecord(DetailInfo info){
		infoService.modifyRecord(info);
	}
	public DetailInfo getRecord(String iD) {
		return infoService.getRecord(iD);
	}
}
