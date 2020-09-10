package dto.request;

public class ReqSamplingEstimateMeanDto {
	private Double standardV;
	private Double maximumV;

	private String selectedIntervalValue;
	private String selectedIntervalIndex;

	public Double getStandardV() {
		return standardV;
	}

	public void setStandardV(Double standardV) {
		this.standardV = standardV;
	}

	public Double getMaximumV() {
		return maximumV;
	}

	public void setMaximumV(Double maximumV) {
		this.maximumV = maximumV;
	}

	public String getSelectedIntervalValue() {
		return selectedIntervalValue;
	}

	public void setSelectedIntervalValue(String selectedIntervalValue) {
		this.selectedIntervalValue = selectedIntervalValue;
	}

	public String getSelectedIntervalIndex() {
		return selectedIntervalIndex;
	}

	public void setSelectedIntervalIndex(String selectedIntervalIndex) {
		this.selectedIntervalIndex = selectedIntervalIndex;
	}

	public ReqSamplingEstimateMeanDto(Double standardV, Double maximumV, String selectedIntervalValue,
			String selectedIntervalIndex) {
		super();
		this.standardV = standardV;
		this.maximumV = maximumV;
		this.selectedIntervalValue = selectedIntervalValue;
		this.selectedIntervalIndex = selectedIntervalIndex;
	}

	public ReqSamplingEstimateMeanDto() {
		super();
	}

}
