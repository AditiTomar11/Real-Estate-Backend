package com.bhoomi.realestate_backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "enquiry_replies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnquiryReply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "enquiry_id", nullable = false)
    private Enquiry enquiry;

    @Column(nullable = false)
    private String sender = "ADMIN";

    @Column(nullable = false, columnDefinition = "TEXT")
    private String message;

    @Column(nullable = false)
    private boolean sentViaEmail;

    private LocalDateTime createdAt = LocalDateTime.now();
}