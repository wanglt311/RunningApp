package com.liting.cs504.runninginformationanalysistwoservice.rest;

import com.liting.cs504.runninginformationanalysistwoservice.domain.RunningInformation;
import com.liting.cs504.runninginformationanalysistwoservice.service.RunningInfoAnalysisService;
import com.liting.cs504.runninginformationanalysistwoservice.service.RunningInfoDto;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by vagrant on 6/17/17.
 */
@RestController
public class RunningInfoAnalysisRestController {

    //business logic in service, not in controller
    @Autowired
    private RunningInfoAnalysisService analysisService;

    @RequestMapping(value = "/runningInfo", method = RequestMethod.GET)
    public List<RunningInfoDto> getRunningInfo() {
        return analysisService.findByRunningInfoOrderByHealthLevel();
    }

    @RequestMapping(value = "/runningInfo", method = RequestMethod.POST)
    public List<RunningInformation> persistRunningInfo(@RequestBody List<RunningInformation> runningInformation) {
        return analysisService.saveRunningInfo(runningInformation);
    }
}
