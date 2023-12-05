package dev.lugus.user.infra.mongo.repositories;

import dev.lugus.user.infra.mongo.entities.UserLoginEntity;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserLoginRepository implements PanacheMongoRepository<UserLoginEntity> {

    public UserLoginEntity findByEmail(String email){
        return find("email", email).firstResult();
    }

}
