package com.superdevs.HealthOMeter.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "historicalMedicalData")
public class HistoricalMedicalData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contacts;

    @Column(name = "createde")
    private LocalDateTime createde;

    public HistoricalMedicalData() {
    }

    public HistoricalMedicalData(long id, Contact contacts) {
        this.id = id;
        this.contacts = contacts;
        this.createde = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public Contact getContacts() {
        return contacts;
    }

    public LocalDateTime getCreatede() {
        return createde;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setContacts(Contact contacts) {
        this.contacts = contacts;
    }

    public void setCreatede(LocalDateTime createde) {
        this.createde = createde;
    }
}
