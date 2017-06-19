package com.liting.cs504.runninginformationanalysistwoservice.service.impl;

import com.liting.cs504.runninginformationanalysistwoservice.domain.RunningInformation;
import com.liting.cs504.runninginformationanalysistwoservice.domain.RunningInformationRepository;
import com.liting.cs504.runninginformationanalysistwoservice.domain.UserInfo;
import com.liting.cs504.runninginformationanalysistwoservice.service.RunningInfoAnalysisService;
import com.liting.cs504.runninginformationanalysistwoservice.service.RunningInfoDto;
import com.liting.cs504.runninginformationanalysistwoservice.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * Created by vagrant on 6/17/17.
 */
@Service
public class RunningInfoAnalysisServiceImpl implements RunningInfoAnalysisService {
    @Autowired
    private RunningInformationRepository repository;
    @Autowired
    private UserInfoService userInfoService;

    ////////////////////////////////////////////////////
    @Override
    @Transactional//this is transactional method, if this fail, the first cannot succeed
    //muli entity, self control, remove cascade all, then write method to control by yourself
    public List<RunningInformation> saveRunningInfo(List<RunningInformation> runningInfo) {
        userInfoService.save(runningInfo.get(0).getUserInfo());//only one, save to entity manager session
        //second time save in database
        //best place to generate heartRate
        return repository.save(runningInfo.stream().map(temp -> {
            temp.setHeartRate(ThreadLocalRandom.current().nextInt(60, 201));
            return temp;
        }).collect(Collectors.toList()));
        //save iterable object, transfer to a list
    }
    ////////////////////////////////////////////////////
    //cascade all will garantee

    @Override
    public List<RunningInfoDto> findByRunningInfoOrderByHealthLevel() {
        return convertToRunningInfoDtoList(repository.findByOrOrderByHeartRateDesc());
    }

    private List<RunningInfoDto> convertToRunningInfoDtoList(List<RunningInformation> runningInformationList) {
        return runningInformationList.stream().map(RunningInfoDto::new).collect(Collectors.toList());
    }
}


