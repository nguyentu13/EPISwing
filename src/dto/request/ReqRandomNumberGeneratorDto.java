package dto.request;

public class ReqRandomNumberGeneratorDto {

	private Integer a, b, n, seed;

	private Integer chkReplacement;

	public Integer getA() {
		return a;
	}

	public void setA(Integer a) {
		this.a = a;
	}

	public Integer getB() {
		return b;
	}

	public void setB(Integer b) {
		this.b = b;
	}

	public Integer getN() {
		return n;
	}

	public void setN(Integer n) {
		this.n = n;
	}

	public Integer getSeed() {
		return seed;
	}

	public void setSeed(Integer seed) {
		this.seed = seed;
	}

	public Integer getChkReplacement() {
		return chkReplacement;
	}

	public void setChkReplacement(Integer chkReplacement) {
		this.chkReplacement = chkReplacement;
	}

	public ReqRandomNumberGeneratorDto(Integer a, Integer b, Integer n, Integer seed, Integer chkReplacement) {
		super();
		this.a = a;
		this.b = b;
		this.n = n;
		this.seed = seed;
		this.chkReplacement = chkReplacement;
	}

	public ReqRandomNumberGeneratorDto() {
		super();
	}

}
