package demo.rest;

import demo.domain.RunningInformation;
import demo.domain.UserInfo;
import demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by vagrant on 6/11/17.
 */
@RestController
public class UserInfoUploadRestController {
    private UserService userService;

    @Autowired
    public UserInfoUploadRestController(UserService userService) {
        this.userService = userService;
    }

//    @RequestMapping(value = "/userinformations", method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.CREATED)
//    public void upload(@RequestBody List<UserInfo> userInfos) {
//        this.userService.saveUserInfo(userInfos);
//    }

}
