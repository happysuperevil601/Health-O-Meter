package com.superdevs.HealthOMeter.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "medicalData")
public class MedicalData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @Column(name = "created")
    private LocalDateTime created;

    public MedicalData() {
    }

    public MedicalData(Contact contact) {
        this.contact = contact;
        this.created = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public Contact getContact() {
        return contact;
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

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
