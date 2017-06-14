package service;

import domain.RunningInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by vagrant on 6/13/17.
 */
public interface RunningInfoService {
    List<RunningInfo> saveRunningInfo(List<RunningInfo> runningInfos);

    void deleteAll();

    void deleteByRunningId(String runningId);

    Page<RunningInfo> findAll(Pageable pageable);

    Page<RunningInfo> findByRunningId(String runningId, Pageable pageable);
}
