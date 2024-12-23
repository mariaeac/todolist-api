package com.meac.todolistapi.entities;

import jakarta.validation.constraints.NotBlank;

public class UserAuthDTO {

    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    public UserAuthDTO() {

    }

    public UserAuthDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public @NotBlank(message = "Email is required") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email is required") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Password is required") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Password is required") String password) {
        this.password = password;
    }
}
