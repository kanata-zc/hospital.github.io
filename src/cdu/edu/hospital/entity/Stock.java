package cdu.edu.hospital.entity;

import java.io.Serializable;

public class Stock implements Serializable {
	private static final long serialVersionUID = -8856780919640200144L;

	private Integer id;
	private String drugsId;
	private String drugsName;
	private Float price;
	private Integer account;

	public Stock() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDrugsId() {
		return drugsId;
	}

	public void setDrugsId(String drugsId) {
		this.drugsId = drugsId;
	}

	public String getDrugsName() {
		return drugsName;
	}

	public void setDrugsName(String drugsName) {
		this.drugsName = drugsName;
	}

	public Float getprice() {
		return price;
	}

	public void setprice(Float price) {
		this.price = price;
	}

	public Integer getAccount() {
		return account;
	}

	public void setAccount(Integer account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", drugsId=" + drugsId + ", drugsName=" + drugsName + ", price=" + price
				+ ", account=" + account + "]";
	}

}
