package com.liting.cs504.runninginformationanalysistwoservice.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by vagrant on 6/17/17.
 */
public interface RunningInformationRepository extends JpaRepository<RunningInformation, Long> {
    //which func to use?
    //where to sort? in spring data jpa
    List<RunningInformation> findByOrOrderByHeartRateDesc();
}
