package cdu.edu.hospital.entity;

import java.util.Date;

public class UserCode {
	/**
	 * 用户权限
	 */
	private Integer describe;
	/**
	 * 用户ID
	 */
	private String id;
	/**
	 * 开始时间
	 */
	private Date startTime;
	/**
	 * 结束时间
	 */
	private Date endTime;
	/**
	 * 真实姓名
	 */
	private String name;

	public UserCode() {
	}

	public UserCode(Integer describe, String id, Date startTime, Date endTime, String name) {
		this.describe = describe;
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.name = name;
	}

	public Integer getDescribe() {
		return describe;
	}

	public void setDescribe(Integer describe) {
		this.describe = describe;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
