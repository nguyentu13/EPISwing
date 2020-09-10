package exception;

public class MyFileNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -8349847292799026824L;

	public MyFileNotFoundException(String message) {
        super(message);
    }

    public MyFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
