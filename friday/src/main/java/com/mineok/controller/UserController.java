package com.mineok.controller;

import com.mineok.base.PageTableRequest;
import com.mineok.base.Results;
import com.mineok.entities.SysUser;
import com.mineok.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{username}")
    @ResponseBody
    public SysUser user(@PathVariable String username) {
        log.info("UserController.user(): param ( username = " + username + " )");
        return userService.getUser(username);
    }

    @GetMapping("/list")
    @ResponseBody
    public Results<SysUser> getUsers(PageTableRequest page) {
        return userService.getAllUsersByPage(page.getOffset(), page.getLimit());
    }
}
