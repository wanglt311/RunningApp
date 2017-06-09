package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by vagrant on 6/8/17.
 */
//map into database --> jpa
@Entity
@Table(name = "LOCATIONS")
public class Location {
    enum GpsStatus {
        EXCELLENT, OK, UNRELIABLE, BAD, NOFIX, UNKNOWN
    }

    public enum RunnerMovementType {
        STOPPED, IN_MOTTION;

        public boolean isMoving() {
            return this != STOPPED;
        }
    }

    @Id
    @GeneratedValue
    private Long id;

    private double latitude;
    private double longitude;
    private String heading;
    private double gpsSpeed;
    private GpsStatus gpsStatus;
    private double odometer;
    private double totalRunningTime;
    private double totalIdleTime;
    private double totalCalorieBurnt;
    private String address;
    private Date timestamp = new Date();
    private String gearProvider;
    private RunnerMovementType runnerMovementType = RunnerMovementType.STOPPED;
    private String serviceType;

    //class relation
    //composition
    //uniInfo multi field, cannot map in one single col
    //Embedded compose attribute into uniInfo class
    @Embedded
    @AttributeOverride(name = "bandMake", column = @Column(name = "unit_band_make"))
    private UnitInfo unitInfo;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "fmi", column = @Column(name = "medical_fmi")),
            @AttributeOverride(name = "bfr", column = @Column(name = "medical_bfr"))
    })
    private MedicalInfo medicalInfo;

    public Location() {

    }

    public Location(UnitInfo unitInfo) {
        this.unitInfo = unitInfo;
    }

    @JsonCreator
    public Location(@JsonProperty("runningId") String runningId) {
        this.unitInfo = new UnitInfo(runningId);
    }

    public String getRunningId() {
        return this.unitInfo == null ? null : this.unitInfo.getRunningId();
    }

}
