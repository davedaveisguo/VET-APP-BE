package com.controller;

import com.model.ResponseTemplate;
import com.model.User;
import com.pojo.Userobj;
import com.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserDao userRepository;


    @RequestMapping(value = "/getalluser", method = RequestMethod.GET)
    public ResponseTemplate fetchAllUser(HttpServletRequest request) {

        ResponseTemplate ret = new ResponseTemplate();

        Iterable<User> users = userRepository.findAll();
        ret.setData(users);
        ret.setCode(HttpStatus.OK.value());
        ret.setMessage("find all succ");

        return ret;
    }

    @RequestMapping(value = "/getuserById", method = RequestMethod.GET)
    public ResponseTemplate fetchById(Userobj userobj) {

        ResponseTemplate ret = new ResponseTemplate();

        Optional<User> user= userRepository.findById(Long.parseLong(userobj.getId()));

        ret.setData(user);
        ret.setCode(HttpStatus.OK.value());
        ret.setMessage("find user by id succ");
        return ret;
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ResponseTemplate getUserConfig(String name, HttpServletRequest request) {

        ResponseTemplate ret = new ResponseTemplate();
        userRepository.deleteById(6L);
        ret.setCode(HttpStatus.OK.value());
        ret.setMessage("delete succ");

        return ret;
    }

}
