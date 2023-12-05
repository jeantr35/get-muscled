package dev.lugus.user.infra.exceptionmapper;

import dev.lugus.user.application.responses.UserResponseDTO;
import dev.lugus.user.application.responses.UserResponseErrorData;
import dev.lugus.user.domain.exceptions.UserAlreadyRegisteredException;
import dev.lugus.user.domain.exceptions.UserLoginNotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.jboss.logging.Logger;

import java.time.ZonedDateTime;

@Provider
public class UserExceptionHandler implements ExceptionMapper<Throwable> {
    Logger LOGGER = Logger.getLogger(UserExceptionHandler.class);
    @Override
    public Response toResponse(Throwable throwable) {
        UserResponseErrorData genericError = new UserResponseErrorData("Error with some internal component");
        if (throwable instanceof UserAlreadyRegisteredException userAlreadyRegisteredException){
            UserResponseErrorData userResponseErrorData = new UserResponseErrorData(userAlreadyRegisteredException.getMessage());
            return Response.ok(new UserResponseDTO<>(ZonedDateTime.now(), false, userResponseErrorData))
                    .status(Response.Status.BAD_REQUEST).build();
        } else if (throwable instanceof UserLoginNotFoundException userloginNotFoundException) {
            UserResponseErrorData userResponseErrorData = new UserResponseErrorData(userloginNotFoundException.getMessage());
            return Response.ok(new UserResponseDTO<>(ZonedDateTime.now(), false, userResponseErrorData))
                    .status(Response.Status.UNAUTHORIZED).build();
        } else {
            throwable.printStackTrace();
            LOGGER.error(throwable.getMessage());
            return Response.ok(new UserResponseDTO<>(ZonedDateTime.now(), false, genericError))
                    .status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
