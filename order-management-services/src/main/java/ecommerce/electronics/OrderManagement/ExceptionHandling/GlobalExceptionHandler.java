package ecommerce.electronics.OrderManagement.ExceptionHandling;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<ErrorResponse> handleDatabaseExceptions(DatabaseException ex)
    {
        ErrorResponse errorResponse = new ErrorResponse("DB Exception", ex.getMessage());
        errorResponse.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(300).body(errorResponse);
    }

}
