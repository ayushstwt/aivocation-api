package ayshirv.com.aivocation.contact.service.impl;

import ayshirv.com.aivocation.contact.dto.ContactRequestDto;
import ayshirv.com.aivocation.contact.entity.Contact;
import ayshirv.com.aivocation.contact.repository.ContactRepository;
import ayshirv.com.aivocation.contact.service.IContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.Instant;


@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements IContactService {

    private final ContactRepository contactRepository;

    @Override
    public boolean saveContact(ContactRequestDto contactRequestDto) {
        var contact = contactRepository.save(transformToEntity(contactRequestDto));
        return contact.getId() != null;
    }

    private Contact transformToEntity(ContactRequestDto contactRequestDto) {
        Contact contact = new Contact();
        BeanUtils.copyProperties(contactRequestDto, contact);
        contact.setCreatedAt(Instant.now());
        contact.setUpdatedAt(Instant.now());
        contact.setCreatedBy("System");
        contact.setUpdatedBy("System");
        return contact;
    }
}
