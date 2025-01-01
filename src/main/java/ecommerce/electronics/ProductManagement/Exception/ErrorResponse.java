package ecommerce.electronics.ProductManagement.Exception;

public class ErrorResponse {

    private String message;
    private String exceptionMessage;
    private long timestamp;

    public ErrorResponse(String message, String exceptionMessage)
    {
        this.message = message;
        this.exceptionMessage = exceptionMessage;
    }

    // Getter for message
    public String getMessage() {
        return message;
    }

    // Setter for message
    public void setMessage(String message) {
        this.message = message;
    }

    // Getter for exceptionMessage
    public String getExceptionMessage() {
        return exceptionMessage;
    }

    // Setter for exceptionMessage
    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    // Getter for timestamp
    public long getTimestamp() {
        return timestamp;
    }

    // Setter for timestamp
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}

