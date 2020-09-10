package dto.request;

public class ReqSaplingDetectDiseaseDto {

	private Double expectPrevalence;
	private Double testSensitivity;
	private Double conInterval;
	private Double testSpecificity;
	private Double popuSize;
	private int finiteCorrectionPos;

	public Double getExpectPrevalence() {
		return expectPrevalence;
	}

	public void setExpectPrevalence(Double expectPrevalence) {
		this.expectPrevalence = expectPrevalence;
	}

	public Double getTestSensitivity() {
		return testSensitivity;
	}

	public void setTestSensitivity(Double testSensitivity) {
		this.testSensitivity = testSensitivity;
	}

	public Double getConInterval() {
		return conInterval;
	}

	public void setConInterval(Double conInterval) {
		this.conInterval = conInterval;
	}

	public Double getTestSpecificity() {
		return testSpecificity;
	}

	public void setTestSpecificity(Double testSpecificity) {
		this.testSpecificity = testSpecificity;
	}

	public Double getPopuSize() {
		return popuSize;
	}

	public void setPopuSize(Double popuSize) {
		this.popuSize = popuSize;
	}

	public int getFiniteCorrectionPos() {
		return finiteCorrectionPos;
	}

	public void setFiniteCorrectionPos(int finiteCorrectionPos) {
		this.finiteCorrectionPos = finiteCorrectionPos;
	}

	public ReqSaplingDetectDiseaseDto(Double expectPrevalence, Double testSensitivity, Double conInterval,
			Double testSpecificity, Double popuSize, int finiteCorrectionPos) {
		super();
		this.expectPrevalence = expectPrevalence;
		this.testSensitivity = testSensitivity;
		this.conInterval = conInterval;
		this.testSpecificity = testSpecificity;
		this.popuSize = popuSize;
		this.finiteCorrectionPos = finiteCorrectionPos;
	}

	public ReqSaplingDetectDiseaseDto() {
		super();
	}

}
