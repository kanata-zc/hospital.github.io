package cdu.edu.hospital.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cdu.edu.hospital.dao.WardDao;
import cdu.edu.hospital.entity.Bed;
import cdu.edu.hospital.entity.Patient;
import cdu.edu.hospital.entity.Ward;
@Service("wardService")
public class WardServiceImpl implements WardService{
	
	@Autowired
	WardDao wardDao;
	
	/**
	 * 病房的增加
	 */
	@Override
	public void wardSave(Ward ward) {
		 wardDao.wardSave(ward);
	}
	/**
	 * 增加床位
	 */
	@Override
	public void bedSave(Bed bed) {
		wardDao.bedSave(bed);
	}
	 
	/**
	 * 更改病房状态
	 */
	@Override
	public void wardUpdate(Ward ward) {
		 wardDao.wardUpdate(ward);
	}
	/**
	 * 病房的查询
	 */
	 
	@Override
	public Ward wardQueryById(Integer wardId) {
		return wardDao.wardQueryById(wardId);
	}
	@Override
	public List<Ward> wardQuery(Ward ward) {
		return wardDao.wardQuery(ward);
	}
	/**
	 * 记录换床信息
	 */
	@Override
	public void logWard(Patient patient) {
		wardDao.logWard(patient);
		
	}
	/**
	 * 病床使用情况统计
	 */
	@Override
	public List<Map<String, Object>> wardStatistics(Integer id) {
		//查询所属科室
		List<Map<String, Object>> list = wardDao.departQuery(id);
		//查询每个科室的总床位
		List<Map<String, Object>> list1 = wardDao.bedTotal(id);
		//查询每个科室所未使用的床位
		List<Map<String, Object>> list2 = wardDao.bedWy(id);
		for(Map<String, Object> map: list){
			for(Map<String,Object> map1:list1){
				String depart1 = map.get("parameter_values")+"";
				String depart2 = map1.get("departmentNo")+"";
				if(depart1.equals(depart2)){
					map.put("total",map1.get("total"));
				}
			}
		}
		for(Map<String, Object> map: list){
			for(Map<String,Object> map1:list2){
				String depart1 = map.get("parameter_values")+"";
				String depart2 = map1.get("departmentNo")+"";
				if(depart1.equals(depart2)){
					map.put("wy",map1.get("total"));
				}
			}
		}
		return list;
	}

}
