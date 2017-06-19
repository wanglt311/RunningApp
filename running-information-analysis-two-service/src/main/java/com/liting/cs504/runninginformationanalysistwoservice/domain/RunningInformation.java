package com.liting.cs504.runninginformationanalysistwoservice.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.apache.catalina.User;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by vagrant on 6/17/17.
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

    private double longitude;
    private double latitude;
    private double runningDistance;
    private double totalRunningTime;
    private int heartRate;
    private Date timestamp = new Date();

    //table column mapping to userInfo object
    //@Embedded
    //targetEntity-->which is one
    //cascade:when upload RunningInformation, also upload UserInfo
    @ManyToOne(targetEntity = UserInfo.class, cascade = CascadeType.ALL)
    private UserInfo userInfo;

    @JsonCreator
    public RunningInformation(@JsonProperty("userInfo") UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public RunningInformation() {
        this.userInfo = new UserInfo();
    }

    public RunningInformation(String username, String address) {
        this.userInfo = new UserInfo(username, address);
    }
}
