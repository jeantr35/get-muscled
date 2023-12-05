package dev.lugus.user.domain.ports;

import dev.lugus.user.domain.models.User;
import dev.lugus.user.domain.models.UserRegistration;

public interface IUserRepository {

    User persistNewUser(UserRegistration userRegistration);
    User findUserByEmail(String email);
    User findUserByUsername(String username);

}
