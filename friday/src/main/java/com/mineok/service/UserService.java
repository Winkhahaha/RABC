package com.mineok.service;

import com.mineok.base.Results;
import com.mineok.dao.UserDao;
import com.mineok.entities.SysUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class UserService {

    @Resource
    private UserDao userDao;

    public SysUser getUser(String username) {
        return userDao.getUser(username);
    }

    public Results<SysUser> getAllUsersByPage(Integer offset, Integer limit) {
        return Results.success(userDao.countAllUsers(), userDao.getAllUsersByPage(offset, limit));
    }
}
