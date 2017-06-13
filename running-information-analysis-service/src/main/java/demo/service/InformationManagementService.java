package demo.service;

import demo.domain.RunningInformation;
import demo.domain.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by vagrant on 6/10/17.
 */
public interface InformationManagementService {
    List<RunningInformation> saveRunningInformation(List<RunningInformation> runningInformations);

    List<UserInfo> saveUserInfo(List<UserInfo> userInfos);

    void deleteAll();

    void deleteByRunningId(String runningId);

    Page<RunningInformation> findAll(Pageable pageable);

    //Page<RunningInformation> findByHealthWarningLevel(String healthWarningLevel, Pageable pageable);

    List<RunningInformation> findByRunningId(String runningId);
}
