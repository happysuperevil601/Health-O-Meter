package com.superdevs.HealthOMeter.dto;

import com.superdevs.HealthOMeter.entity.*;

import java.time.LocalDateTime;
import java.util.Set;

public class ContactDto {

    private long id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String email;
    private String country;
    private String city;
    private LocalDateTime created;
    private LocalDateTime updated;
    private User user;
    private MedicalData medicalData;
    private BioMetricData bioMetricData;
    private BMIData bmiData;
    private WHRData whrData;
    private RFMData rfmData;
    private Set<BioMetricHistoricalData> bioMetricHistoricalData;
    private Set<HistoricalCalculatorsResults> historicalCalculatorsResults;
    private Set<HistoricalMedicalData> historicalMedicalData;

    public ContactDto() {
    }

    public ContactDto(String firstName, String lastName, Gender gender, String email, String country,
                   String city, User user, MedicalData medicalData, BioMetricData bioMetricData, BMIData bmiData, WHRData whrData,
                   RFMData rfmData, Set<BioMetricHistoricalData> bioMetricHistoricalData,
                   Set<HistoricalCalculatorsResults> historicalCalculatorsResults, Set<HistoricalMedicalData> historicalMedicalData) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.country = country;
        this.city = city;
        this.created = LocalDateTime.now();
        this.updated = LocalDateTime.now();
        this.user = user;
        this.medicalData = medicalData;
        this.bioMetricData = bioMetricData;
        this.bmiData = bmiData;
        this.whrData = whrData;
        this.rfmData = rfmData;
        this.bioMetricHistoricalData = bioMetricHistoricalData;
        this.historicalCalculatorsResults = historicalCalculatorsResults;
        this.historicalMedicalData = historicalMedicalData;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
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

    public User getUser() {
        return user;
    }

    public MedicalData getMedicalData() {
        return medicalData;
    }

    public BioMetricData getBioMetricData() {
        return bioMetricData;
    }

    public BMIData getBmiData() {
        return bmiData;
    }

    public WHRData getWhrData() {
        return whrData;
    }

    public RFMData getRfmData() {
        return rfmData;
    }

    public Set<BioMetricHistoricalData> getBioMetricHistoricalData() {
        return bioMetricHistoricalData;
    }

    public Set<HistoricalCalculatorsResults> getHistoricalCalculatorsResults() {
        return historicalCalculatorsResults;
    }

    public Set<HistoricalMedicalData> getHistoricalMedicalData() {
        return historicalMedicalData;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public void setUser(User user) {
        this.user = user;
    }

    public void setMedicalData(MedicalData medicalData) {
        this.medicalData = medicalData;
    }

    public void setBioMetricData(BioMetricData bioMetricData) {
        this.bioMetricData = bioMetricData;
    }

    public void setBmiData(BMIData bmiData) {
        this.bmiData = bmiData;
    }

    public void setWhrData(WHRData whrData) {
        this.whrData = whrData;
    }

    public void setRfmData(RFMData rfmData) {
        this.rfmData = rfmData;
    }

    public void setBioMetricHistoricalData(Set<BioMetricHistoricalData> bioMetricHistoricalData) {
        this.bioMetricHistoricalData = bioMetricHistoricalData;
    }

    public void setHistoricalCalculatorsResults(Set<HistoricalCalculatorsResults> historicalCalculatorsResults) {
        this.historicalCalculatorsResults = historicalCalculatorsResults;
    }

    public void setHistoricalMedicalData(Set<HistoricalMedicalData> historicalMedicalData) {
        this.historicalMedicalData = historicalMedicalData;
    }
}