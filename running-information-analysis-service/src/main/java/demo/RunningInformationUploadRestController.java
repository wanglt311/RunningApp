package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by vagrant on 6/10/17.
 */
@RestController
public class RunningInformationUploadRestController {
    private InformationService informationService;

    @Autowired
    public RunningInformationUploadRestController(InformationService informationService) {
        this.informationService = informationService;
    }

    @RequestMapping(value = "/runninginformations", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<RunningInformation> runningInformations) {
        this.informationService.saveRunningInformations(runningInformations);
    }
}
