package com.example.LibraryManagement.patron;

import jakarta.persistence.*;

@Entity
@Table(name = "Patrons")
public class Patron {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String contactInfo;
    private boolean membershipStatus;

    public Patron() {
    }

    public Patron(String name, String contactInfo, boolean membershipStatus) {
        this.name = name;
        this.contactInfo = contactInfo;
        this.membershipStatus = membershipStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public boolean isMembershipStatus() {
        return membershipStatus;
    }

    public void setMembershipStatus(boolean membershipStatus) {
        this.membershipStatus = membershipStatus;
    }

    @Override
    public String toString() {
        return "Patron{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", membershipStatus=" + membershipStatus +
                '}';
    }
}
