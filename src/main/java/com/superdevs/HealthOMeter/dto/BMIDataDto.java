package com.superdevs.HealthOMeter.dto;

import com.superdevs.HealthOMeter.entity.Contact;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BMIDataDto {

    private long id;
    private BigDecimal result;
    private LocalDateTime created;
    private Contact contact;

    public BMIDataDto() {
    }

    public BMIDataDto(long id, BigDecimal result, Contact contact) {
        this.id = id;
        this.result = result;
        this.created = LocalDateTime.now();
        this.contact = contact;
    }

    public long getId() {
        return id;
    }

    public BigDecimal getResult() {
        return result;
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

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}