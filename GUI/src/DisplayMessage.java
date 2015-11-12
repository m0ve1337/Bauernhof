import java.io.Serializable;

public class DisplayMessage implements Serializable {

	private static final long serialVersionUID = 1L;
	private String message;

	public DisplayMessage() {
	}

	public DisplayMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
