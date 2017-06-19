package com.liting.cs504.runninginformationanalysistwoservice.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by vagrant on 6/17/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Data
public class UserInfo {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String address;

    public UserInfo() {

    }

    //means when doing Json serialization, deserialization, this constructor will be used
    //@JsonProperty()-->in Json string, what is the property
    @JsonCreator
    public UserInfo(@JsonProperty("username") String username,
                    @JsonProperty("address") String address) {
        this.username = username;
        this.address = address;
    }
}
