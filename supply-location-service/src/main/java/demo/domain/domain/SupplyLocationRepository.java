package demo.domain.domain;

import demo.domain.domain.SupplyLocation;
import org.springframework.data.geo.Point;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by vagrant on 6/9/17.
 */
//root path
@RepositoryRestResource(path = "supplyLocations")
public interface SupplyLocationRepository extends PagingAndSortingRepository<SupplyLocation, Long>{

    @RestResource(rel = "by-locations")
    //did not add path, use method name as part of URL path
    SupplyLocation findFirstByLocationNear(@Param("location") Point location);

}
