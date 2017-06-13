package demo.domain;

/**
 * Created by vagrant on 6/12/17.
 */
public interface DisplayedRunningInfo {
    String getRunningiD();
    String getTotalRunningTime();
    int getHeartRate();
    String getUuserId();
    String getUserName();
    String getAddress();
    RunningInformation.HealthWarningLevel getHealthWarningLevel();
}
