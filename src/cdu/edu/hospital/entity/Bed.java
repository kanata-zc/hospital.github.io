package cdu.edu.hospital.entity;

import java.io.Serializable;

public class Bed implements Serializable {

	private static final long serialVersionUID = -4091202839479260651L;

	private Integer id;
	private Integer wardNo;
	private Integer bedNo;
	private Integer state;

	public Bed() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWardNo() {
		return wardNo;
	}

	public void setWardNo(Integer wardNo) {
		this.wardNo = wardNo;
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

	@Override
	public String toString() {
		return "Bed [id=" + id + ", wardNo=" + wardNo + ", bedNo=" + bedNo + ", state=" + state + "]";
	}

}
