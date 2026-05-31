package ayshirv.com.aivocation.contact.service;

import ayshirv.com.aivocation.contact.dto.ContactRequestDto;

public interface IContactService {

    boolean saveContact(ContactRequestDto contactRequestDto);
}
