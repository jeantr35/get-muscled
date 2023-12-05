package dev.lugus.user.infra.adapters;

import dev.lugus.user.domain.models.UserLogin;
import dev.lugus.user.domain.models.UserRegistration;
import dev.lugus.user.domain.ports.IUserLoginRepository;
import dev.lugus.user.infra.mapper.UserMapper;
import dev.lugus.user.infra.mongo.entities.UserLoginEntity;
import dev.lugus.user.infra.mongo.repositories.UserLoginRepository;
import dev.lugus.user.infra.utilities.PasswordUtility;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UserLoginRepositoryAdapter implements IUserLoginRepository {

    @Inject
    private UserLoginRepository userLoginRepository;

    @Override
    public Boolean userLoginExist(UserLogin userLogin) {
        UserLoginEntity userLoginEntity = userLoginRepository.findByEmail(userLogin.email());
        if (userLoginEntity != null)
            return PasswordUtility.verifyPassword(userLogin.password(), userLoginEntity.getHashedPassword());
        return false;
    }

    @Override
    public Boolean createUserLogin(UserRegistration userRegistration) {
        UserLoginEntity userLoginEntity = UserMapper.toLoginEntityFromRegistration(userRegistration);
        userLoginRepository.persist(userLoginEntity);
        return userLoginExist(new UserLogin(userRegistration.email(), userRegistration.password()));
    }
}
