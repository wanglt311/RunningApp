package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Random;

/**
 * Created by vagrant on 6/13/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Data
@Table(name = "RUNNING_ANALYSIS")
public class RunningInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String runningId;

    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "userid", column = @Column(name = "user_id")),
//            @AttributeOverride(name = "username", column = @Column(name = "user_name")),
//            @AttributeOverride(name = "address", column = @Column(name = "address"))
//    })
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
    public RunningInfo() {
        this.userInfo = null;
    }
    public RunningInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    //used for constructors or static factory methods to construct
    //instances from Json
    //@JsonProperty annotation is used to bind data by a given name
    @JsonCreator
    public RunningInfo(@JsonProperty("runningId") String runningId,
                       @JsonProperty("latitude") String latitude,
                       @JsonProperty("longitude") String longitude,
                       @JsonProperty("runningDistance") String runningDistance,
                       @JsonProperty("totalRunningTime") String totalRunningTime,
                       @JsonProperty("heartRate") String heartRate,
                       @JsonProperty("timestamp") String timestamp,
                       //@JsonProperty("userId") Long userId,
                       @JsonProperty("userInfo") UserInfo userInfo,
                       HealthWarningLevel healthWarningLevel) {
        this.runningId = runningId;
        this.latitude = Double.parseDouble(latitude);
        this.longitude = Double.parseDouble(longitude);
        this.runningDistance = Double.parseDouble(runningDistance);
        this.totalRunningTime = Double.parseDouble(totalRunningTime);
        this.heartRate = generateRandom(200, 60);
        this.timestamp = new Date();
        //this.userInfo = new UserInfo(userId);
        this.userInfo = userInfo;
        this.healthWarningLevel = returnHealthWarningLevel(Integer.parseInt(heartRate));
    }

    public Long getUserId() {
        return this.userInfo == null ? null : this.userInfo.getUserId();
    }

    public String getUserName() {
        return this.userInfo == null ? null : this.userInfo.getUserName();
    }

    public String getAddress() {
        return this.userInfo == null ? null : this.userInfo.getAddress();
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
