package cdu.edu.hospital.service;

import java.util.List;
import java.util.Map;

import cdu.edu.hospital.entity.Cost;

public interface CostService {
	/**
	 * 预交费用保存
	 * @param cost
	 */
	public void costAdd(Cost cost);
	
	/**
	 * 预交费用查询
	 */
	public List<Map<String, Object>> costQuery(Map map);
	/**
	 * 费用结算查询
	 */
	public List<Map<String, Object>> costTotal(String patientId);
	
}
