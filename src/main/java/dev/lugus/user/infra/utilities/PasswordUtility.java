package dev.lugus.user.infra.utilities;

import io.quarkus.elytron.security.common.BcryptUtil;

public class PasswordUtility {

    private PasswordUtility(){}


    public static String getHashed(String plainTextPassword) {
        return BcryptUtil.bcryptHash(plainTextPassword);
    }

    public static Boolean verifyPassword(String plainTextPassword, String hashedPassword) {
        return BcryptUtil.matches(plainTextPassword, hashedPassword);
    }

}
