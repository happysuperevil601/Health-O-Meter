package com.superdevs.HealthOMeter.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "biometricdata")
public class BioMetricData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @Column(name = "growth")
    private BigDecimal growth;

    @Column(name = "weight")
    private BigDecimal weight;

    @Column(name = "waist_circ")
    private BigDecimal waistCirc;

    @Column(name = "hip_circ")
    private BigDecimal hipCirc;

    @Column(name = "created")
    private LocalDateTime created;

    public BioMetricData() {
    }

    public BioMetricData(long id, Contact contact, BigDecimal growth, BigDecimal weight,
                         BigDecimal waistCirc, BigDecimal hipCirc) {
        this.id = id;
        this.contact = contact;
        this.growth = growth;
        this.weight = weight;
        this.waistCirc = waistCirc;
        this.hipCirc = hipCirc;
        this.created = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public Contact getContact() {
        return contact;
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

    public void setId(long id) {
        this.id = id;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
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
}