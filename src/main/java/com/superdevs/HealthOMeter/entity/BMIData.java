package com.superdevs.HealthOMeter.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "bmidata")
public class BMIData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "height")
    private BigDecimal height;

    @Column(name = "weight")
    private BigDecimal weight;

    @Column(name = "result")
    private BigDecimal result;

    @Column(name = "created")
    private LocalDateTime created;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private Contact contact;

    public BMIData() {
    }

    public BMIData(long id, BigDecimal height, BigDecimal weight, BigDecimal result, Contact contact) {
        this.id = id;
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