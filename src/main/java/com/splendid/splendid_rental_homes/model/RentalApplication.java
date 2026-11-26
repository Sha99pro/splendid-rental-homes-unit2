package com.splendid.splendid_rental_homes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "rental_applications")
public class RentalApplication {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;

    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private User applicant;

    private LocalDate leaseStartDate;
    private int leaseLength;
    private double monthlyIncome;
    private String currentEmployer;
    private String currentAddress;

    @Column(columnDefinition = "json")
    private String applicationDetails;

    private String message;
    private String status;

    @Column(name = "submitted_at")
    private LocalDateTime submittedAt;

    @Column(name = "active_application_key")
    private Integer activeApplicationKey;

    public RentalApplication() {
    }

    public RentalApplication(Property property, User applicant, LocalDate leaseStartDate, int leaseLength, double monthlyIncome, String currentEmployer, String currentAddress, String applicationDetails, String message, String status, LocalDateTime submittedAt, Integer activeApplicationKey) {
        this.property = property;
        this.applicant = applicant;
        this.leaseStartDate = leaseStartDate;
        this.leaseLength = leaseLength;
        this.monthlyIncome = monthlyIncome;
        this.currentEmployer = currentEmployer;
        this.currentAddress = currentAddress;
        this.applicationDetails = applicationDetails;
        this.message = message;
        this.status = status;
        this.activeApplicationKey = activeApplicationKey;
        this.submittedAt = submittedAt;
    }

    public int getId() {
        return id;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public User getApplicant() {
        return applicant;
    }

    public void setApplicant(User applicant) {
        this.applicant = applicant;
    }

    public LocalDate getLeaseStartDate() {
        return leaseStartDate;
    }

    public void setLeaseStartDate(LocalDate leaseStartDate) {
        this.leaseStartDate = leaseStartDate;
    }

    public int getLeaseLength() {
        return leaseLength;
    }

    public void setLeaseLength(int leaseLength) {
        this.leaseLength = leaseLength;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public String getCurrentEmployer() {
        return currentEmployer;
    }

    public void setCurrentEmployer(String currentEmployer) {
        this.currentEmployer = currentEmployer;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getApplicationDetails() {
        return applicationDetails;
    }

    public void setApplicationDetails(String applicationDetails) {
        this.applicationDetails = applicationDetails;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }

    public Integer getActiveApplicationKey() {
        return activeApplicationKey;
    }

    public void setActiveApplicationKey(Integer activeApplicationKey) {
        this.activeApplicationKey = activeApplicationKey;
    }
}
