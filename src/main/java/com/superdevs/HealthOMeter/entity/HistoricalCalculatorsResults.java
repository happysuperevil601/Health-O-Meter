package com.superdevs.HealthOMeter.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "historicalcalculatorsresults")
public class HistoricalCalculatorsResults {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToMany
    @JoinColumn(name = "contact_id")
    private Set<Contact>contacts;

    @Column(name = "result")
    private BigDecimal result;

    @Column(name = "isWHR")
    private boolean isWHR;

    @Column(name = "isBMI")
    private boolean isBMI;

    @Column(name = "isRFM")
    private boolean isRFM;

    @Column(name = "created")
    private LocalDateTime created;

    public HistoricalCalculatorsResults() {
    }

    public long getId() {
        return id;
    }

    public Set<Contact> getContacts() {
        return contacts;
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

    public void setId(long id) {
        this.id = id;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
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
}