package ayshirv.com.aivocation.contact.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public record ContactRequestDto(

        @NotBlank(message = "Email is required")
        @Email(message = "Invalid email format")
        String email,

        @NotBlank(message = "Message is required")
        @Size(min = 5, max = 500, message = "Message must be between 5 and 500 characters")
        String message,

        @NotBlank(message = "Name is required")
        @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
        String name,

        @NotBlank(message = "Subject is required")
        @Size(min = 2, max = 150, message = "Subject must be between 2 and 150 characters")
        String subject,

        @NotBlank(message = "User type is required")
        @Pattern(regexp = "Employer|Other|Job Seeker", message = "User type must be either 'Employer', 'Other', or 'Job Seeker'")
        String userType) implements Serializable {
}
