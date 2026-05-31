package ayshirv.com.aivocation.company.dto;

import java.time.Instant;

public record CompanyDto(Long id, String name, String logo, String industry, String size, String rating, String locations,
                         Integer founded, String description, Integer employees, String website,
                         Instant createdAt) {
}