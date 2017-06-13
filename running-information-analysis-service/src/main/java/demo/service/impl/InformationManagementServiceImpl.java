package demo.service.impl;

import demo.domain.InformationRepository;
import demo.domain.RunningInformation;
import demo.domain.UserInfo;
import demo.domain.UserInfoRepository;
import demo.service.InformationManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vagrant on 6/10/17.
 */
@Service
@Transactional
public class InformationManagementServiceImpl implements InformationManagementService {
    @Autowired
    private InformationRepository informationRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    public InformationManagementServiceImpl(InformationRepository informationRepository, UserInfoRepository userInfoRepository) {
        this.informationRepository = informationRepository;
        this.userInfoRepository = userInfoRepository;
    }
    @Override
    public List<RunningInformation> saveRunningInformation(List<RunningInformation> runningInformations) {
        return informationRepository.save(runningInformations);
    }

    @Override
    public List<UserInfo> saveUserInfo(List<UserInfo> userInfos) {
        return userInfoRepository.save(userInfos);
    }

    @Override
    public void deleteAll() {
        informationRepository.deleteAll();
        userInfoRepository.deleteAll();
    }

    @Override
    public void deleteByRunningId(String runningId) {
        List<RunningInformation> runningInformationList = informationRepository.findByRunningId(runningId);
        for (RunningInformation withRunningId : runningInformationList) {
            informationRepository.delete(withRunningId);
        }
    }

    @Override
    public Page<RunningInformation> findAll(Pageable pageable) {
        return informationRepository.findAll(pageable);
    }

//    @Override
//    public Page<RunningInformation> findByHealthWarningLevel(String healthWarningLevel, Pageable pageable) {
//        return informationRepository.findByHealthWarningLevel(RunningInformation.HealthWarningLevel.valueOf(healthWarningLevel), pageable);
//    }

    @Override
    public List<RunningInformation> findByRunningId(String runningId) {
        return informationRepository.findByRunningId(runningId);
    }
}
