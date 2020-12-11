package com.superdevs.HealthOMeter.dto;

import com.superdevs.HealthOMeter.entity.Contact;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class WHRDataDto {

    private long id;
    private BigDecimal waistSize;
    private BigDecimal hipSize;
    private BigDecimal result;
    private LocalDateTime created;
    private Contact contact;

    public WHRDataDto() {
    }

    public WHRDataDto(long id, BigDecimal waistSize, BigDecimal hipSize,
                   BigDecimal result, Contact contact) {
        this.id = id;
        this.waistSize = waistSize;
        this.hipSize = hipSize;
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

    public BigDecimal getHipSize() {
        return hipSize;
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

    public void setHipSize(BigDecimal hipSize) {
        this.hipSize = hipSize;
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