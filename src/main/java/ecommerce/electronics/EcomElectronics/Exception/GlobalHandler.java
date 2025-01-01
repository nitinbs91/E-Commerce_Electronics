package ecommerce.electronics.EcomElectronics.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<ErrorResponse> HandleDatabaseErrors(DatabaseException ex)
    {
        ErrorResponse errorResponse = new ErrorResponse("DataBaseError", ex.getMessage());
        errorResponse.setTimestamp(System.currentTimeMillis());
        System.out.println("-------------------------------------------->");
        return ResponseEntity.status(300).body(errorResponse);
    }


}
