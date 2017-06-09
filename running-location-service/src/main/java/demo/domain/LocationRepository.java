package demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by vagrant on 6/8/17.
 */
public interface LocationRepository extends JpaRepository<Location, Long>{
    //pagination data
    //pageable:from where to get data
    //RunningMovementType map to Location field
    //select * from LOCATIONS where runnerMovementType = :movementType
    //Pageable pageable tell data which page to seize data, and how many each page
    //this is a query with pagination
    Page<Location> findByRunnerMovementType(@Param("movementType") Location.RunnerMovementType movementType,
                                            Pageable pageable);

    Page<Location> findByRunningId(@Param("runningId") String runningId,
                                   Pageable pageable);
}
