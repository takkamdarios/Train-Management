package com.train_management.train_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.*;

@Entity
@Table(name = "agency")
public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agency_id")
    private Long agencyId;

    @Column(name = "agency_name", nullable = false, unique = true)
    private String agencyName;

    @Column(name = "agency_url", nullable = false)
    private String agencyUrl;

    @Column(name = "agency_timezone", nullable = false)
    private String agencyTimezone;

    @Column(name = "agency_phone")
    private String agencyPhone;

    @Column(name = "agency_lang")
    private String agencyLang;

    // Standard getters and setters using 'agencyId' instead of 'id'

    public Long getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Long agencyId) {
        this.agencyId = agencyId;
    }

    public String getAgencyName() {
        return this.agencyName;
    }

    public String getAgencyUrl() {
        return this.agencyUrl;
    }

    public String getAgencyTimezone() {
        return this.agencyTimezone;
    }

    public String getAgencyPhone() {
        return this.agencyPhone;
    }

    public String getAgencyLang() {
        return this.agencyLang;
    }

    public void setId(final Long id) {
        this.agencyId = id;
    }

    public void setAgencyName(final String agencyName) {
        this.agencyName = agencyName;
    }

    public void setAgencyUrl(final String agencyUrl) {
        this.agencyUrl = agencyUrl;
    }

    public void setAgencyTimezone(final String agencyTimezone) {
        this.agencyTimezone = agencyTimezone;
    }

    public void setAgencyPhone(final String agencyPhone) {
        this.agencyPhone = agencyPhone;
    }

    public void setAgencyLang(final String agencyLang) {
        this.agencyLang = agencyLang;
    }


    protected boolean canEqual(final Object other) {
        return other instanceof Agency;
    }



    public Agency() {
    }
}
