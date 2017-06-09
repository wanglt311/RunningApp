package demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by vagrant on 6/8/17.
 */
//REST API ross.com/locations?movementType=STOPPED&page=10&size=10
@RepositoryRestResource(path = "locations")
public interface LocationRepository extends JpaRepository<Location, Long>{
    //pagination data
    //pageable:from where to get data
    //RunningMovementType map to Location field
    //select * from LOCATIONS where runnerMovementType = :movementType
    //Pageable pageable tell data which page to seize data, and how many each page
    //this is a query with pagination
    @RestResource(path = "runners")
    Page<Location> findByRunnerMovementType(@Param("movementType") Location.RunnerMovementType movementType,
                                            Pageable pageable);

    @RestResource(path = "runningids")
    Page<Location> findByUnitInfoRunningId(@Param("runningId") String runningId,
                                   Pageable pageable);

    //we want to use the customerName in UnitInfo to get all the Locations
    //localhost:8080/locations/search/customers?customerName=ross
    @RestResource(path = "customers")
    Page<Location> findByUnitInfoCustomerName(@Param("customerName") String customerName,
                                              Pageable pageable);
}
