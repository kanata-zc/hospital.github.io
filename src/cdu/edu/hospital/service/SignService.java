package cdu.edu.hospital.service;

import java.util.List;
import java.util.Map;

import cdu.edu.hospital.entity.PatientCode;
import cdu.edu.hospital.entity.Sign;

public interface SignService {
	/**
	 * 体征数据录入
	 * @param sign
	 */
	public void signSave(Sign sign);
	/**
	 * 体征数据查询
	 * @param patientCode
	 * @return
	 */
	public List<Map<String, Object>> signQuery(PatientCode patientCode);
}
