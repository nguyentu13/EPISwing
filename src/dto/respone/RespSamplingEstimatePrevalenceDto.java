package dto.respone;

public class RespSamplingEstimatePrevalenceDto {

	private String result1;
	private String resultValue;

	public RespSamplingEstimatePrevalenceDto(String result1, String resultValue) {
		this.result1 = result1;
		this.resultValue = resultValue;
	}

	public String getResult1() {
		return result1;
	}

	public void setResult1(String result1) {
		this.result1 = result1;
	}

	public String getResultValue() {
		return resultValue;
	}

	public void setResultValue(String resultValue) {
		this.resultValue = resultValue;
	}

}
