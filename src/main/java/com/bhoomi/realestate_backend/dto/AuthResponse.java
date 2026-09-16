package com.bhoomi.realestate_backend.dto;

import com.bhoomi.realestate_backend.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponse {
    private String token;
    private UserInfo user;

    public AuthResponse(String token, String name, String email, String phone, Role role) {
        this.token = token;
        this.user = new UserInfo(name, email, phone, role);
    }

    @Getter
    @Setter
    public static class UserInfo {
        private String name;
        private String email;
        private String phone;
        private Role role;

        public UserInfo(String name, String email, String phone, Role role) {
            this.name = name;
            this.email = email;
            this.phone = phone;
            this.role = role;
        }
    }
}