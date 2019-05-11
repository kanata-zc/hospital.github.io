package cdu.edu.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cdu.edu.hospital.dao.CommonDao;
import cdu.edu.hospital.dao.DoctorDao;
import cdu.edu.hospital.entity.Doctor;
import cdu.edu.hospital.entity.DoctorCode;

@Service("doctorService")
public class DoctorServerImpl implements DoctorService{
	@Autowired //注入的组件ID是 commonDao
	private  DoctorDao doctorDao;
	
	/**
	 * 医生信息的保存
	 */
	@Override
	public void doctorSave(Doctor doctor) {
		doctorDao.doctorSave(doctor);
	}
	/**
	 * 医生信息的查询
	 */
	@Override
	public List<Doctor> doctorQuery(DoctorCode doctorCode) {
		return doctorDao.doctorQuery(doctorCode);
	}
	/**
	 * 删除医生信息
	 */
	@Override
	public void doctorDelete(Integer id) {
		doctorDao.doctorDelete(id);
	}
	/**
	 * 更新医生信息
	 */
	@Override
	public void updateDoctorMessage(Doctor doctor) {
		doctorDao.updateDoctorMessage(doctor);
	}
	 

}
