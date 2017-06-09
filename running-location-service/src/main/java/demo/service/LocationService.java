package demo.service;

import demo.domain.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by vagrant on 6/8/17.
 */
//convenient to get and search user info
public interface LocationService {
    List<Location> saveRunningLocations(List<Location> runningLocations);

    void deleteAll();

    Page<Location> findByRunnerMovementType(String movementType, Pageable pageable);
    Page<Location> findByRunningId(String runningId, Pageable pageable);
}
