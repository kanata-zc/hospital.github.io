package
cdu.edu.hospital.dao;

import java.util.List;
import java.util.Map;

import org.junit.validator.PublicClassValidator;

import cdu.edu.hospital.entity.Patient;
import cdu.edu.hospital.entity.PatientCode;

public interface PatientDao {
	/**
	 * 病人的添加
	 * @param patient
	 */
	public void patientAdd(Patient patient);
	/**
	 * 病人列表的查询
	 * @return
	 */
	public List<Map<String, Object>> patientQuery(PatientCode patientCode);
	/**
	 * 更新病人信息
	 * @param patient
	 */
	public void patientUpdate(Patient patient);
	/**
	 * 费用结算
	 * @param patientId
	 */
	public void jiesun(String patientId);
	/**
	 * 出院登记
	 */
	public void patientLeave(String patientId);
	/**
	 * 入院统计
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> inHospital(Map<String, Object> map);
	/**
	 * 出院统计
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> outHospital(Map<String, Object> map);
	/**
	 * 科室查询
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> departmentQuery(Map<String, Object> map);
	
 }
