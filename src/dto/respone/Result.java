package dto.respone;

public class Result {
	private String result1;
	private String result1Value;

	public Result(String result1, String result1Value) {
		this.result1 = result1;
		this.result1Value = result1Value;
	}

	public Result() {
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

}
