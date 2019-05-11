package cdu.edu.hospital.dao;

import java.util.List;
import java.util.Map;

import cdu.edu.hospital.entity.Cost;

public interface CostDao {
	/**
	 * 预交费用的保存
	 * @param cost
	 */
	public void costAdd(Cost cost);
	/**
	 * 预交费用查询
	 * @param cost
	 * @return
	 */
	public List<Map<String, Object>> costQuery(Map map);
	/**
	 * 药品费用
	 * @param map
	 * @return
	 */
	public Map<String, Object> drugsCostQuery(Map map);
	/**
	 * 退药费用
	 * @param map
	 * @return
	 */
	public Map<String, Object> drugWithdrawal(Map map);
	/**
	 * 退药费用
	 * @param map
	 * @return
	 */ 
	public Map<String, Object> costQueryTotal(Map map);
	/**
	 * 床位费用
	 */
	public List<Map<String, Object>> bedCodeQuery(Map map);
	 
}
