package com.superdevs.HealthOMeter.dto;

import com.superdevs.HealthOMeter.entity.Contact;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RFMDataDto {

    private long id;
    private BigDecimal waistSize;
    private BigDecimal height;
    private BigDecimal result;
    private LocalDateTime created;
    private Contact contact;

    public RFMDataDto() {
    }

    public RFMDataDto(BigDecimal waistSize, BigDecimal height, BigDecimal result, Contact contact) {
        this.waistSize = waistSize;
        this.height = height;
        this.result = result;
        this.created = LocalDateTime.now();
        this.contact = contact;
    }

    public long getId() {
        return id;
    }

    public BigDecimal getWaistSize() {
        return waistSize;
    }

    public BigDecimal getHeight() {
        return height;
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

    public void setWaistSize(BigDecimal waistSize) {
        this.waistSize = waistSize;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
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