package dto.respone;

public class RespDiagnosticTestDto {

	private String result1, result1Value, result2, result2Value;

	public RespDiagnosticTestDto(String result1, String result1Value, String result2, String result2Value) {
		this.result1 = result1;
		this.result1Value = result1Value;
		this.result2 = result2;
		this.result2Value = result2Value;
	}

	public RespDiagnosticTestDto() {
	}

	public String getResult1() {
		return result1;
	}

	public void setResult1(String result1) {
		this.result1 = result1;
	}

	public String getResult1Value() {
		return result1Value;
	}

	public void setResult1Value(String result1Value) {
		this.result1Value = result1Value;
	}

	public String getResult2() {
		return result2;
	}

	public void setResult2(String result2) {
		this.result2 = result2;
	}

	public String getResult2Value() {
		return result2Value;
	}

	public void setResult2Value(String result2Value) {
		this.result2Value = result2Value;
	}

}
