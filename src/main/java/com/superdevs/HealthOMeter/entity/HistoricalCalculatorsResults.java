package com.superdevs.HealthOMeter.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "historicalcalculatorsresults")
public class HistoricalCalculatorsResults {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

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

    @ManyToOne
    @JoinColumn(name = "contact_id")
    @JsonBackReference
    private Contact contact;

    public HistoricalCalculatorsResults() {
    }

    public HistoricalCalculatorsResults(BigDecimal result, boolean isWHR, boolean isBMI,
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