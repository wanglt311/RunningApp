package demo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by vagrant on 6/9/17.
 */
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Embeddable
@Table(name = "USERS")
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
}
