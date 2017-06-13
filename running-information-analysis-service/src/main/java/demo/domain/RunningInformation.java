package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Random;

/**
 * Created by vagrant on 6/9/17.
 */
//@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Data
@Table(name = "RUNNING_ANALYSIS")
public class RunningInformation implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String runningId;

//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "userid", column = @Column(name = "user_id")),
//            @AttributeOverride(name = "username", column = @Column(name = "user_name")),
//            @AttributeOverride(name = "address", column = @Column(name = "address"))
//    })
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "user_id"),
            @JoinColumn(name = "user_name"),
            @JoinColumn(name = "user_address")
    })
    //@JoinColumn(name = "user_id")
    private UserInfo userInfo;

    private double latitude;
    private double longitude;
    private double runningDistance;
    private double totalRunningTime;
    private int heartRate = 0;
    private Date timestamp = new Date();

    public enum HealthWarningLevel {
        LOW, NORMAL, HIGH
    }
    private HealthWarningLevel healthWarningLevel;

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
                              @JsonProperty("latitude") double latitude,
                              @JsonProperty("longitude") double longitude,
                              @JsonProperty("runningDistance") double runningDistance,
                              @JsonProperty("totalRunningTime") double totalRunningTime,
                              @JsonProperty("heartRate") int heartRate,
                              @JsonProperty("timestamp") Date timestamp,
                              //@JsonProperty("userId") Long userId,
                              @JsonProperty("userInfo") UserInfo userInfo,
                              HealthWarningLevel healthWarningLevel) {
        this.runningId = runningId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.runningDistance = runningDistance;
        this.totalRunningTime = totalRunningTime;
        this.heartRate = generateRandom(200, 60);
        this.timestamp = timestamp;
        //this.userInfo = new UserInfo(userId);
        this.userInfo = userInfo;
        this.healthWarningLevel = returnHealthWarningLevel(heartRate);
    }

    public Long getUserId() {
        return this.userInfo == null ? null : this.userInfo.getUserId();
    }

    public String getUserName() {
        return this.userInfo == null ? null : this.getUserName();
    }

    public String getUserAdress() {
        return this.userInfo == null ? null : this.getUserAdress();
    }

    public static int generateRandom(int max, int min) {
        Random rand = new Random();
        return rand.nextInt(max) % (max - min + 1) + min;

    }

    public static HealthWarningLevel returnHealthWarningLevel(int heartRate) {
        if (heartRate >= 60 && heartRate <= 75) {
            return HealthWarningLevel.LOW;
        }
        else if (heartRate > 75 && heartRate <= 120) {
            return HealthWarningLevel.NORMAL;
        }
        else {
            return HealthWarningLevel.HIGH;
        }
    }

}
