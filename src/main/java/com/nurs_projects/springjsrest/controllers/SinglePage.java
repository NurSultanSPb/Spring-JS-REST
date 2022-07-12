package com.nurs_projects.springjsrest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.nurs_projects.springjsrest.db.Util;
import com.nurs_projects.springjsrest.model.User;
import com.nurs_projects.springjsrest.services.RoleService;
import com.nurs_projects.springjsrest.services.UserService;

@Controller
@RequestMapping("/singlepage")
public class SinglePage {

    private final UserService userService;

    @Autowired
    public SinglePage(UserService userService, RoleService roleService, Util util) {
        this.userService = userService;
    }


    @GetMapping()
    public String getSinglePage(@AuthenticationPrincipal User authUser, Model model) {
        model.addAttribute("authUser", authUser);
        return "just-page";
    }
}
