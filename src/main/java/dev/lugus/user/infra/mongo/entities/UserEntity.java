package dev.lugus.user.infra.mongo.entities;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

@MongoEntity(collection = "users")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserEntity {

    private ObjectId id;
    @BsonProperty("username")
    private String username;
    @BsonProperty("email")
    private String email;
    @BsonProperty("role")
    private String role;
    @BsonProperty("verified")
    private Boolean isVerified;

}
