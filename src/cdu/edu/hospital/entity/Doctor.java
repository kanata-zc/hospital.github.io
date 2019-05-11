package cdu.edu.hospital.entity;

import java.io.Serializable;
import java.sql.Date;

public class Doctor implements Serializable {
	private static final long serialVersionUID = 5624785365070429542L;

	private Integer id;
	private String name;
	private Integer gender;
	private Integer department;
	private Integer title;
	private Date workTime;
	private Integer state;

	public Doctor() {
	}

	public Doctor(Integer id, String name, Integer gender, Integer department,
			Integer title, Date workTime, Integer state) {

		this.id = id;
		this.name = name;
		this.gender = gender;
		this.department = department;
		this.title = title;
		this.workTime = workTime;
		this.state = state;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getDepartment() {
		return department;
	}

	public void setDepartment(Integer department) {
		this.department = department;
	}

	public Integer getTitle() {
		return title;
	}

	public void setTitle(Integer title) {
		this.title = title;
	}

	public Date getWorkTime() {
		return workTime;
	}

	public void setWorkTime(Date workTime) {
		this.workTime = workTime;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", gender=" + gender
				+ ", department=" + department + ", title=" + title
				+ ", workTime=" + workTime + ", state=" + state + "]";
	}

}
