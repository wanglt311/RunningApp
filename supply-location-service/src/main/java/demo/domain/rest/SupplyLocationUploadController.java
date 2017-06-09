package demo.domain.rest;

import demo.domain.domain.SupplyLocation;
import demo.domain.domain.SupplyLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by vagrant on 6/9/17.
 */
@RestController
public class SupplyLocationUploadController {
    //dependency injection

    //constructor based injection
    private SupplyLocationRepository repository;

    @Autowired
    public SupplyLocationUploadController(SupplyLocationRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/bulk/supplyLocations", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<SupplyLocation> locations) {
        //success return 200ok
        //create success return 201created
        this.repository.save(locations);
    }
}
