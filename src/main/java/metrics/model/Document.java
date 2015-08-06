package metrics.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "document")
public class Document {
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 商品主键
	 */
	private String merchandiseId;
	/**
	 * 商品名称
	 */
	private String merchandiseName;
	/**
	 * 品牌中文名称
	 */
	private String brandCN;
	/**
	 * 品牌英文名称
	 */
	private String brandEN;
	/**
	 * 一级分类
	 */
	private String firstCategory;
	/**
	 * 二级分类
	 */
	private String secondCategory;
	/**
	 * 三级分类
	 */
	private String thirdCategory;
	/**
	 * 四级分类
	 */
	private String fourthCategory;
	/**
	 * 颜色
	 */
	private String color;
	/**
	 * 适用性别
	 * 0：男        1：女
	 */
	private Integer gender;
	/**
	 * 状态
	 */
	private Integer dataState;
	/**
	 * 创建时间
	 */
	private Date created;
	/**
	 * 更新时间
	 */
	private Date updated;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMerchandiseId() {
		return merchandiseId;
	}

	public void setMerchandiseId(String merchandiseId) {
		this.merchandiseId = merchandiseId;
	}

	public String getMerchandiseName() {
		return merchandiseName;
	}

	public void setMerchandiseName(String merchandiseName) {
		this.merchandiseName = merchandiseName;
	}

	public String getBrandCN() {
		return brandCN;
	}

	public void setBrandCN(String brandCN) {
		this.brandCN = brandCN;
	}

	public String getBrandEN() {
		return brandEN;
	}

	public void setBrandEN(String brandEN) {
		this.brandEN = brandEN;
	}

	public String getFirstCategory() {
		return firstCategory;
	}

	public void setFirstCategory(String firstCategory) {
		this.firstCategory = firstCategory;
	}

	public String getSecondCategory() {
		return secondCategory;
	}

	public void setSecondCategory(String secondCategory) {
		this.secondCategory = secondCategory;
	}

	public String getThirdCategory() {
		return thirdCategory;
	}

	public void setThirdCategory(String thirdCategory) {
		this.thirdCategory = thirdCategory;
	}

	public String getFourthCategory() {
		return fourthCategory;
	}

	public void setFourthCategory(String fourthCategory) {
		this.fourthCategory = fourthCategory;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getDataState() {
		return dataState;
	}

	public void setDataState(Integer dataState) {
		this.dataState = dataState;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

}
