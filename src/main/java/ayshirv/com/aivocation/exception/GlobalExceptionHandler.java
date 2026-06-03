package ayshirv.com.aivocation.exception;

import ayshirv.com.aivocation.dto.ErrorResponseDto;
import ayshirv.com.aivocation.dto.ValidationErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler  {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleException(Exception exception, WebRequest  webRequest) {
        ErrorResponseDto errorResponseDto=new ErrorResponseDto(
                webRequest.getDescription(false),
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage(),
                java.time.LocalDate.now()
        );
        return new ResponseEntity<>(errorResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleException(
            MethodArgumentNotValidException exception,
            WebRequest webRequest) {

        Map<String, String> errors = new HashMap<>();

        exception.getBindingResult()
                .getFieldErrors()
                .forEach(error ->
                        errors.put(error.getField(), error.getDefaultMessage()));

        ValidationErrorResponse response = new ValidationErrorResponse(
                webRequest.getDescription(false),
                HttpStatus.BAD_REQUEST,
                errors,
                LocalTime.now()
        );

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<ValidationErrorResponse> handleValidationException(
            HandlerMethodValidationException exception,
            WebRequest webRequest) {

        Map<String, String> errors = new HashMap<>();

        exception.getParameterValidationResults().forEach(result -> {
            String parameterName = result.getMethodParameter().getParameterName();

            result.getResolvableErrors().forEach(error ->
                    errors.put(parameterName, error.getDefaultMessage()));
        });

        ValidationErrorResponse response = new ValidationErrorResponse(
                webRequest.getDescription(false),
                HttpStatus.BAD_REQUEST,
                errors,
                LocalTime.now()
        );

        return ResponseEntity.badRequest().body(response);
    }

}
