package com.controller;


import com.model.ResponseTemplate;
import com.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserDao userRepository;


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ResponseTemplate getUserConfig(String name, HttpServletRequest request) {

        ResponseTemplate ret = new ResponseTemplate();

        userRepository.deleteById(6L);
        ret.setCode(HttpStatus.OK.value());
        ret.setMessage("delete succ");

        return ret;
    }

}
