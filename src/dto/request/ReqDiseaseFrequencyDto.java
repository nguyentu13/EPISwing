package dto.request;

public class ReqDiseaseFrequencyDto {

	private Double numeratorVal;
	private Double denominatorVal;
	private Double multiplierVal;

	private int selectedIntervalIndex;
	private Double selectedIntervalValue;

	private int selectedTypeIndex;
	private String selectedTypeValue;

	public Double getNumeratorVal() {
		return numeratorVal;
	}

	public void setNumeratorVal(Double numeratorVal) {
		this.numeratorVal = numeratorVal;
	}

	public Double getDenominatorVal() {
		return denominatorVal;
	}

	public void setDenominatorVal(Double denominatorVal) {
		this.denominatorVal = denominatorVal;
	}

	public Double getMultiplierVal() {
		return multiplierVal;
	}

	public void setMultiplierVal(Double multiplierVal) {
		this.multiplierVal = multiplierVal;
	}

	public int getSelectedIntervalIndex() {
		return selectedIntervalIndex;
	}

	public void setSelectedIntervalIndex(int selectedIntervalIndex) {
		this.selectedIntervalIndex = selectedIntervalIndex;
	}

	public Double getSelectedIntervalValue() {
		return selectedIntervalValue;
	}

	public void setSelectedIntervalValue(Double selectedIntervalValue) {
		this.selectedIntervalValue = selectedIntervalValue;
	}

	public int getSelectedTypeIndex() {
		return selectedTypeIndex;
	}

	public void setSelectedTypeIndex(int selectedTypeIndex) {
		this.selectedTypeIndex = selectedTypeIndex;
	}

	public String getSelectedTypeValue() {
		return selectedTypeValue;
	}

	public void setSelectedTypeValue(String selectedTypeValue) {
		this.selectedTypeValue = selectedTypeValue;
	}

	public ReqDiseaseFrequencyDto(Double numeratorVal, Double denominatorVal, Double multiplierVal,
			int selectedIntervalIndex, Double selectedIntervalValue, int selectedTypeIndex, String selectedTypeValue) {
		super();
		this.numeratorVal = numeratorVal;
		this.denominatorVal = denominatorVal;
		this.multiplierVal = multiplierVal;
		this.selectedIntervalIndex = selectedIntervalIndex;
		this.selectedIntervalValue = selectedIntervalValue;
		this.selectedTypeIndex = selectedTypeIndex;
		this.selectedTypeValue = selectedTypeValue;
	}

	public ReqDiseaseFrequencyDto() {
		super();
	}

}
