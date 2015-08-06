package metrics.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 主题词
 * 
 * @author percy
 *
 */
@Entity
@Table(name = "theme")
public class Theme {

	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 元词
	 */
	private String word;
	/**
	 * 拼音
	 */
	private String pinyin;
	/**
	 * 数据状态
	 */
	private Integer dataState;
	/**
	 * 搜索频率
	 */
	private Integer searchFrequency;
	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
	private Date created;
	/**
	 * 修改时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
	private Date updated;

	/**
	 * 相关度
	 */
	private List<Association> associations = new ArrayList<Association>();

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="word",nullable=false)
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
	@Column(name="pinyin",nullable=false)
	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public Integer getDataState() {
		return dataState;
	}

	public void setDataState(Integer dataState) {
		this.dataState = dataState;
	}

	public Integer getSearchFrequency() {
		return searchFrequency;
	}

	public void setSearchFrequency(Integer searchFrequency) {
		this.searchFrequency = searchFrequency;
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
//, fetch = FetchType.LAZY cascade = CascadeType.ALL
	@OneToMany(mappedBy = "theme", fetch = FetchType.LAZY)
	public List<Association> getAssociations() {
		return associations;
	}

	public void setAssociations(List<Association> associations) {
		this.associations = associations;
	}
	@Override
	public String toString() {
		return "Theme [id=" + id + ", word=" + word + ", pinyin=" + pinyin
				+ ", dataState=" + dataState + ", searchFrequency="
				+ searchFrequency + ", created=" + created + ", updated="
				+ updated + ", associations=" + associations + "]";
	}
	
	
}
