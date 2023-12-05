package dev.lugus.user.infra.mapper;

import dev.lugus.user.domain.models.User;
import dev.lugus.user.domain.models.UserLogin;
import dev.lugus.user.domain.models.UserRegistration;
import dev.lugus.user.infra.mongo.entities.UserEntity;
import dev.lugus.user.infra.mongo.entities.UserLoginEntity;
import dev.lugus.user.infra.utilities.PasswordUtility;

public class UserMapper {

    private UserMapper(){}

    public static UserLogin toModel(UserLoginEntity userLoginEntity){
        return new UserLogin(userLoginEntity.getEmail(), userLoginEntity.getHashedPassword());
    }

    public static User toModel(UserEntity userEntity){
        return new User(userEntity.getUsername(), userEntity.getEmail(), userEntity.getRole(), userEntity.getIsVerified());
    }
    public static UserLoginEntity toEntity(UserLogin userLogin){
        UserLoginEntity userLoginEntity = new UserLoginEntity();
        userLoginEntity.setEmail(userLogin.email());
        userLoginEntity.setHashedPassword(PasswordUtility.getHashed(userLogin.password()));
        return userLoginEntity;
    }
    public static UserEntity toEntity(User user){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(user.username());
        userEntity.setEmail(user.email());
        userEntity.setRole(user.role());
        return userEntity;
    }
    public static UserLoginEntity toLoginEntityFromRegistration(UserRegistration userRegistration){
        UserLoginEntity userLoginEntity = new UserLoginEntity();
        userLoginEntity.setEmail(userRegistration.email());
        userLoginEntity.setHashedPassword(PasswordUtility.getHashed(userRegistration.password()));
        return userLoginEntity;
    }
    public static UserEntity toUserEntityFromRegistration(UserRegistration userRegistration){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userRegistration.username());
        userEntity.setEmail(userRegistration.email());
        userEntity.setRole(userRegistration.role());
        userEntity.setIsVerified(Boolean.FALSE);
        return userEntity;
    }

}
