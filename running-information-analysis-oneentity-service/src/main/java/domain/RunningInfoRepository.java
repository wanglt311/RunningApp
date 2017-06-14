package domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by vagrant on 6/13/17.
 */
@RepositoryRestResource(path = "RUNNING_ANALYSIS")
public interface RunningInfoRepository extends JpaRepository<RunningInfo, Long> {
    @RestResource(path = "informations")
    Page<RunningInfo> findAll(Pageable pageable);

    void deleteByRunningId(@Param("runningId") String runningId);

    @RestResource(path = "runningId")
    Page<RunningInfo> findByRunningId(@Param("runningId") String runningId, Pageable pageable);

    @RestResource(path = "runningIdNoPage")
    List<RunningInfo> findByRunningId(@Param("runningId") String runningId);

}
