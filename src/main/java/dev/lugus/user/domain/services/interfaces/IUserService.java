package dev.lugus.user.domain.services.interfaces;

import dev.lugus.user.domain.models.User;
import dev.lugus.user.domain.models.UserLogin;
import dev.lugus.user.domain.models.UserRegistration;
import dev.lugus.user.domain.models.UserToken;

public interface IUserService {

    User registerNewUser(UserRegistration userRegistration);

    UserToken loginUser(UserLogin userLogin);

}
