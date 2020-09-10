package dto.respone;

public class RespSaplingDetectDiseaseDto {

	private String result1;
	private String result2;
	private String result3;
	private String result3Value;
	private String result2Value;
	private String result1Value;

	public RespSaplingDetectDiseaseDto(String result1, String result2, String result3, String result1Value,
			String result2Value, String result3Value) {
		this.result1 = result1;
		this.result2 = result2;
		this.result3 = result3;
		this.result3Value = result3Value;
		this.result2Value = result2Value;
		this.result1Value = result1Value;
	}

	public String getResult1() {
		return result1;
	}

	public void setResult1(String result1) {
		this.result1 = result1;
	}

	public String getResult2() {
		return result2;
	}

	public void setResult2(String result2) {
		this.result2 = result2;
	}

	public String getResult3() {
		return result3;
	}

	public void setResult3(String result3) {
		this.result3 = result3;
	}

	public String getResult3Value() {
		return result3Value;
	}

	public void setResult3Value(String result3Value) {
		this.result3Value = result3Value;
	}

	public String getResult2Value() {
		return result2Value;
	}

	public void setResult2Value(String result2Value) {
		this.result2Value = result2Value;
	}

	public String getResult1Value() {
		return result1Value;
	}

	public void setResult1Value(String result1Value) {
		this.result1Value = result1Value;
	}

}
