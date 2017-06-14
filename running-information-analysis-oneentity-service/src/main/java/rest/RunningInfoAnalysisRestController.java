package rest;

import domain.RunningInfo;
import domain.RunningInfoRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.RunningInfoService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vagrant on 6/14/17.
 */
@RestController
public class RunningInfoAnalysisRestController {
    @Autowired
    private RunningInfoService runningInfoService;

    @Autowired
    public RunningInfoAnalysisRestController(RunningInfoService runningInfoService) {
        this.runningInfoService = runningInfoService;
    }

    @RequestMapping(value = "/runningInfos", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<RunningInfo> runningInfoList) {
        this.runningInfoService.saveRunningInfo(runningInfoList);
    }

    @RequestMapping(value = "/runningInfos", method = RequestMethod.DELETE)
    public void purge() {
        this.runningInfoService.deleteAll();
    }

    @RequestMapping(value = "/runningInfos/{runningId}", method = RequestMethod.DELETE)
    public void deleteByRunningId(@PathVariable("runningId") String runningId) {
        runningInfoService.deleteByRunningId(runningId);
    }

    @RequestMapping(value = "/runningInfos", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<List<JSONObject>> findAll(@RequestParam(name = "page") int page,
                                             @RequestParam(name = "size", defaultValue = "2") int size) {
        //Sort sort = new Sort(Sort.Direction.DESC, "healthWarningLevel");
        Page<RunningInfo> resultPages = runningInfoService.findAll(new PageRequest(page, 2));
        List<RunningInfo> list = resultPages.getContent();
        List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
        for (RunningInfo item : list) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("runningId", item.getRunningId());
            jsonObject.put("totalRunningTime", item.getTotalRunningTime());
            jsonObject.put("heartRate", item.getHeartRate());
            jsonObject.put("userId", item.getUserId());
            jsonObject.put("userName", item.getUserName());
            jsonObject.put("userAddress", item.getAddress());
            jsonObject.put("healthWarningLevel", item.getHealthWarningLevel());
            jsonObjects.add(jsonObject);
        }
        return new ResponseEntity<List<JSONObject>>(jsonObjects, HttpStatus.OK);
    }

    @RequestMapping(value = "/runningInfos/sortedWithHealthWarningLevel", method = RequestMethod.GET)
    public Page<RunningInfo> findAllInfo(@RequestParam(name = "page") int page,
                                         @RequestParam(name = "size", defaultValue = "2") int size) {
        Sort sort = new Sort(Sort.Direction.DESC, "healthWarningLevel");
        return runningInfoService.findAll(new PageRequest(page, 2, sort));
    }

    @RequestMapping(value = "/runningInfos/{runningId}", method = RequestMethod.GET)
    public Page<RunningInfo> findByRunningId(@PathVariable("runningId") String runningId,
                                             @RequestParam(name = "page") int page,
                                             @RequestParam(name = "size") int size) {
        return runningInfoService.findByRunningId(runningId, new PageRequest(page, size));
    }

}
