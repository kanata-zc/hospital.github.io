package cdu.edu.hospital.service;

import java.util.List;
import java.util.Map;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import cdu.edu.hospital.entity.Patient;
import cdu.edu.hospital.entity.PatientCode;

public interface PatientService {
	/**
	 * 病人的添加
	 * @param patient
	 */
	public void patientAdd(Patient patient);
	/**
	 * 病人列表查询
	 * @param patientCode
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
	public void jiesuan(String patientId);
	/**
	 * 出院登记
	 * @param patientId
	 */
	public void patientLeave(String patientId);
	/**
	 * 统计查询patientStatistics
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> patientStatistics(Map<String, Object> map);
}
