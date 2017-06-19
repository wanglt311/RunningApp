package com.liting.cs504.runninginformationanalysistwoservice.service;

import com.liting.cs504.runninginformationanalysistwoservice.domain.RunningInformation;
import lombok.Data;

/**
 * Created by vagrant on 6/17/17.
 */
//data structure in database is not like what the format we really want, so
    //use this class as a bridge
@Data
public class RunningInfoDto {
    public enum HealthWarningLevel {
        NA, LOW, NORMAL,HIGH
    }
    private String runningId;
    private double runningDistance;
    private double totalRunningTime;

    private int heartRate;
    private Long userId;
    private String username;
    private String address;
    private HealthWarningLevel healthWarningLevel;

    public RunningInfoDto() {

    }

    //use RunningInfo to build a RunningInfoDto
    public RunningInfoDto(RunningInformation runningInfo) {
        this.setRunningId(runningInfo.getRunningId());
        this.setRunningDistance(runningInfo.getRunningDistance());
        this.setTotalRunningTime(runningInfo.getTotalRunningTime());
        this.setHeartRate(runningInfo.getHeartRate());
        this.setUserId(runningInfo.getUserInfo().getId());
        this.setUsername(runningInfo.getUserInfo().getUsername());
        this.setAddress(runningInfo.getUserInfo().getAddress());
        this.setHealthWarningLevel(convertWarningLevel(heartRate));
    }

    private HealthWarningLevel convertWarningLevel(int heartRate) {
        if (heartRate >= 60 && heartRate <= 75) {
            return HealthWarningLevel.LOW;
        }
        else if (heartRate > 75 && heartRate <= 120) {
            return HealthWarningLevel.NORMAL;
        }
        else if (heartRate > 120) {
            return HealthWarningLevel.HIGH;
        }
        else {
            return HealthWarningLevel.NA;
        }
    }
}
