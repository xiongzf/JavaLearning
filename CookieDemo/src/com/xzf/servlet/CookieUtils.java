package com.xzf.servlet;

import javax.servlet.http.Cookie;

public class CookieUtils {
    public static Cookie findCookieValue(Cookie[] cookies, String name) {
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (name.equals(cookie.getName())) {
                    return cookie;
                }
            }
        }

        return null;
    }
}
