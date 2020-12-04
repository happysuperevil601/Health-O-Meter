package com.superdevs.HealthOMeter.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "whrdata")
public class WHRData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name="waist_size")
    private BigDecimal waistSize;

    @Column(name="hip_size")
    private BigDecimal hipSize;

    @Column(name = "result")
    private BigDecimal result;

    @Column(name = "created")
    private LocalDateTime created;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private Contact contact;

    public WHRData() {
    }

    public WHRData(long id, BigDecimal waistSize, BigDecimal hipSize,
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
