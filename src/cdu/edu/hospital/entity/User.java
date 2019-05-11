package cdu.edu.hospital.entity;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class User implements Serializable {

	private static final long serialVersionUID = 1561862745024854200L;

	private String id; // 用户ID
	private String name; // 用户名
	private String password; // 用户密码
	private String phone; // 用户电话
	private Integer describe; // 用户权限
	private Date createtime; // 注册时间

	public User() {

	}

	public User(String id, String name, String password, String phone, Integer describe) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.describe = describe;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getDescribe() {
		return describe;
	}

	public void setDescribe(Integer describe) {
		this.describe = describe;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", password=" + password + ", phone=" + phone + ", describe=" + describe+",createtime"+createtime;
	}
}
