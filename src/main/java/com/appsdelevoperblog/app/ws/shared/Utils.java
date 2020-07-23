package com.appsdelevoperblog.app.ws.shared;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

@Component
public class Utils {
    private final Random Random = new SecureRandom();
    private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqustuvwxyz";
    public String generateUserId(int length){
    return generateRandwomString(length);
    }

    private String generateRandwomString(int length) {
        StringBuilder returnValue = new StringBuilder();

        for (int i = 0; i < length; i++) {
            returnValue.append(ALPHABET.charAt(Random.nextInt(ALPHABET.length())));
        }
        return new String(returnValue);
    }
}
