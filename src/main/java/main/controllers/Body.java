package main.controllers;

import main.entities.User;
import main.service.GenericDao;
import main.service.Service1;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Controller
@Transactional
public class Body {

    @Autowired
    private Service1 service1;

    private GenericDao genericDao;

    @RequestMapping(value = "/login", params = { "username", "password" })
    @ResponseBody
    Map<String, Object> login(
            @RequestParam("username") String username,
            @RequestParam("password") String password) throws Exception {
        Map<String, Object> authInfo = new HashMap<>();
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        service1.save(user);

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

    @Autowired
    public void setGenericDao(GenericDao dao) {
        this.genericDao = dao;
    }

}
