package cdu.edu.hospital.service;

import java.util.List;

import cdu.edu.hospital.entity.Doctor;
import cdu.edu.hospital.entity.DoctorCode;

/**
 * 医生的服务接口
 * @author 毅
 *
 */
public interface DoctorService {
	/**
	 * 医生信息的保存
	 * @param doctor
	 */
	public void doctorSave(Doctor doctor);
	/**医生信息的查询
	 * 
	 * @param doctorCode
	 * @return
	 */
	public List<Doctor> doctorQuery(DoctorCode doctorCode);
	/**
	 * 删除医生信息
	 * @param id
	 */
	public void doctorDelete(Integer id);
	/**
	 * 更新医生信息
	 * @param doctor
	 */
	public void updateDoctorMessage(Doctor doctor);
}
