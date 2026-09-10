package com.bhoomi.realestate_backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "site_settings")
@Getter
@Setter
@NoArgsConstructor
public class SiteSettings {

    @Id
    private Long id = 1L;

    // Hero section
    @Column(nullable = false)
    private String heroHeading;

    @Column(nullable = false)
    private String heroSubtext;

    @Column(nullable = false)
    private String statsCitiesCount; // e.g. "40+"

    @Column(nullable = false)
    private String statsDevelopersCount; // e.g. "680+"

    @Column(nullable = false)
    private String statsPropertiesCount; // e.g. "5K+"

    // Section headings
    @Column(nullable = false)
    private String trendingHeading;

    @Column(nullable = false)
    private String trendingSubtext;

    @Column(nullable = false)
    private String whyChooseUsHeading;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String whyChooseUsDescription;

    @Column(nullable = false)
    private String whyChooseUsYearsExperience; // e.g. "15+"

    @Column(nullable = false)
    private String howItWorksHeading;

    @Column(nullable = false)
    private String howItWorksSubtext;

    @Column(nullable = false)
    private String citiesHeading;

    @Column(nullable = false)
    private String citiesSubtext;

    @Column(nullable = false)
    private String testimonialsHeading;

    @Column(nullable = false)
    private String testimonialsSubtext;

    // CTA banner
    @Column(nullable = false)
    private String ctaHeading;

    @Column(nullable = false)
    private String ctaSubtext;

    // Contact info (used in the enquiry section)
    @Column(nullable = false)
    private String contactPhone;

    @Column(nullable = false)
    private String contactPhoneHours; // e.g. "Mon to Sat, 9am to 7pm"

    @Column(nullable = false)
    private String contactEmail;

    @Column(nullable = false)
    private String contactAddress;
}