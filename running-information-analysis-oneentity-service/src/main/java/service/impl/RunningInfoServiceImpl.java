package service.impl;

import domain.RunningInfo;
import domain.RunningInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import service.RunningInfoService;

import java.util.List;

/**
 * Created by vagrant on 6/13/17.
 */
@Service
public class RunningInfoServiceImpl implements RunningInfoService{
    @Autowired
    private RunningInfoRepository runningInfoRepository;

    @Autowired
    public RunningInfoServiceImpl(RunningInfoRepository runningInfoRepository) {
        this.runningInfoRepository = runningInfoRepository;
    }
    @Override
    public List<RunningInfo> saveRunningInfo(List<RunningInfo> runningInfos) {
        return runningInfoRepository.save(runningInfos);
    }

    @Override
    public void deleteAll() {
        runningInfoRepository.deleteAll();
    }

    @Override
    public void deleteByRunningId(String runningId) {
        List<RunningInfo> runningInfos = runningInfoRepository.findByRunningId(runningId);
        for (RunningInfo runningInfo : runningInfos) {
            runningInfoRepository.delete(runningInfo);
        }
    }

    @Override
    public Page<RunningInfo> findAll(Pageable pageable) {
        return runningInfoRepository.findAll(pageable);
    }

    @Override
    public Page<RunningInfo> findByRunningId(String runningId, Pageable pageable) {
        return runningInfoRepository.findByRunningId(runningId, pageable);
    }

}
