package dev.lugus.user.domain.models;

public record User(String username, String email, String role, Boolean isVerified) {
}
