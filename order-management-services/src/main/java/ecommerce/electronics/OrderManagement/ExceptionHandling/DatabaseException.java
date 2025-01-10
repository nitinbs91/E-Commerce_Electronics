package ecommerce.electronics.OrderManagement.ExceptionHandling;

public class DatabaseException extends RuntimeException{

    public DatabaseException (String message, Throwable casue)
    {
        super(message, casue);
    }

    public DatabaseException (String message)
    {
        super(message);
    }
}
