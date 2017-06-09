package demo.service.impl;

import demo.domain.Location;
import demo.domain.LocationRepository;
import demo.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vagrant on 6/8/17.
 */
//mark the bean
@Service
public class LocationServiceImpl implements LocationService {
    private LocationRepository locationRepository;

    @Autowired
    //spring help us inject locationRepository
    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> saveRunningLocations(List<Location> runningLocations) {
        //use jpaRepository save()
        return locationRepository.save(runningLocations);
    }

    @Override
    public void deleteAll() {
        locationRepository.deleteAll();
    }

    @Override
    public Page<Location> findByRunnerMovementType(String movementType, Pageable pageable) {
        return locationRepository.findByRunnerMovementType(Location.RunnerMovementType.valueOf(movementType), pageable);
    }

    @Override
    public Page<Location> findByRunningId(String runningId, Pageable pageable) {
        return locationRepository.findByUnitInfoRunningId(runningId, pageable);
    }


}
