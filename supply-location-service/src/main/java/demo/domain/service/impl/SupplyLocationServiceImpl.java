package demo.domain.service.impl;

import demo.domain.domain.SupplyLocation;
import demo.domain.domain.SupplyLocationRepository;
import demo.domain.service.SupplyLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vagrant on 6/9/17.
 */
@Service
public class SupplyLocationServiceImpl implements SupplyLocationService {
    private SupplyLocationRepository repository;

    @Autowired
    public SupplyLocationServiceImpl(SupplyLocationRepository repository) {
        this.repository = repository;
    }
    @Override
    public List<SupplyLocation> saveSupplyLocationZipContains504(List<SupplyLocation> locations) {
        List<SupplyLocation> result = new ArrayList<>();
        for (SupplyLocation supplyLocation: locations) {
            if (supplyLocation.getZip().contains("504")) {
                result.add(supplyLocation);
            }
        }
        return null;
        //return repository.save(result);

    }
}
