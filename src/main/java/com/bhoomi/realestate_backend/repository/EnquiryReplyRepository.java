package com.bhoomi.realestate_backend.repository;

import com.bhoomi.realestate_backend.entity.EnquiryReply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnquiryReplyRepository extends JpaRepository<EnquiryReply, Long> {
    List<EnquiryReply> findByEnquiryIdOrderByCreatedAtAsc(Long enquiryId);
}