package dev.lugus.user.infra.mongo.repositories;

import dev.lugus.user.infra.mongo.entities.UserEntity;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheMongoRepository<UserEntity> {

    public UserEntity findByEmail(String email){
        return find("email", email).firstResult();
    }
    public UserEntity findByUsername(String username){
        return find("username", username).firstResult();
    }

}
