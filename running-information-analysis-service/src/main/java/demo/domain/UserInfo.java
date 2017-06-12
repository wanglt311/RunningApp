package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import demo.domain.RunningInformation;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by vagrant on 6/9/17.
 */
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
//@Embeddable
@Table(name = "USERS", uniqueConstraints = {
        @UniqueConstraint(columnNames = "user_id"),
        @UniqueConstraint(columnNames = "user_name"),
        @UniqueConstraint(columnNames = "user_address")
})
public class UserInfo {

    @Id
    @GeneratedValue
    private Long userId;
    private String userName;
    private String address;

    @OneToMany(mappedBy = "userInfo")
    private List<RunningInformation> runningInformations;

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

    @JsonCreator
    public UserInfo(@JsonProperty("username") String userName,
                    @JsonProperty("address") String address) {
        this.userName = userName;
        this.address = address;
    }
}
