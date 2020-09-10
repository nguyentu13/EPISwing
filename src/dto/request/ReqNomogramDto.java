package dto.request;

public class ReqNomogramDto {
	private Double preTestValue;
	private Integer rlikelihoodUnknown;
	private Double testSenLiValue;
	private Double testSpecValue;
	private Integer selectedTestTypeIndex;

	public ReqNomogramDto() {
		super();
	}

	public ReqNomogramDto(Double preTestValue, Integer rlikelihoodUnknown, Double testSenLiValue, Double testSpecValue,
			Integer selectedTestTypeIndex) {
		super();
		this.preTestValue = preTestValue;
		this.rlikelihoodUnknown = rlikelihoodUnknown;
		this.testSenLiValue = testSenLiValue;
		this.testSpecValue = testSpecValue;
		this.selectedTestTypeIndex = selectedTestTypeIndex;
	}

	public Double getPreTestValue() {
		return preTestValue;
	}

	public void setPreTestValue(Double preTestValue) {
		this.preTestValue = preTestValue;
	}

	public Integer getRlikelihoodUnknown() {
		return rlikelihoodUnknown;
	}

	public void setRlikelihoodUnknown(Integer rlikelihoodUnknown) {
		this.rlikelihoodUnknown = rlikelihoodUnknown;
	}

	public Double getTestSenLiValue() {
		return testSenLiValue;
	}

	public void setTestSenLiValue(Double testSenLiValue) {
		this.testSenLiValue = testSenLiValue;
	}

	public Double getTestSpecValue() {
		return testSpecValue;
	}

	public void setTestSpecValue(Double testSpecValue) {
		this.testSpecValue = testSpecValue;
	}

	public Integer getSelectedTestTypeIndex() {
		return selectedTestTypeIndex;
	}

	public void setSelectedTestTypeIndex(Integer selectedTestTypeIndex) {
		this.selectedTestTypeIndex = selectedTestTypeIndex;
	}

}
