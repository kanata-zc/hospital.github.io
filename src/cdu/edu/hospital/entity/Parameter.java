package cdu.edu.hospital.entity;

import java.io.Serializable;

public class Parameter implements Serializable {
	private static final long serialVersionUID = 8986245151901546151L;

	private Integer id;
	private String code;
	private String name;
	private Integer value;

	public Parameter(Integer id, String code, String name) {
		this.id = id;
		this.code = code;
		this.name = name;
	}

	public Parameter(Integer id, String code, String name, Integer value) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.value = value;
	}

	public Parameter() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Parameter [id=" + id + ", code=" + code + ", name=" + name + ", value=" + value + "]";
	}

}
