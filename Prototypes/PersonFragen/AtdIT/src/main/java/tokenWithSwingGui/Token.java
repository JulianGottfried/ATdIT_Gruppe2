package tokenWithSwingGui;

public class Token {

	String tokenId;
	String firstStep;
	String secondStep;
	String thirdStep;

	public Token(String tokenId, String firstStep, String secondStep, String thirdStep) {
		this.tokenId = tokenId;
		this.firstStep = firstStep;
		this.secondStep = secondStep;
		this.thirdStep = thirdStep;

	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public String getFirstStep() {
		return firstStep;
	}

	public void setFirstStep(String firstStep) {
		this.firstStep = firstStep;
	}

	public String getSecondStep() {
		return secondStep;
	}

	public void setSecondStep(String secondStep) {
		this.secondStep = secondStep;
	}

	public String getThirdStep() {
		return thirdStep;
	}

	public void setThirdStep(String thirdStep) {
		this.thirdStep = thirdStep;
	}

}
