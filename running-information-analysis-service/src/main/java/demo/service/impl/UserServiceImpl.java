package demo.service.impl;

import demo.domain.InformationRepository;
import demo.domain.RunningInformation;
import demo.domain.UserInfo;
import demo.domain.UserInfoRepository;
import demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vagrant on 6/11/17.
 */
@Service
public class UserServiceImpl implements UserService {
    private UserInfoRepository userInfoRepository;

    @Autowired
    public UserServiceImpl(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

}
