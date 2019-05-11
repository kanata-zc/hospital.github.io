package cdu.edu.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cdu.edu.hospital.dao.DrugsDao;
import cdu.edu.hospital.entity.Drugs;
import cdu.edu.hospital.entity.DrugsCode;
import cdu.edu.hospital.entity.Grant;
import cdu.edu.hospital.entity.Stock;
import cdu.edu.hospital.entity.WithdrawalDrug;

@Service("drugsService")
public class DrugsServiceImpl implements DrugsService{
	@Autowired
	private DrugsDao drugsDao;

	/**
	 * 药品的入库
	 */
	@Override
	public void DrugsSave(Drugs drugs) {
		 drugsDao.drugsSave(drugs);
	}
	/**
	 * 查询药品
	 */
	@Override
	public Drugs drugsFindById(String id) {
		return drugsDao.drugsFindById(id);
	}
	/**
	 * 药品的更新
	 */
	@Override
	public void DrugsUpdate(Drugs drugs) {
		drugsDao.DrugsUpdate(drugs);
		
	}
	/**
	 * 药品的查询
	 */
	@Override
	public List<Drugs> drugsFind(DrugsCode drugsCode) {
		 return drugsDao.drugsFind(drugsCode);
	}
	/**
	 * 根据药品编号查询是否在库存中含有该种商品
	 */
	@Override
	public Integer drugsStockQueryById(String drugId) {
		return drugsDao.drugsStockQueryById(drugId);
	}
	/**
	 * 更新库存
	 */
	@Override
	public void drugsStockAdd(Drugs drugs) {
		drugsDao.drugsStockAdd(drugs);
	}
	/**
	 * 插入库存
	 */
	@Override
	public void drugsStockSave(Drugs drugs) {
		drugsDao.drugsStockSave(drugs);
		
	}
	/**
	 * 库存查询
	 */
	@Override
	public List<Stock> stockQuery(DrugsCode drugsCode) {
		return drugsDao.stockQuery(drugsCode);
	}
	/**
	 * 药品发放
	 */
	@Override
	public void grantAdd(Grant grant) {
		drugsDao.grantAdd(grant);
		
	}
	/**
	 * 更新库存
	 */
	@Override
	public void stockUpdate(Grant grant) {
		drugsDao.stockUpdate(grant);
		
	}
	/**
	 * 药品发放查询
	 */
	@Override
	public List<Stock> grantQuery(String patientId) {
		return drugsDao.grantQuery(patientId);
	}
	/**
	 * 退药
	 */
	@Override
	public void DrugWithdrawal(WithdrawalDrug withdrawalDrug) {
		drugsDao.DrugWithdrawal(withdrawalDrug);
	}
}
