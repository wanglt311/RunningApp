package com.liting.cs504.runninginformationanalysistwoservice.service;

import com.liting.cs504.runninginformationanalysistwoservice.domain.UserInfo;
import org.apache.catalina.User;

/**
 * Created by vagrant on 6/17/17.
 */
public interface UserInfoService {
    UserInfo save(UserInfo userInfo);
}
