package com.bhoomi.realestate_backend.dto;

import com.bhoomi.realestate_backend.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponse {
    private String token;
    private UserInfo user;

    public AuthResponse(String token, String name, String email, Role role) {
        this.token = token;
        this.user = new UserInfo(name, email, role);
    }

    @Getter
    @Setter
    public static class UserInfo {
        private String name;
        private String email;
        private Role role;

        public UserInfo(String name, String email, Role role) {
            this.name = name;
            this.email = email;
            this.role = role;
        }
    }
}