package metrics.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 相关度
 * 
 * @author percy
 *
 */
@Entity
@Table(name = "association")
public class Association {
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 搜索词--冗余字段
	 */
	private String word;
	/**
	 * 文档名称--冗余字段
	 */
	private String name;
	/**
	 * 相关度
	 */
	private Double value;

	/**
	 * 主题--搜索词
	 */
	private Theme theme;
	/**
	 * 文档
	 */
	private Document document;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "theme_id")
	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	@ManyToOne
	@JoinColumn(name = "document_id")
	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

}
