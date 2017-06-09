package com.liting.cs504.userservice;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by vagrant on 6/9/17.
 */
@Entity
@Data
public class UserEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String name;

    public UserEntity() {

    }

    public UserEntity(String username, String name) {
        this.username = username;
        this.name = name;
    }
}