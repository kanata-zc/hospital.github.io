package cdu.edu.hospital.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class Patient implements Serializable {

	private static final long serialVersionUID = -6183250714467316067L;

	private Integer id; // 主键
	private String patientId; // 住院号
	private String name; // 姓名
	private Integer gender; // 性别
	private Integer nation; // 民族
	private Date birth; // 生日
	private String cerificateNo;// 证件号码
	private String workUnit; // 工作单位
	private Integer maritalStatus;// 婚姻状况
	private Integer doctorId; // 主治医生编号
	private Timestamp admissionTime;// 入院时间
	private String homeAddress; // 家庭住址
	private String homePhone; // 家庭电话
	private String contactsPhone; // 联系人电话
	private String contacts; // 联系人
	private Integer admissionStatus;// 入院状态
	private Integer roomNo; // 病房号
	private Integer roomType; // 病房类型
	private Integer bedNo; // 床位号
	private Integer state; // 状态
	private Integer department; // 科室号
	private Integer settlementState;// 是否结算
	private Integer leaveState; // 是否出院
	private Timestamp leaveTime; // 出院时间

	public Patient() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getNation() {
		return nation;
	}

	public void setNation(Integer nation) {
		this.nation = nation;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getCerificateNo() {
		return cerificateNo;
	}

	public void setCerificateNo(String cerificateNo) {
		this.cerificateNo = cerificateNo;
	}

	public String getWorkUnit() {
		return workUnit;
	}

	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}

	public Integer getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(Integer maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public Timestamp getAdmissionTime() {
		return admissionTime;
	}

	public void setAdmissionTime(Timestamp admissionTime) {
		this.admissionTime = admissionTime;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getContactsPhone() {
		return contactsPhone;
	}

	public void setContactsPhone(String contactsPhone) {
		this.contactsPhone = contactsPhone;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public Integer getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(Integer roomNo) {
		this.roomNo = roomNo;
	}

	public Integer getBedNo() {
		return bedNo;
	}

	public void setBedNo(Integer bedNo) {
		this.bedNo = bedNo;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getDepartment() {
		return department;
	}

	public void setDepartment(Integer department) {
		this.department = department;
	}

	public Integer getAdmissionStatus() {
		return admissionStatus;
	}

	public void setAdmissionStatus(Integer admissionStatus) {
		this.admissionStatus = admissionStatus;
	}

	public Integer getRoomType() {
		return roomType;
	}

	public void setRoomType(Integer roomType) {
		this.roomType = roomType;
	}

	public Integer getSettlementState() {
		return settlementState;
	}

	public void setSettlementState(Integer settlementState) {
		this.settlementState = settlementState;
	}

	public Integer getLeaveState() {
		return leaveState;
	}

	public void setLeaveState(Integer leaveState) {
		this.leaveState = leaveState;
	}

	public Timestamp getLeaveTime() {
		return leaveTime;
	}

	public void setLeaveTime(Timestamp leaveTime) {
		this.leaveTime = leaveTime;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", patientId=" + patientId + ", name="
				+ name + ", gender=" + gender + ", nation=" + nation
				+ ", birth=" + birth + ", cerificateNo=" + cerificateNo
				+ ", workUnit=" + workUnit + ", maritalStatus=" + maritalStatus
				+ ", doctorId=" + doctorId + ", admissionTime=" + admissionTime
				+ ", homeAddress=" + homeAddress + ", homePhone=" + homePhone
				+ ", contactsPhone=" + contactsPhone + ", contacts=" + contacts
				+ ", admissionStatus=" + admissionStatus + ", roomNo=" + roomNo
				+ ", roomType=" + roomType + ", bedNo=" + bedNo + ", state="
				+ state + ", department=" + department + ", settlementState="
				+ settlementState + ", leaveState=" + leaveState
				+ ", leaveTime=" + leaveTime + "]";
	}

}
