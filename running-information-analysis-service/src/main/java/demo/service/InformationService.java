package demo.service;

import demo.domain.RunningInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by vagrant on 6/10/17.
 */
public interface InformationService {
    List<RunningInformation> saveRunningInformation(List<RunningInformation> runningInformations);

    void deleteAll();

    void deleteByRunningId(String runningId);

    Page<RunningInformation> findAll(Pageable pageable);

    Page<RunningInformation> findByHealthWarningLevel(String healthWarningLevel,
                                                      Pageable pageable);

    List<RunningInformation> findByRunningId(String runningId);
}
