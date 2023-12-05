package dev.lugus.user.application.handler;

import dev.lugus.user.application.commands.UserLoginCommand;
import dev.lugus.user.application.commands.UserRegisterCommand;
import dev.lugus.user.application.factories.UserFactory;
import dev.lugus.user.application.responses.UserResponseDTO;
import dev.lugus.user.domain.models.User;
import dev.lugus.user.domain.models.UserToken;
import dev.lugus.user.domain.services.interfaces.IUserService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

import java.time.ZonedDateTime;

@ApplicationScoped
public class UserHandler {

    @Inject
    IUserService userService;

    public Response registerNewUser(UserRegisterCommand userRegisterCommand){
        User user = userService.registerNewUser(UserFactory.toModel(userRegisterCommand));
        return responseBuilder(user);
    }

    public Response loginUser(UserLoginCommand userLoginCommand){
        UserToken userToken = userService.loginUser(UserFactory.toModel(userLoginCommand));
        return responseBuilder(userToken);
    }


    private <T> Response responseBuilder(T data){
        return data == null ?
                Response.ok(new UserResponseDTO<T>(ZonedDateTime.now(), false, null)).build() :
                Response.ok(new UserResponseDTO<>(ZonedDateTime.now(), true, data)).build();
    }

}
