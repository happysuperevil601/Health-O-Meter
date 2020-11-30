package com.superdevs.HealthOMeter.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "historicalcalculatorsresults")
public class HistoricalCalculatorsResults {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

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

    public HistoricalCalculatorsResults(long id, Contact contact, BigDecimal result, boolean isWHR, boolean isBMI,
                                        boolean isRFM) {
        this.id = id;
        this.contact = contact;
        this.result = result;
        this.isWHR = isWHR;
        this.isBMI = isBMI;
        this.isRFM = isRFM;
        this.created = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public Contact getContact() {
        return contact;
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

    public void setContact(Contact contact) {
        this.contact = contact;
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