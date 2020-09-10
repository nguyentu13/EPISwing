package exception;

public class CalculateException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int code;

    public CalculateException(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }


    @Override
    public String getMessage() {

        String message = "Error undefined";

        switch (code) {
            //1-10 SaplingDetectDisease exception
            case -1: message = "Unexpected exception! please try again!"; break;
            case 0: message = "Expected prevalence must be between 0 and 1!"; break;
            case 1: message = "Please enter value for Expected prevalence!"; break;
            case 2: message = "Level of confidence must be between 0 and 1!"; break;
            case 3: message = "Please enter value for Level of confidence!"; break;
            case 4: message = "Test Specificity must be between 0 and 1!"; break;
            case 5: message = "Please enter value for Test Specificity!"; break;
            case 6: message = "Test Sensitivity must be between 0 and 1!"; break;
            case 7: message = "Please enter interger number!"; break;
            case 8: message = "Upper bound must be greater than Lower bound!"; break;
            case 9: message = "The value entered must be an integer greater than 0 and less than or equal to 100. Please re-enter"; break;
            case 10: message = "Number quantity(Number to generate) must be in bound between Upper-Lower bound"; break;
            case 11: message = "Request params must not be null"; break;
            case 12: message = "Pre-test prob of disease must be between 0 and 1!"; break;
            case 13: message = "Test sensitivity must be between 0 and 1!"; break;
            case 14: message = "Test specificity must be between 0 and 1"; break;

        }

        return message;

    }
}
