package ayshirv.com.aivocation.contact.repository;

import ayshirv.com.aivocation.contact.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}