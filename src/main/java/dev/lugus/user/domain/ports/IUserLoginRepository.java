package dev.lugus.user.domain.ports;

import dev.lugus.user.domain.models.UserLogin;
import dev.lugus.user.domain.models.UserRegistration;

public interface IUserLoginRepository {

    Boolean userLoginExist(UserLogin userLogin);
    Boolean createUserLogin(UserRegistration userRegistration);

}
