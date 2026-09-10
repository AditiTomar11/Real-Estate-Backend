package com.bhoomi.realestate_backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "trending_projects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrendingProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String builder;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String type; // e.g. "2, 3 & 4.5 BHK" — kept as free text, not a strict enum

    @Column(nullable = false)
    private String area; // e.g. "2678 SQ. FT."

    @Column(nullable = false)
    private String price; // e.g. "₹ 1.43 Cr - 3.02 Cr" — a range, so text not a number

    @Column(nullable = false)
    private String imageUrl;

    private boolean isNew = false;

    @Column(nullable = false)
    private Integer displayOrder = 0; // controls the order admin wants these shown in
}