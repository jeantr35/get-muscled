package dev.lugus.user.infra.controllers;

import dev.lugus.user.application.commands.UserLoginCommand;
import dev.lugus.user.application.commands.UserRegisterCommand;
import dev.lugus.user.application.handler.UserHandler;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
public class UserController {

    @Inject
    UserHandler userHandler;

    @Path("/register")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerUser(UserRegisterCommand userRegisterCommand){
        return userHandler.registerNewUser(userRegisterCommand);
    }

    @Path("/login")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response loginUser(UserLoginCommand userLoginCommand){
        return userHandler.loginUser(userLoginCommand);
    }

}
