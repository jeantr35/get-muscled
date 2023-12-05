package dev.lugus.user.domain.services.implementation;

import dev.lugus.user.domain.exceptions.UserAlreadyRegisteredException;
import dev.lugus.user.domain.exceptions.UserLoginNotFoundException;
import dev.lugus.user.domain.models.User;
import dev.lugus.user.domain.models.UserLogin;
import dev.lugus.user.domain.models.UserRegistration;
import dev.lugus.user.domain.models.UserToken;
import dev.lugus.user.domain.ports.IUserLoginRepository;
import dev.lugus.user.domain.ports.IUserRepository;
import dev.lugus.user.domain.ports.IUserTokenUtil;
import dev.lugus.user.domain.services.interfaces.IUserService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UserService implements IUserService {

    @Inject
    IUserRepository userRepository;

    @Inject
    IUserLoginRepository userLoginRepository;

    @Inject
    IUserTokenUtil userTokenUtil;

    @Override
    public User registerNewUser(UserRegistration userRegistration) {
        validateUserExist(userRegistration);
        Boolean userLoginRegistered = userLoginRepository.createUserLogin(userRegistration);
        //TODO: Create a event that sends the email
        return Boolean.TRUE.equals(userLoginRegistered) ? userRepository.persistNewUser(userRegistration) : null;
    }

    @Override
    public UserToken loginUser(UserLogin userLogin) {
        Boolean userLoginExist = userLoginRepository.userLoginExist(userLogin);
        if (Boolean.FALSE.equals(userLoginExist))
            throw new UserLoginNotFoundException("Email or password wrong");
        User user = userRepository.findUserByEmail(userLogin.email());
        //TODO: Throw an exception if the email isn't yet verified
        return userTokenUtil.getTokenForEmail(user.email(), user.role());
    }
    private void validateUserExist(UserRegistration userRegistration) {
        User userFoundEmail = userRepository.findUserByEmail(userRegistration.email());
        if (userFoundEmail != null)
            throw new UserAlreadyRegisteredException("User email already registered");
        User userFoundUsername = userRepository.findUserByUsername(userRegistration.username());
        if (userFoundUsername != null)
            throw new UserAlreadyRegisteredException("Username already registered");
    }
}
