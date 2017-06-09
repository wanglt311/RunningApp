package demo.domain.service;

import demo.domain.domain.SupplyLocation;

import java.util.List;

/**
 * Created by vagrant on 6/9/17.
 */
public interface SupplyLocationService {
    List<SupplyLocation> saveSupplyLocationZipContains504(List<SupplyLocation> location);
}
