package com.liting.cs504.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by vagrant on 6/9/17.
 */
@RestController
public class UserRestController {

    @Autowired
    private UserEntityRepository repository;

    @RequestMapping(value = "/users/{username}", method = RequestMethod.GET)
    public UserEntity getUserByUsername(@PathVariable String username) {
        return repository.findByUsername(username);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public UserEntity createUser(@RequestBody UserEntity userEntity) {
        return this.repository.save(userEntity);
    }
}
