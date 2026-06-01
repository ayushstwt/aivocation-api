package ayshirv.com.aivocation.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDate;

public record ErrorResponseDto(String apiPath, HttpStatus errorCode, String message, LocalDate errorTime) {
}
