package demo.service;

import demo.domain.RunningInformation;
import demo.domain.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by vagrant on 6/11/17.
 */
public interface UserService {
    List<UserInfo> saveUserInfo(List<UserInfo> userInfos);

//    void deleteAll();
//
//    void deleteByUserId(Long userId);
//
//    Page<UserInfo> findAll(Pageable pageable);
//
//    List<UserInfo> findByUserId(Long userId);
}
