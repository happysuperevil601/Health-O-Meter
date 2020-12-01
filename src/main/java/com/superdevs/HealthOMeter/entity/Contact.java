package com.superdevs.HealthOMeter.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contact")
    private Set<BioMetricData> bioMetricData;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contact")
    private Set<BioMetricHistoricalData> bioMetricHistoricalData;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contact")
    private Set<BMIData> bmiData;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contact")
    private Set<WHRData> whrData;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contact")
    private Set<RFMData> rfmData;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contact")
    private Set<HistoricalCalculatorsResults> historicalCalculatorsResults;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contact")
    private Set<MedicalData> medicalData;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contact")
    private Set<HistoricalMedicalData> historicalMedicalData;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "nick_name", unique = true)
    private String nickName;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "updated")
    private LocalDateTime updated;

    public Contact() {
    }

    public Contact(Set<BioMetricData> bioMetricData, Set<BioMetricHistoricalData> bioMetricHistoricalData,
                   Set<BMIData> bmiData, Set<WHRData> whrData, Set<RFMData> rfmData,
                   Set<HistoricalCalculatorsResults> historicalCalculatorsResults, Set<MedicalData> medicalData,
                   Set<HistoricalMedicalData> historicalMedicalData, String firstName, String lastName,
                   String email, String nickName, String country, String city) {
        this.bioMetricData = bioMetricData;
        this.bioMetricHistoricalData = bioMetricHistoricalData;
        this.bmiData = bmiData;
        this.whrData = whrData;
        this.rfmData = rfmData;
        this.historicalCalculatorsResults = historicalCalculatorsResults;
        this.medicalData = medicalData;
        this.historicalMedicalData = historicalMedicalData;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.nickName = nickName;
        this.country = country;
        this.city = city;
        this.created = LocalDateTime.now();
        this.updated = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public Set<BioMetricData> getBioMetricData() {
        return bioMetricData;
    }

    public Set<BioMetricHistoricalData> getBioMetricHistoricalData() {
        return bioMetricHistoricalData;
    }

    public Set<BMIData> getBmiData() {
        return bmiData;
    }

    public Set<WHRData> getWhrData() {
        return whrData;
    }

    public Set<RFMData> getRfmData() {
        return rfmData;
    }

    public Set<HistoricalCalculatorsResults> getHistoricalCalculatorsResults() {
        return historicalCalculatorsResults;
    }

    public Set<MedicalData> getMedicalData() {
        return medicalData;
    }

    public Set<HistoricalMedicalData> getHistoricalMedicalData() {
        return historicalMedicalData;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getNickName() {
        return nickName;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setBioMetricData(Set<BioMetricData> bioMetricData) {
        this.bioMetricData = bioMetricData;
    }

    public void setBioMetricHistoricalData(Set<BioMetricHistoricalData> bioMetricHistoricalData) {
        this.bioMetricHistoricalData = bioMetricHistoricalData;
    }

    public void setBmiData(Set<BMIData> bmiData) {
        this.bmiData = bmiData;
    }

    public void setWhrData(Set<WHRData> whrData) {
        this.whrData = whrData;
    }

    public void setRfmData(Set<RFMData> rfmData) {
        this.rfmData = rfmData;
    }

    public void setHistoricalCalculatorsResults(Set<HistoricalCalculatorsResults> historicalCalculatorsResults) {
        this.historicalCalculatorsResults = historicalCalculatorsResults;
    }

    public void setMedicalData(Set<MedicalData> medicalData) {
        this.medicalData = medicalData;
    }

    public void setHistoricalMedicalData(Set<HistoricalMedicalData> historicalMedicalData) {
        this.historicalMedicalData = historicalMedicalData;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }
}