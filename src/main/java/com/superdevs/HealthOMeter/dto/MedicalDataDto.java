package com.superdevs.HealthOMeter.dto;

import com.superdevs.HealthOMeter.entity.Contact;

import java.time.LocalDateTime;

public class MedicalDataDto {

    private long id;
    private LocalDateTime created;
    private Contact contact;

    public MedicalDataDto() {
    }

    public MedicalDataDto(long id, Contact contact) {
        this.id = id;
        this.created = LocalDateTime.now();
        this.contact = contact;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public Contact getContact() {
        return contact;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
