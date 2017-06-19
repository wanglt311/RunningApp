package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Random;

/**
 * Created by vagrant on 6/9/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Data
@Table(name = "RUNNING_ANALYSIS")
public class RunningInformation {

    @Id
    @GeneratedValue
    private Long id;

    private String runningId;

//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "userid", column = @Column(name = "user_id")),
//            @AttributeOverride(name = "username", column = @Column(name = "user_name")),
//            @AttributeOverride(name = "address", column = @Column(name = "address"))
//    })
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "user_id")
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
    public RunningInformation(String username, String address) {
        this.userInfo = new UserInfo(username, address);
    }

    //used for constructors or static factory methods to construct
    //instances from Json
    //@JsonProperty annotation is used to bind data by a given name
    @JsonCreator
    public RunningInformation(@JsonProperty("runningId") String runningId,
                              @JsonProperty("latitude") String latitude,
                              @JsonProperty("longitude") String longitude,
                              @JsonProperty("runningDistance") String runningDistance,
                              @JsonProperty("totalRunningTime") String totalRunningTime,
                              @JsonProperty("heartRate") String heartRate,
                              @JsonProperty("timestamp") String timestamp,
                              //@JsonProperty("userId") Long userId,
                              @JsonProperty("userInfo") UserInfo userInfo) {
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
        return this.userInfo == null ? null : this.userInfo.getUsername();
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
