package dto.respone;


public class RespNomogramDto {
    private String likelihoodValue;
    private String postTestValue;

    public RespNomogramDto(String likelihoodValue, String postTestValue) {
        this.likelihoodValue = likelihoodValue;
        this.postTestValue = postTestValue;
    }

	public String getLikelihoodValue() {
		return likelihoodValue;
	}

	public void setLikelihoodValue(String likelihoodValue) {
		this.likelihoodValue = likelihoodValue;
	}

	public String getPostTestValue() {
		return postTestValue;
	}

	public void setPostTestValue(String postTestValue) {
		this.postTestValue = postTestValue;
	}
    
    
}
