package cdu.edu.hospital.dao;

import java.util.List;
import java.util.Map;

import cdu.edu.hospital.entity.Bed;
import cdu.edu.hospital.entity.Patient;
import cdu.edu.hospital.entity.Ward;

public interface WardDao {
	/**
	 * 病房的添加
	 */
	public void wardSave(Ward ward);	
	/**
	 * 增加床位
	 * @param bed
	 */
	public void bedSave(Bed bed);
	/**
	 * 病房的查询
	 */
	public Ward wardQueryById(Integer wardId);
	public List<Ward> wardQuery(Ward ward);
	/**
	 * 更改病房状态
	 * @param wardNo
	 */
	public void wardUpdate(Ward ward);
	/**
	 * 记录换床信息
	 * @param patient
	 */
	public void logWard(Patient patient);
	/**
	 * 科室查询
	 * @param departNo
	 * @return
	 */
	public List<Map<String, Object>> departQuery(Integer departNo);
	/**
	 * 每个科室的病床总数
	 * @param departNo
	 * @return
	 */
	public List<Map<String, Object>> bedTotal(Integer departNo);
	/**
	 * 每个科室被使用的数量
	 * @param departNo
	 * @return
	 */
	public List<Map<String, Object>> bedWy(Integer departNo);
	
	
	
}
	 
