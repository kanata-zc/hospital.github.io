package cdu.edu.hospital.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cdu.edu.hospital.dao.SignDao;
import cdu.edu.hospital.entity.PatientCode;
import cdu.edu.hospital.entity.Sign;

@Service("signService")
public class SignServiceImpl implements SignService{
	
	@Autowired
	SignDao signDao;
	
	/**
	 * 病人体征数据的录入
	 */
	@Override
	public void signSave(Sign sign) {
		signDao.signSave(sign);
	}
	/**
	 * 病人体征数据的查询
	 */
	@Override
	public List<Map<String, Object>> signQuery(PatientCode patientCode) {
		return signDao.signQuery(patientCode);
	}

}
