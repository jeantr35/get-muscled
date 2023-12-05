package dev.lugus.user.infra.adapters;

import dev.lugus.user.domain.models.UserToken;
import dev.lugus.user.domain.ports.IUserTokenUtil;
import dev.lugus.user.infra.utilities.TokenUtility;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserTokenUtilAdapter implements IUserTokenUtil {
    @Override
    public UserToken getTokenForEmail(String email, String role) {
        return new UserToken(TokenUtility.generateToken(email, role));
    }
}
