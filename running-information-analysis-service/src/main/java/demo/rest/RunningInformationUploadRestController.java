package demo.rest;

import demo.domain.RunningInformation;
import demo.domain.UserInfo;
import demo.service.InformationManagementService;
import demo.service.UserService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vagrant on 6/10/17.
 */
@RestController
public class RunningInformationUploadRestController {
    private InformationManagementService informationManagementService;
    //private UserService userService;

    private String runningId = "runningId";
    private String totalRunningTime = "totalRunningTime";
    private String heartRate = "heartRate";
    private String userId = "userId";
    private String userName = "userName";
    private String userAddress = "userAddress";
    private String healthWarningLevel = "healthWarningLevel";

    @Autowired
    public RunningInformationUploadRestController(InformationManagementService informationManagementService) {
        this.informationManagementService = informationManagementService;
    }

//    @RequestMapping(value = "/userinformations", method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.CREATED)
//    public void upload(@RequestBody List<UserInfo> userInfos) {
//        this.informationManagementService.saveUserInfo(userInfos);
//    }


    @RequestMapping(value = "/runninginformations", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    //@RequestBody switch json data into Java class
    public void upload(@RequestBody List<RunningInformation> runningInformations,
                       @RequestBody List<UserInfo> userInfos) {
        this.informationManagementService.saveRunningInformation(runningInformations);
        this.informationManagementService.saveUserInfo(userInfos);
    }

    @RequestMapping(value = "/runninginformations", method = RequestMethod.DELETE)
    public void purge() {
        this.informationManagementService.deleteAll();
    }

    @RequestMapping(value = "/runninginformations/{runningId}", method = RequestMethod.DELETE)
    public void deleteByRunningId(@PathVariable("runningId") String runningId) {
        informationManagementService.deleteByRunningId(runningId);
    }

    @RequestMapping(value = "/runninginformations", method = RequestMethod.GET)
    public Page<RunningInformation> findByHealthWarningLevel(@RequestParam(name = "page") int page,
                                                             @RequestParam(name = "size", defaultValue = "2") int size) {
        Sort sort = new Sort(Sort.Direction.DESC, "healthWarningLevel");
        return informationManagementService.findAll(new PageRequest(page, 2, sort));
    }

    @RequestMapping(value = "runninginformations/returnSpecificFormat", method = RequestMethod.GET)
    //get entity in Json
    public @ResponseBody
    ResponseEntity<List<JSONObject>> findAll(@RequestParam(name = "page") int page,
                                             @RequestParam(name = "size", defaultValue = "2") int size) {
        Sort sort = new Sort(Sort.Direction.DESC, "healthWarningLevel");
        Page<RunningInformation> resultsPages = informationManagementService.findAll(new PageRequest(page, 2, sort));
        List<RunningInformation> list = resultsPages.getContent();
        List<JSONObject> results = new ArrayList<JSONObject>();
        for (RunningInformation i : list) {
            JSONObject userInfo = new JSONObject();
            userInfo.put(runningId, i.getRunningId());
            userInfo.put(totalRunningTime, i.getTotalRunningTime());
            userInfo.put(heartRate, i.getHeartRate());
            userInfo.put(userId, i.getUserId());
            userInfo.put(userName, i.getUserName());
            userInfo.put(userAddress, i.getAddress());
            userInfo.put(healthWarningLevel, i.getHealthWarningLevel());
            results.add(userInfo);
        }
        return new ResponseEntity<List<JSONObject>>(results, HttpStatus.OK);
    }



    //test method
//    @RequestMapping("/greet")
//    public String sayHello(@RequestParam("name") String name) {
//        if (name == null || name.isEmpty()) {
//            throw new IllegalArgumentException("The 'name' parameter must not be null or empty");
//        }
//        return String.format("Hello %s!", name);
//    }
}
