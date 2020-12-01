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
    private Contact contact;

    @Column(name = "createde")
    private LocalDateTime createde;

    public HistoricalMedicalData() {
    }

    public HistoricalMedicalData(Contact contact) {
        this.contact = contact;
        this.createde = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public Contact getContact() {
        return contact;
    }

    public LocalDateTime getCreatede() {
        return createde;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public void setCreatede(LocalDateTime createde) {
        this.createde = createde;
    }
}
