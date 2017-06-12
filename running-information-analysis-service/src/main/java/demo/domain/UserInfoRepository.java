package demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by vagrant on 6/11/17.
 */
@RepositoryRestResource(path = "USERS")
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    @RestResource(path = "users")
    Page<UserInfo> findAll(Pageable pageable);

    @RestResource(path = "userId")
    Page<UserInfo> findByUserId(@Param("userId") Long userId,
                                                      Pageable pageable);

    void deleteByUserId(@Param("userId") Long userId);

}
