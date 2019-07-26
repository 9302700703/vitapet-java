package main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class Body {

    @RequestMapping(value = "/login", params = { "username", "password" })
    @ResponseBody
    Map<String, Object> login(
            @RequestParam("username") String username,
            @RequestParam("password") String password) {
        Map<String, Object> authInfo = new HashMap<>();
        authInfo.put("username", username);
        authInfo.put("msg", "Авторизация выполнена успешно");
        if ("Настя".equals(username) && "brec".equals(password)) {
            authInfo.put("login", true);
            return authInfo;
        }
        if ("Vlad".equals(username) && "366566".equals(password)) {
            authInfo.put("login", true);
            return authInfo;
        }
        authInfo.put("login", false);
        authInfo.put("msg", "Имя пользователя и/или пароль не верны");
        return authInfo;
    }

}
