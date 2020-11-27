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

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contacts;

    @Column(name = "result")
    private BigDecimal result;

    @Column(name = "created")
    private LocalDateTime created;

    public WHRData() {
    }

    public WHRData(long id, Contact contacts, BigDecimal result) {
        this.id = id;
        this.contacts = contacts;
        this.result = result;
        this.created =  LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public Contact getContacts() {
        return contacts;
    }

    public BigDecimal getResult() {
        return result;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setContacts(Contact contacts) {
        this.contacts = contacts;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
