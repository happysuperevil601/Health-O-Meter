package com.superdevs.HealthOMeter.mappers;

import com.superdevs.HealthOMeter.dto.ContactDto;
import com.superdevs.HealthOMeter.entity.Contact;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ContactMapper {

    public Contact mapToContact(final ContactDto contactDto) {
        return new Contact(
                contactDto.getId(),
                contactDto.getFirstName(),
                contactDto.getLastName(),
                contactDto.getGender(),
                contactDto.getEmail(),
                contactDto.getCountry(),
                contactDto.getCity(),
                contactDto.getUser(),
                contactDto.getMedicalData(),
                contactDto.getBioMetricData(),
                contactDto.getBmiData(),
                contactDto.getWhrData(),
                contactDto.getRfmData(),
                contactDto.getBioMetricHistoricalData(),
                contactDto.getHistoricalCalculatorsResults(),
                contactDto.getHistoricalMedicalData());
    }

    public ContactDto mapToContactDto(final Contact contact) {
        return new ContactDto(
                contact.getId(),
                contact.getFirstName(),
                contact.getLastName(),
                contact.getGender(),
                contact.getEmail(),
                contact.getCountry(),
                contact.getCity(),
                contact.getUser(),
                contact.getMedicalData(),
                contact.getBioMetricData(),
                contact.getBmiData(),
                contact.getWhrData(),
                contact.getRfmData(),
                contact.getBioMetricHistoricalData(),
                contact.getHistoricalCalculatorsResults(),
                contact.getHistoricalMedicalData());
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
