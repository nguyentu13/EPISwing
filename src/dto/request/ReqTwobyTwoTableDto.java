package dto.request;

public class ReqTwobyTwoTableDto {

	private Double aval;
	private Double bval;
	private Double cval;
	private Double dval;
	private Double multiplierVal;

	private int selectedTypeOfAnanysisIndex;
	private int selectedIntervalIndex;
	private Double selectedIntervalValue;

	private int selectedTableTypeIndex;
	private Double selectedTableTypeValue;

	public Double getAval() {
		return aval;
	}

	public void setAval(Double aval) {
		this.aval = aval;
	}

	public Double getBval() {
		return bval;
	}

	public void setBval(Double bval) {
		this.bval = bval;
	}

	public Double getCval() {
		return cval;
	}

	public void setCval(Double cval) {
		this.cval = cval;
	}

	public Double getDval() {
		return dval;
	}

	public void setDval(Double dval) {
		this.dval = dval;
	}

	public Double getMultiplierVal() {
		return multiplierVal;
	}

	public void setMultiplierVal(Double multiplierVal) {
		this.multiplierVal = multiplierVal;
	}

	public int getSelectedTypeOfAnanysisIndex() {
		return selectedTypeOfAnanysisIndex;
	}

	public void setSelectedTypeOfAnanysisIndex(int selectedTypeOfAnanysisIndex) {
		this.selectedTypeOfAnanysisIndex = selectedTypeOfAnanysisIndex;
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

	public int getSelectedTableTypeIndex() {
		return selectedTableTypeIndex;
	}

	public void setSelectedTableTypeIndex(int selectedTableTypeIndex) {
		this.selectedTableTypeIndex = selectedTableTypeIndex;
	}

	public Double getSelectedTableTypeValue() {
		return selectedTableTypeValue;
	}

	public void setSelectedTableTypeValue(Double selectedTableTypeValue) {
		this.selectedTableTypeValue = selectedTableTypeValue;
	}

	public ReqTwobyTwoTableDto(Double aval, Double bval, Double cval, Double dval, Double multiplierVal,
			int selectedTypeOfAnanysisIndex, int selectedIntervalIndex, Double selectedIntervalValue,
			int selectedTableTypeIndex, Double selectedTableTypeValue) {
		super();
		this.aval = aval;
		this.bval = bval;
		this.cval = cval;
		this.dval = dval;
		this.multiplierVal = multiplierVal;
		this.selectedTypeOfAnanysisIndex = selectedTypeOfAnanysisIndex;
		this.selectedIntervalIndex = selectedIntervalIndex;
		this.selectedIntervalValue = selectedIntervalValue;
		this.selectedTableTypeIndex = selectedTableTypeIndex;
		this.selectedTableTypeValue = selectedTableTypeValue;
	}

	public ReqTwobyTwoTableDto() {
		super();
	}

}
