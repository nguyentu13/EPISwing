package dto.respone;

public class RespTwobyTwoTableDto {

	private String result1Value;
	private String result1;
	// total
	private double totalDisMinus;
	private double totalDisPlus;
	private double totalExpMinus;
	private double totalExpPlus;
	private double total;

	public RespTwobyTwoTableDto(String result1Value, String result1, double totalDisMinus, double totalDisPlus,
			double totalExpMinus, double totalExpPlus, double total) {
		this.result1Value = result1Value;
		this.result1 = result1;
		this.totalDisMinus = totalDisMinus;
		this.totalDisPlus = totalDisPlus;
		this.totalExpMinus = totalExpMinus;
		this.totalExpPlus = totalExpPlus;
		this.total = total;
	}

	public String getResult1Value() {
		return result1Value;
	}

	public void setResult1Value(String result1Value) {
		this.result1Value = result1Value;
	}

	public String getResult1() {
		return result1;
	}

	public void setResult1(String result1) {
		this.result1 = result1;
	}

	public double getTotalDisMinus() {
		return totalDisMinus;
	}

	public void setTotalDisMinus(double totalDisMinus) {
		this.totalDisMinus = totalDisMinus;
	}

	public double getTotalDisPlus() {
		return totalDisPlus;
	}

	public void setTotalDisPlus(double totalDisPlus) {
		this.totalDisPlus = totalDisPlus;
	}

	public double getTotalExpMinus() {
		return totalExpMinus;
	}

	public void setTotalExpMinus(double totalExpMinus) {
		this.totalExpMinus = totalExpMinus;
	}

	public double getTotalExpPlus() {
		return totalExpPlus;
	}

	public void setTotalExpPlus(double totalExpPlus) {
		this.totalExpPlus = totalExpPlus;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
