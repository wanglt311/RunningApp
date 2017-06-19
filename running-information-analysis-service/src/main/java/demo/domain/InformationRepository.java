package demo.domain;

import demo.domain.RunningInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by vagrant on 6/10/17.
 */
@RepositoryRestResource(path = "RUNNING_ANALYSIS")
public interface InformationRepository extends JpaRepository<RunningInformation, Long>{

    //@RestResource(path = "informations")
    Page<RunningInformation> findAll(Pageable pageable);

//    @RestResource(path = "healthWarningLevels")
//    Page<RunningInformation> findByHealthWarningLevel(@Param("healthWarningLevel") RunningInformation.HealthWarningLevel healthWarningLevel,
//                                                      Pageable pageable);

    void deleteByRunningId(@Param("runningId") String runningId);

    //@RestResource(path = "runningId")
    List<RunningInformation> findByRunningId(@Param("runningId") String runningId);
}
