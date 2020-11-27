package com.superdevs.HealthOMeter.entity;

import javax.validation.constraints.NotBlank;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contacts")
    private Set<BioMetricData> bioMetricData;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contacts")
    private Set<BioMetricHistoricalData> bioMetricHistoricalData;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contacts")
    private Set<BMIData> bmiData;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contacts")
    private Set<WHRData> whrData;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contacts")
    private Set<RFMData> rfmData;

    @ManyToMany
    @JoinTable(
            name = "historicalcalculatorsresults_contact",
            joinColumns = @JoinColumn(name = "contact_id"),
            inverseJoinColumns = @JoinColumn(name = "historicalcalculatorsresults_id")    )
    private Set<HistoricalCalculatorsResults> historicalCalculatorsResults;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medicaldata_id", referencedColumnName = "id")
    private MedicalData medicalData;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contacts")
    private Set<HistoricalMedicalData> historicalMedicalData;

    @Column(name = "first_name")
    @NotBlank(message = "First name must not be null or empty!")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    @NotBlank(message = "Email must not be null or empty!")
    private String email;

    @Column(name = "nick_name")
    @NotBlank(message = "Nick name must not be null or empty!")
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

    public Contact(long id, String firstName, String email, String nickName) {
        this.id = id;
        this.firstName = firstName;
        this.email = email;
        this.nickName = nickName;
        this.created = LocalDateTime.now();
    }

    public Contact(long id, String firstName, String lastName, String email,
                   String nickName, String country, String city, LocalDateTime updated) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.nickName = nickName;
        this.country = country;
        this.city = city;
        this.created =  LocalDateTime.now();;
        this.updated = updated;
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

    public MedicalData getMedicalData() {
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

    public void setMedicalData(MedicalData medicalData) {
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