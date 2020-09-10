package dto.request;

public class ReqSamplingEstimatePrevalenceDto {
	private Double selectedIntervalValue;
	private int selectedIntervalIndex;
	private int selectedClustersIndex;

	private Double populationV;
	private Double maximumPreV;

	private Double rhoV;
	private Double aveClusterSizeV;

	public Double getSelectedIntervalValue() {
		return selectedIntervalValue;
	}

	public void setSelectedIntervalValue(Double selectedIntervalValue) {
		this.selectedIntervalValue = selectedIntervalValue;
	}

	public int getSelectedIntervalIndex() {
		return selectedIntervalIndex;
	}

	public void setSelectedIntervalIndex(int selectedIntervalIndex) {
		this.selectedIntervalIndex = selectedIntervalIndex;
	}

	public int getSelectedClustersIndex() {
		return selectedClustersIndex;
	}

	public void setSelectedClustersIndex(int selectedClustersIndex) {
		this.selectedClustersIndex = selectedClustersIndex;
	}

	public Double getPopulationV() {
		return populationV;
	}

	public void setPopulationV(Double populationV) {
		this.populationV = populationV;
	}

	public Double getMaximumPreV() {
		return maximumPreV;
	}

	public void setMaximumPreV(Double maximumPreV) {
		this.maximumPreV = maximumPreV;
	}

	public Double getRhoV() {
		return rhoV;
	}

	public void setRhoV(Double rhoV) {
		this.rhoV = rhoV;
	}

	public Double getAveClusterSizeV() {
		return aveClusterSizeV;
	}

	public void setAveClusterSizeV(Double aveClusterSizeV) {
		this.aveClusterSizeV = aveClusterSizeV;
	}

	public ReqSamplingEstimatePrevalenceDto(Double selectedIntervalValue, int selectedIntervalIndex,
			int selectedClustersIndex, Double populationV, Double maximumPreV, Double rhoV, Double aveClusterSizeV) {
		super();
		this.selectedIntervalValue = selectedIntervalValue;
		this.selectedIntervalIndex = selectedIntervalIndex;
		this.selectedClustersIndex = selectedClustersIndex;
		this.populationV = populationV;
		this.maximumPreV = maximumPreV;
		this.rhoV = rhoV;
		this.aveClusterSizeV = aveClusterSizeV;
	}

	public ReqSamplingEstimatePrevalenceDto() {
		super();
	}

}
