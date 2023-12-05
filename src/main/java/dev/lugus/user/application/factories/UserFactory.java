package dev.lugus.user.application.factories;

import dev.lugus.user.application.commands.UserLoginCommand;
import dev.lugus.user.application.commands.UserRegisterCommand;
import dev.lugus.user.domain.models.UserLogin;
import dev.lugus.user.domain.models.UserRegistration;

public class UserFactory {

    private UserFactory(){}

    public static UserLogin toModel(UserLoginCommand userLoginCommand){
        return new UserLogin(userLoginCommand.getEmail(), userLoginCommand.getPassword());
    }

    public static UserRegistration toModel(UserRegisterCommand userRegisterCommand){
        return new UserRegistration(userRegisterCommand.getUsername(), userRegisterCommand.getEmail(), userRegisterCommand.getPassword(), userRegisterCommand.getRole());
    }

}
