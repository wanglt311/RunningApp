package demo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Random;

/**
 * Created by vagrant on 6/9/17.
 */
//@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "RUNNING_ANALYSIS")
public class RunningInformation implements Serializable{

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String runningId;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "userid", column = @Column(name = "user_id")),
            @AttributeOverride(name = "username", column = @Column(name = "user_name")),
            @AttributeOverride(name = "address", column = @Column(name = "address"))
    })
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserInfo userInfo;

    private double latitude;
    private double longitude;
    private double runningDistance;
    private double totalRunningTime;
    private int heartRate = 0;
    private Date timestamp = new Date();

    //Entity class must have public or protected,
    //no-arg constructor
    public RunningInformation() {
        this.userInfo = null;
    }
    public RunningInformation(UserInfo userInfo) {

        this.userInfo = userInfo;
    }

    //used for constructors or static factory methods to construct
    //instances from Json
    //@JsonProperty annotation is used to bind data by a given name
    @JsonCreator
    public RunningInformation(@JsonProperty("runningId") String runningId,
                              @JsonProperty("totalRunningTime") double totalRunningTime,
                              //@JsonProperty("userId") Long userId,
                              @JsonProperty("userName") String userName,
                              @JsonProperty("userAddress") String userAddress) {
        this.runningId = runningId;
        this.totalRunningTime = totalRunningTime;
        this.heartRate = generateRandom();
        //this.userInfo = new UserInfo(userId);
        this.userInfo.setUserName(userName);
        this.userInfo.setAddress(userAddress);
    }

    public Long getUserId() {
        return this.userInfo == null ? null : this.userInfo.getUserId();
    }

    public static int generateRandom() {
        Random rand = new Random();
        return rand.nextInt(200) % (200 - 60 + 1) + 60;

    }

    public static String generateHealthWarningLevel(int heartRate) {
        if (heartRate >= 60 && heartRate <= 75) {
            return "LOW";
        }
        else if (heartRate > 75 && heartRate <= 120) {
            return "NORMAL";
        }
        else {
            return "HIGH";
        }
    }

//    @Override
//    public int hashCode() {
//        return ((this.getRunningId() == null
//                ? 0 : this.getRunningId().hashCode())
//                ^ (this.getHeartRate()));
//    }

//    @Override
//    public boolean equals
}
