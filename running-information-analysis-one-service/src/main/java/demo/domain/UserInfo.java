package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by vagrant on 6/13/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Embeddable
public class UserInfo {
    //private Long userId;
    private String username;
    private String address;

    public UserInfo() {

    }
//
//    public UserInfo(Long userId) {
//
//        this.userId = userId;
//    }

//    public UserInfo(Long userId, String userName, String address) {
//        this.userId = userId;
//        this.userName = userName;
//        this.address = address;
//    }

    @JsonCreator
    public UserInfo(@JsonProperty("username") String username,
                    @JsonProperty("address") String address) {
        this.username = username;
        this.address = address;
    }
}
