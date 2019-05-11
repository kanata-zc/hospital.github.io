package cdu.edu.hospital.service;

import java.util.List;
import java.util.Map;

import cdu.edu.hospital.entity.Bed;
import cdu.edu.hospital.entity.Patient;
import cdu.edu.hospital.entity.Ward;

public interface WardService {
	/**
	 * 病房的添加
	 * @param ward
	 */
	public void wardSave(Ward ward);
	/**
	 * 增加床位
	 * @param bed
	 */
	public void bedSave(Bed bed);
	/**
	 * 病房查询
	 */
	public Ward wardQueryById(Integer wardId);
	public List<Ward> wardQuery(Ward ward);
	/**
	 * 更改病房状态
	 * @param wardNo
	 */
	public void wardUpdate(Ward ward);
	/**
	 * 改变床位
	 * @param patient
	 */
	public void logWard(Patient patient);
	/**
	 * 病床使用情况统计
	 * @param id
	 * @return
	 */
	public List<Map<String,Object>> wardStatistics(Integer id);
	
	
	
}
