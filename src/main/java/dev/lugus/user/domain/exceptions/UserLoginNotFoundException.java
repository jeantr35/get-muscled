package dev.lugus.user.domain.exceptions;

public class UserLoginNotFoundException extends RuntimeException{

    public UserLoginNotFoundException(String message) {
        super(message);
    }
}
