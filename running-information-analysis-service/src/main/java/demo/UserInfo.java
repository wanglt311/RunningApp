package demo;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by vagrant on 6/9/17.
 */
@Entity
@Data
@Embeddable
@Table(name = "USERS")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long userId;
    private String userName;
    private String address;

    public UserInfo() {
        this.userId = null;
    }

    public UserInfo(Long userId) {

        this.userId = userId;
    }

    public UserInfo(Long userId, String userName, String address) {
        this.userId = userId;
        this.userName = userName;
        this.address = address;
    }
}
