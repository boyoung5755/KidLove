package com.KidLove.comm.utils;

import java.security.SecureRandom;

import org.springframework.stereotype.Component;

@Component
public class RandomStringGenerator {
	
	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int LENGTH = 10;
    private static final SecureRandom RANDOM = new SecureRandom();

    public static void main(String[] args) {
        String randomString = generateRandomString(LENGTH);
        System.out.println(randomString);
    }

    public static String generateRandomString(int length) {
        StringBuilder result = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = RANDOM.nextInt(CHARACTERS.length());
            result.append(CHARACTERS.charAt(index));
        }
        return result.toString();
    }

}
