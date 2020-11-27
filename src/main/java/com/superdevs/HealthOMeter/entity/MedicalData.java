package com.superdevs.HealthOMeter.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "medicalData")
public class MedicalData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToOne(mappedBy = "medicalData")
    private Contact contacts;

    @Column(name = "created")
    private LocalDateTime created;

    public MedicalData() {
    }

    public MedicalData(long id, Contact contacts) {
        this.id = id;
        this.contacts = contacts;
        this.created = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public Contact getContacts() {
        return contacts;
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

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
