package demo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by vagrant on 6/9/17.
 */
@Entity
@Data
@Table(name = "RUNNING_ANALYSIS")
public class RunningInformation implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long runningId;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "username", column = @Column(name = "user_name")),
            @AttributeOverride(name = "address", column = @Column(name = "address"))
    })
    @OneToOne
    private final UserInfo userInfo;

    private double latitude;
    private double longitude;
    private double runningDistance;
    private double totalRunningTime;
    private Integer heartRate = 0;
    private Date timestamp = new Date();

    //Entity class must have public or protected,
    //no-arg constructor
    public RunningInformation() {
        this.userInfo = null;
    }
    public RunningInformation(UserInfo userInfo) {

        this.userInfo = userInfo;
    }

    //???????????
    @JsonCreator
    public RunningInformation(@JsonProperty("runningId") Long runningId,
                              @JsonProperty("userId") Long userId) {
        this.runningId = runningId;
        this.userInfo = new UserInfo(userId);
    }


    @Override
    public int hashCode() {
        return ((this.getRunningId() == null
                ? 0 : this.getRunningId().hashCode())
                ^ (this.getHeartRate()));
    }

//    @Override
//    public boolean equals
}
