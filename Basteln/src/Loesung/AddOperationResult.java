package Loesung;

public class AddOperationResult {
  
  private boolean error;
  
  private String message;
  
  
  public boolean hasError() {
    return error;
  }

  public String getMessage() {
    return message;
  }
  
  public void addErrorMessage(String errorMessage) {
    error = true;
    message = errorMessage;
  }
}
