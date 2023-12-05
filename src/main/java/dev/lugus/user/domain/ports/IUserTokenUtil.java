package dev.lugus.user.domain.ports;

import dev.lugus.user.domain.models.UserToken;

public interface IUserTokenUtil {

    UserToken getTokenForEmail(String email, String role);

}
