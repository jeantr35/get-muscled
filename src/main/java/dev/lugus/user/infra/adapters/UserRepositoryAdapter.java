package dev.lugus.user.infra.adapters;

import dev.lugus.user.domain.models.User;
import dev.lugus.user.domain.models.UserRegistration;
import dev.lugus.user.domain.ports.IUserRepository;
import dev.lugus.user.infra.mapper.UserMapper;
import dev.lugus.user.infra.mongo.entities.UserEntity;
import dev.lugus.user.infra.mongo.repositories.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UserRepositoryAdapter implements IUserRepository {

    @Inject
    private UserRepository userRepository;

    @Override
    public User persistNewUser(UserRegistration userRegistration) {
        userRepository.persist(UserMapper.toUserEntityFromRegistration(userRegistration));
        return findUserByEmail(userRegistration.email());
    }

    @Override
    public User findUserByEmail(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);
        return userEntity == null ? null : UserMapper.toModel(userEntity);
    }

    @Override
    public User findUserByUsername(String username) {
        UserEntity userEntity = userRepository.findByUsername(username);
        return userEntity == null ? null : UserMapper.toModel(userEntity);
    }
}
