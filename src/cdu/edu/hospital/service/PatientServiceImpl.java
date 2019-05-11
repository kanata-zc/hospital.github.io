package cdu.edu.hospital.service;

import java.util.List;
import java.util.Map;

import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cdu.edu.hospital.dao.PatientDao;
import cdu.edu.hospital.entity.Patient;
import cdu.edu.hospital.entity.PatientCode;

@Service("patientService")
public class PatientServiceImpl implements PatientService{

	@Autowired
	PatientDao patientDao;
	
	/**
	 * 病人的添加
	 */
	@Override
	public void patientAdd(Patient patient) {
		patientDao.patientAdd(patient);
	}
	/**
	 * 病人列表查询
	 */
	@Override
	public List<Map<String, Object>> patientQuery(PatientCode patientCode) {
		return patientDao.patientQuery(patientCode);
	}
	/**
	 * 更新病人信息
	 */
	@Override
	public void patientUpdate(Patient patient) {
		patientDao.patientUpdate(patient);
	}
	/**
	 * 费用结算
	 */
	@Override
	public void jiesuan(String patientId) {
		 patientDao.jiesun(patientId);
	}
	/**
	 * 出院登记
	 */
	@Override
	public void patientLeave(String patientId) {
		patientDao.patientLeave(patientId);
	}
	/**
	 * 统计查询
	 */
	@Override
	public List<Map<String, Object>> patientStatistics(Map<String, Object> map) {
		int inHospitalTotal = 0;
		int outHospitalTotal = 0;
		//查询入院统计
		List<Map<String, Object>> inList = patientDao.inHospital(map);
		//查询出所有的科室
		List<Map<String, Object>> list = patientDao.departmentQuery(null);
		if(list!=null){
			for(Map<String,Object> okMap:list){
				for(Map<String, Object> map2:inList){
					String id1 = okMap.get("parameter_values")+"";
					String id2 = map2.get("departmentId")+"";
					if(id1.equals(id2)){
						okMap.put("inNum", map2.get("number"));
						inHospitalTotal = Integer.parseInt(map2.get("total").toString());
						okMap.put("inPercentage",map2.get("percentage"));
					}
				}
			}
		}
		//查询出院统计
		List<Map<String,Object>> outList = patientDao.outHospital(map);
		for(Map<String,Object> okMap:list){
			for(Map<String, Object> map2:outList){
				String id1 = okMap.get("parameter_values")+"";
				String id2 = map2.get("departmentId")+"";
				if(id1.equals(id2)){
					okMap.put("outNum", map2.get("number"));
					outHospitalTotal = Integer.parseInt(map2.get("total").toString());
					okMap.put("outPercentage",map2.get("percentage"));
				}
			}
		}
		for(Map<String,Object> okMap:list){
			okMap.put("inTotal", inHospitalTotal);
			okMap.put("outTotal", outHospitalTotal);
		}
		return list;
	}
 
 

}
