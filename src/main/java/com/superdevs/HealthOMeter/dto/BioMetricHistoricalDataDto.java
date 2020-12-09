package com.superdevs.HealthOMeter.dto;

import com.superdevs.HealthOMeter.entity.Contact;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BioMetricHistoricalDataDto {

    private long id;
    private BigDecimal growth;
    private BigDecimal weight;
    private BigDecimal waistCirc;
    private BigDecimal hipCirc;
    private LocalDateTime created;
    private Contact contact;

    public BioMetricHistoricalDataDto() {
    }

    public BioMetricHistoricalDataDto(long id, BigDecimal growth, BigDecimal weight, BigDecimal waistCirc,
                                      BigDecimal hipCirc, Contact contact) {
        this.id = id;
        this.growth = growth;
        this.weight = weight;
        this.waistCirc = waistCirc;
        this.hipCirc = hipCirc;
        this.created = LocalDateTime.now();
        this.contact = contact;
    }

    public long getId() {
        return id;
    }

    public BigDecimal getGrowth() {
        return growth;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public BigDecimal getWaistCirc() {
        return waistCirc;
    }

    public BigDecimal getHipCirc() {
        return hipCirc;
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

    public void setGrowth(BigDecimal growth) {
        this.growth = growth;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public void setWaistCirc(BigDecimal waistCirc) {
        this.waistCirc = waistCirc;
    }

    public void setHipCirc(BigDecimal hipCirc) {
        this.hipCirc = hipCirc;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}