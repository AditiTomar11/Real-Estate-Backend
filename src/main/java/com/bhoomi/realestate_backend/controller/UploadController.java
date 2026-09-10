package com.bhoomi.realestate_backend.controller;

import com.bhoomi.realestate_backend.service.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/uploads")
@RequiredArgsConstructor
public class UploadController {

    private final UploadService uploadService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Map<String, List<String>> upload(@RequestParam("files") List<MultipartFile> files) {
        List<String> urls = uploadService.uploadImages(files);
        return Map.of("urls", urls);
    }
}