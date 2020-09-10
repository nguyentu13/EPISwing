package dto.request;

public class ReqDiagnosticTestDto {
	private Double a, b, c, d;
	private int selectedIntervalIndex;
	private double selectedIntervalValue;
	private int selectedDiagnosticTypeIndex;

	public ReqDiagnosticTestDto() {
		super();
	}

	public ReqDiagnosticTestDto(Double a, Double b, Double c, Double d, int selectedIntervalIndex,
			double selectedIntervalValue, int selectedDiagnosticTypeIndex) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.selectedIntervalIndex = selectedIntervalIndex;
		this.selectedIntervalValue = selectedIntervalValue;
		this.selectedDiagnosticTypeIndex = selectedDiagnosticTypeIndex;
	}

	public Double getA() {
		return a;
	}

	public void setA(Double a) {
		this.a = a;
	}

	public Double getB() {
		return b;
	}

	public void setB(Double b) {
		this.b = b;
	}

	public Double getC() {
		return c;
	}

	public void setC(Double c) {
		this.c = c;
	}

	public Double getD() {
		return d;
	}

	public void setD(Double d) {
		this.d = d;
	}

	public int getSelectedIntervalIndex() {
		return selectedIntervalIndex;
	}

	public void setSelectedIntervalIndex(int selectedIntervalIndex) {
		this.selectedIntervalIndex = selectedIntervalIndex;
	}

	public double getSelectedIntervalValue() {
		return selectedIntervalValue;
	}

	public void setSelectedIntervalValue(double selectedIntervalValue) {
		this.selectedIntervalValue = selectedIntervalValue;
	}

	public int getSelectedDiagnosticTypeIndex() {
		return selectedDiagnosticTypeIndex;
	}

	public void setSelectedDiagnosticTypeIndex(int selectedDiagnosticTypeIndex) {
		this.selectedDiagnosticTypeIndex = selectedDiagnosticTypeIndex;
	}

}
