package com.springdesk.springdesk.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {

    public static String encoder(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}
