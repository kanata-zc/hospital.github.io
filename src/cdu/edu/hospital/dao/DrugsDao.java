package cdu.edu.hospital.dao;

import java.util.List;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import cdu.edu.hospital.entity.Drugs;
import cdu.edu.hospital.entity.DrugsCode;
import cdu.edu.hospital.entity.Grant;
import cdu.edu.hospital.entity.Stock;
import cdu.edu.hospital.entity.WithdrawalDrug;

public interface DrugsDao {
	/**
	 * 药品的入库
	 * @param drugs
	 */
	public void drugsSave(Drugs drugs);
	/**
	 * 查询药品(根据ID)
	 * @param id
	 * @return
	 */
	public Drugs drugsFindById(String id);
	/**
	 * 更新药品
	 * @param id
	 */
	public void DrugsUpdate(Drugs drugs);
	/**
	 * 药品的条件查询
	 * @param drugsCode
	 * @return
	 */
	public List<Drugs> drugsFind(DrugsCode drugsCode);
	/**
	 * 根据药品编号查询是否在库存中含有该药品
	 * @param drugId
	 * @return
	 */
	public Integer drugsStockQueryById(String drugId);
	 /**
	  * 更新库存
	  * @param drugs
	  */
	public void drugsStockAdd(Drugs drugs);
	/**
	 * 插入库存
	 * @param drugs
	 */
	public void drugsStockSave(Drugs drugs);
	/**
	 * 库存查询
	 */
	public List<Stock> stockQuery(DrugsCode drugsCode);
	/**
	 * 药品发放
	 * @param grant
	 */
	public void grantAdd(Grant grant);
	/**
	 * 更新库存
	 */
	public void stockUpdate(Grant grant);
	/**
	 * 药品发放查询
	 * @param patient
	 * @return
	 */
	public List<Stock> grantQuery(String patient);
	/**
	 * 退药
	 * @param withdrawalDrug
	 */
	public void DrugWithdrawal(WithdrawalDrug withdrawalDrug);
}
