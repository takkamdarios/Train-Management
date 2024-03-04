package com.train_management.train_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.*;

@Entity
public class Agency {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(
            nullable = false,
            unique = true
    )
    private String agencyName;
    @Column(
            nullable = false
    )
    private String agencyUrl;
    @Column(
            nullable = false
    )
    private String agencyTimezone;
    @Column(
            nullable = true
    )
    private String agencyPhone;
    @Column(
            nullable = true
    )
    private String agencyLang;

    public Long getId() {
        return this.id;
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
        this.id = id;
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

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Agency)) {
            return false;
        } else {
            Agency other = (Agency)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$id = this.getId();
                Object other$id = other.getId();
                if (this$id == null) {
                    if (other$id != null) {
                        return false;
                    }
                } else if (!this$id.equals(other$id)) {
                    return false;
                }

                Object this$agencyName = this.getAgencyName();
                Object other$agencyName = other.getAgencyName();
                if (this$agencyName == null) {
                    if (other$agencyName != null) {
                        return false;
                    }
                } else if (!this$agencyName.equals(other$agencyName)) {
                    return false;
                }

                Object this$agencyUrl = this.getAgencyUrl();
                Object other$agencyUrl = other.getAgencyUrl();
                if (this$agencyUrl == null) {
                    if (other$agencyUrl != null) {
                        return false;
                    }
                } else if (!this$agencyUrl.equals(other$agencyUrl)) {
                    return false;
                }

                label62: {
                    Object this$agencyTimezone = this.getAgencyTimezone();
                    Object other$agencyTimezone = other.getAgencyTimezone();
                    if (this$agencyTimezone == null) {
                        if (other$agencyTimezone == null) {
                            break label62;
                        }
                    } else if (this$agencyTimezone.equals(other$agencyTimezone)) {
                        break label62;
                    }

                    return false;
                }

                label55: {
                    Object this$agencyPhone = this.getAgencyPhone();
                    Object other$agencyPhone = other.getAgencyPhone();
                    if (this$agencyPhone == null) {
                        if (other$agencyPhone == null) {
                            break label55;
                        }
                    } else if (this$agencyPhone.equals(other$agencyPhone)) {
                        break label55;
                    }

                    return false;
                }

                Object this$agencyLang = this.getAgencyLang();
                Object other$agencyLang = other.getAgencyLang();
                if (this$agencyLang == null) {
                    if (other$agencyLang != null) {
                        return false;
                    }
                } else if (!this$agencyLang.equals(other$agencyLang)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Agency;
    }

    public int hashCode() {
        Boolean PRIME = true;
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $agencyName = this.getAgencyName();
        result = result * 59 + ($agencyName == null ? 43 : $agencyName.hashCode());
        Object $agencyUrl = this.getAgencyUrl();
        result = result * 59 + ($agencyUrl == null ? 43 : $agencyUrl.hashCode());
        Object $agencyTimezone = this.getAgencyTimezone();
        result = result * 59 + ($agencyTimezone == null ? 43 : $agencyTimezone.hashCode());
        Object $agencyPhone = this.getAgencyPhone();
        result = result * 59 + ($agencyPhone == null ? 43 : $agencyPhone.hashCode());
        Object $agencyLang = this.getAgencyLang();
        result = result * 59 + ($agencyLang == null ? 43 : $agencyLang.hashCode());
        return result;
    }

    public String toString() {
        return "Agency(id=" + this.getId() + ", agencyName=" + this.getAgencyName() + ", agencyUrl=" + this.getAgencyUrl() + ", agencyTimezone=" + this.getAgencyTimezone() + ", agencyPhone=" + this.getAgencyPhone() + ", agencyLang=" + this.getAgencyLang() + ")";
    }

    public Agency() {
    }
}
