package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.model.User;
import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping(value = "")
    public String printWelcome(ModelMap model, Principal principal) {
        User user = userDao.findByName(principal.getName());
        model.addAttribute("messages", user);
        return "user/user";
    }
}


