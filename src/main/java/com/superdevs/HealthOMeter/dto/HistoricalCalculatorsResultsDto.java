package com.superdevs.HealthOMeter.dto;

import com.superdevs.HealthOMeter.entity.Contact;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class HistoricalCalculatorsResultsDto {

    private long id;
    private BigDecimal result;
    private boolean isWHR;
    private boolean isBMI;
    private boolean isRFM;
    private LocalDateTime created;
    private Contact contact;

    public HistoricalCalculatorsResultsDto() {
    }

    public HistoricalCalculatorsResultsDto(BigDecimal result, boolean isWHR, boolean isBMI,
                                        boolean isRFM, Contact contact) {
        this.result = result;
        this.isWHR = isWHR;
        this.isBMI = isBMI;
        this.isRFM = isRFM;
        this.created = LocalDateTime.now();
        this.contact = contact;
    }

    public long getId() {
        return id;
    }

    public BigDecimal getResult() {
        return result;
    }

    public boolean isWHR() {
        return isWHR;
    }

    public boolean isBMI() {
        return isBMI;
    }

    public boolean isRFM() {
        return isRFM;
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

    public void setWHR(boolean WHR) {
        isWHR = WHR;
    }

    public void setBMI(boolean BMI) {
        isBMI = BMI;
    }

    public void setRFM(boolean RFM) {
        isRFM = RFM;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}