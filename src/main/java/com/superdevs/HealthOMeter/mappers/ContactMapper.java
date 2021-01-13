package com.superdevs.HealthOMeter.mappers;

import com.superdevs.HealthOMeter.dto.ContactDto;
import com.superdevs.HealthOMeter.entity.Contact;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ContactMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Contact mapToContact(final ContactDto contactDto) {
        return modelMapper.map(contactDto, Contact.class);
    }

    public ContactDto mapToContactDto(final Contact contact) {
        return modelMapper.map(contact, ContactDto.class);
    }

    public List<Contact> mapToContactList(final List<ContactDto> contactDtoList) {
        return contactDtoList.stream()
                .map(this::mapToContact)
                .collect(Collectors.toList());
    }

    public List<ContactDto> mapToContactDtoList(final List<Contact> contactList) {
        return contactList.stream()
                .map(this::mapToContactDto)
                .collect(Collectors.toList());
    }
}
