package com.superdevs.HealthOMeter.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "historicalMedicalData")
public class HistoricalMedicalData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "created")
    private LocalDateTime created;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    public HistoricalMedicalData() {
    }

    public HistoricalMedicalData(long id, Contact contact) {
        this.id = id;
        this.created = LocalDateTime.now();
        this.contact = contact;
    }

    public long getId() {
        return id;
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

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}