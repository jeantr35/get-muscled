package dev.lugus.user.infra.mongo.entities;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

@MongoEntity(collection = "users_login")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserLoginEntity {

    private ObjectId id;
    @BsonProperty("email")
    private String email;
    @BsonProperty("password")
    private String hashedPassword;

}
