package com.superdevs.HealthOMeter.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
    @JsonBackReference
    private Contact contact;

    public HistoricalMedicalData() {
    }

    public HistoricalMedicalData(Contact contact) {
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