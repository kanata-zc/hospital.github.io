package cdu.edu.hospital.entity;

import java.sql.Date;

public class PatientCode {

	private String patientId; 		//住院号
	private Integer bedNo;    		//床位号
	private Integer departmentNo;	//科室号
	private Integer wardNo;			//病房号
	private Date start;				//入院开始时间
	private Date end;				//入院结束时间
	private String name;			//姓名
	private Date outStart; 			//出院开始时间
	private Date outEnd;			//出院结束时间
	private Integer outStatus;		//是否出院
	private Integer jsStatus;		//是否结算

	public PatientCode() {
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public Integer getBedNo() {
		return bedNo;
	}

	public void setBedNo(Integer bedNo) {
		this.bedNo = bedNo;
	}

	public Integer getDepartmentNo() {
		return departmentNo;
	}

	public void setDepartmentNo(Integer departmentNo) {
		this.departmentNo = departmentNo;
	}

	public Integer getWardNo() {
		return wardNo;
	}

	public void setWardNo(Integer wardNo) {
		this.wardNo = wardNo;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getOutStart() {
		return outStart;
	}

	public void setOutStart(Date outStart) {
		this.outStart = outStart;
	}

	public Date getOutEnd() {
		return outEnd;
	}

	public void setOutEnd(Date outEnd) {
		this.outEnd = outEnd;
	}

	public Integer getOutStatus() {
		return outStatus;
	}

	public void setOutStatus(Integer outStatus) {
		this.outStatus = outStatus;
	}

	public Integer getJsStatus() {
		return jsStatus;
	}

	public void setJsStatus(Integer jsStatus) {
		this.jsStatus = jsStatus;
	}

	@Override
	public String toString() {
		return "PatientCode [patientId=" + patientId + ", bedNo=" + bedNo
				+ ", departmentNo=" + departmentNo + ", wardNo=" + wardNo
				+ ", start=" + start + ", end=" + end + ", name=" + name
				+ ", outStart=" + outStart + ", outEnd=" + outEnd
				+ ", outStatus=" + outStatus + ", jsStatus=" + jsStatus + "]";
	}
}
