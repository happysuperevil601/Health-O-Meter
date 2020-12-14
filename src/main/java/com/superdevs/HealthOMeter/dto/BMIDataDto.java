package com.superdevs.HealthOMeter.dto;

import com.superdevs.HealthOMeter.entity.Contact;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BMIDataDto {

    private long id;
    private BigDecimal height;
    private BigDecimal weight;
    private BigDecimal result;
    private LocalDateTime created;
    private Contact contact;

    public BMIDataDto() {
    }

    public BMIDataDto(BigDecimal height, BigDecimal weight, BigDecimal result, Contact contact) {
        this.height = height;
        this.weight = weight;
        this.result = result;
        this.created = LocalDateTime.now();
        this.contact = contact;
    }

    public long getId() {
        return id;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public BigDecimal getWeight() {
        return weight;
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

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
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