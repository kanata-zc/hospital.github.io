package cdu.edu.hospital.service;

import java.util.List;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import cdu.edu.hospital.entity.Drugs;
import cdu.edu.hospital.entity.DrugsCode;
import cdu.edu.hospital.entity.Grant;
import cdu.edu.hospital.entity.Stock;
import cdu.edu.hospital.entity.WithdrawalDrug;

/**
 * 药品的服务接口
 * @author 毅
 *
 */
public interface DrugsService {
	/**
	 * 药品的入库
	 * @param drugs
	 */
	public void DrugsSave(Drugs drugs);
	
	/**
	 * 查询药品
	 */
	public Drugs drugsFindById(String id);
	/**
	 * 药品的更新
	 */
	public void DrugsUpdate(Drugs drugs);
	/**
	 * 药品按条件查询
	 */
	public List<Drugs> drugsFind(DrugsCode drugsCode);
	/**
	 * 根据药品编号查询库存中是否有该种药品
	 */
	public Integer drugsStockQueryById(String drugId);
	/**
	 * 更新库存
	 */
	public void drugsStockAdd(Drugs drugs);
	/**
	 * 插入库存
	 */
	public void drugsStockSave(Drugs drugs);
	/**
	 * 库存查询
	 */
	public List<Stock> stockQuery(DrugsCode drugsCode);
	/**
	 * 药品发放
	 */
	public void grantAdd(Grant grant);
	/**
	 * 更新库存
	 */
	public void stockUpdate(Grant grant);
	/**
	 * 药品发放查询
	 */
	public List<Stock> grantQuery(String patientId);
	/**
	 * 退药
	 * @param withdrawalDrug
	 */
	public void DrugWithdrawal(WithdrawalDrug withdrawalDrug);
}
