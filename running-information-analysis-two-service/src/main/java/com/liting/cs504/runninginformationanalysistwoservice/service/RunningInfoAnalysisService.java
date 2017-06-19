package com.liting.cs504.runninginformationanalysistwoservice.service;

import com.liting.cs504.runninginformationanalysistwoservice.domain.RunningInformation;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by vagrant on 6/17/17.
 */
public interface RunningInfoAnalysisService {
    //save runningInfo
    List<RunningInformation> saveRunningInfo(List<RunningInformation> runningInfo);

    //do not have HealthLevel, need Dto-->data transfer object-->birdge between service and data access layercc
    List<RunningInfoDto> findByRunningInfoOrderByHealthLevel();
}
