package garage.model.facade.exceptions;

@SuppressWarnings("serial")
public class FacadeMetierException extends Exception {

	public FacadeMetierException() {
		super();
	}

	public FacadeMetierException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FacadeMetierException(String message, Throwable cause) {
		super(message, cause);
	}

	public FacadeMetierException(String message) {
		super(message);
	}

	public FacadeMetierException(Throwable cause) {
		super(cause);
	}

}
