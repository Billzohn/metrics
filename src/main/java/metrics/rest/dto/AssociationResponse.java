package metrics.rest.dto;


public class AssociationResponse {
	
	private Long themeId;
	private String word;
	private String pinyin;
	private Integer searchFrequency;
	private Long documentId;
	private String merchandiseId;
	private String merchandiseName;
	private String brandCN;
	private String brandEN;
	private String firstCategory;
	private String secondCategory;
	private String thirdCategory;
	private String fourthCategory;
	private String color;
	private Integer gender;
	private Double value;
	
	public Long getThemeId() {
		return themeId;
	}
	public void setThemeId(Long themeId) {
		this.themeId = themeId;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getPinyin() {
		return pinyin;
	}
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	public Integer getSearchFrequency() {
		return searchFrequency;
	}
	public void setSearchFrequency(Integer searchFrequency) {
		this.searchFrequency = searchFrequency;
	}
	public Long getDocumentId() {
		return documentId;
	}
	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
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
	@Override
	public String toString() {
		return "AssociationResponse [themeId=" + themeId + ", word=" + word
				+ ", pinyin=" + pinyin + ", searchFrequency=" + searchFrequency
				+ ", documentId=" + documentId + ", merchandiseId="
				+ merchandiseId + ", merchandiseName=" + merchandiseName
				+ ", brandCN=" + brandCN + ", brandEN=" + brandEN
				+ ", firstCategory=" + firstCategory + ", secondCategory="
				+ secondCategory + ", thirdCategory=" + thirdCategory
				+ ", fourthCategory=" + fourthCategory + ", color=" + color
				+ ", gender=" + gender + ", value=" + value + "]";
	}
	
}
