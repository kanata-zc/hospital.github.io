package cdu.edu.hospital.entity;

import java.io.Serializable;
import java.sql.Date;

public class Drugs implements Serializable {
	private static final long serialVersionUID = 7070566509878891811L;

	
	private Integer id;//主键
	private String drugsid; // id
	private String name;// 药品名称
	private String manufacturer;// 生产厂商
	private Float price;// 单价
	private Integer validityYear;// 保质期（年）
	private Integer validityDay;// 保质期(天)
	private Integer validityMouth;// 保质期（月）
	private String supply;// 供货单位
	private Date createTime;// 更新日期
	private Integer addNum;// 新增数量
	private Date production_time;// 生产日期
	private Date vilidityTime;// 保质期

	public Drugs() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDrugsid() {
		return drugsid;
	}

	public void setDrugsid(String drugsid) {
		this.drugsid = drugsid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getValidityYear() {
		return validityYear;
	}

	public void setValidityYear(Integer validityYear) {
		this.validityYear = validityYear;
	}

	public Integer getValidityDay() {
		return validityDay;
	}

	public void setValidityDay(Integer validityDay) {
		this.validityDay = validityDay;
	}

	public Integer getValidityMouth() {
		return validityMouth;
	}

	public void setValidityMouth(Integer validityMouth) {
		this.validityMouth = validityMouth;
	}

	public String getSupply() {
		return supply;
	}

	public void setSupply(String supply) {
		this.supply = supply;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getAddNum() {
		return addNum;
	}

	public void setAddNum(Integer addNum) {
		this.addNum = addNum;
	}

	public Date getProduction_time() {
		return production_time;
	}

	public void setProduction_time(Date production_time) {
		this.production_time = production_time;
	}

	public Date getVilidityTime() {
		return vilidityTime;
	}

	public void setVilidityTime(Date vilidityTime) {
		this.vilidityTime = vilidityTime;
	}

	@Override
	public String toString() {
		return "Drugs [id=" + id + ", drugsid=" + drugsid + ", name=" + name + ", manufacturer=" + manufacturer
				+ ", price=" + price + ", validityYear=" + validityYear + ", validityDay=" + validityDay
				+ ", validityMouth=" + validityMouth + ", supply=" + supply + ", createTime=" + createTime + ", addNum="
				+ addNum + ", production_time=" + production_time + ", vilidityTime=" + vilidityTime + "]";
	}
}
