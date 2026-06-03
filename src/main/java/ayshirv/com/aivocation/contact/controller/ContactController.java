package ayshirv.com.aivocation.contact.controller;

import ayshirv.com.aivocation.contact.dto.ContactRequestDto;
import ayshirv.com.aivocation.contact.service.IContactService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final IContactService contactService;

    @PostMapping(version = "1.0.0")
    public ResponseEntity<String> saveContactMsg(@RequestBody @Valid ContactRequestDto contactRequestDto)
    {
        var isSaved = contactService.saveContact(contactRequestDto);
        if (isSaved) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Contact message saved successfully");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save contact message");
    }

    @GetMapping
    public ResponseEntity<String> fetchOpenContacts(@RequestParam @Validated @NotBlank(message = "Status is required") String status)
    {
        return ResponseEntity.ok("Fetched open contact messages successfully");
    }
}
