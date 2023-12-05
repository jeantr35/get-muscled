package dev.lugus.user.domain.models;

public record UserRegistration(String username, String email, String password, String role) {
}
