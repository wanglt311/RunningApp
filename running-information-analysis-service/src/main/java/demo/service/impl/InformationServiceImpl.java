package demo.service.impl;

import demo.domain.InformationRepository;
import demo.domain.RunningInformation;
import demo.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vagrant on 6/10/17.
 */
@Service
public class InformationServiceImpl implements InformationService {
    private InformationRepository informationRepository;

    @Autowired
    public InformationServiceImpl(InformationRepository informationRepository) {
        this.informationRepository = informationRepository;
    }
    @Override
    public List<RunningInformation> saveRunningInformation(List<RunningInformation> runningInformations) {
        return informationRepository.save(runningInformations);
    }

    @Override
    public void deleteAll() {
        informationRepository.deleteAll();
    }

    @Override
    public void deleteByRunningId(String runningId) {
        List<RunningInformation> runningInformationList = new ArrayList<RunningInformation>();
        runningInformationList = findByRunningId(runningId);
        for (RunningInformation withRunningId : runningInformationList) {
            informationRepository.delete(withRunningId);
        }
    }

    @Override
    public Page<RunningInformation> findAll(Pageable pageable) {
        return informationRepository.findAll(pageable);
    }

    @Override
    public Page<RunningInformation> findByHealthWarningLevel(String healthWarningLevel, Pageable pageable) {
        return informationRepository.findByHealthWarningLevel(RunningInformation.HealthWarningLevel.valueOf(healthWarningLevel), pageable);
    }

    @Override
    public List<RunningInformation> findByRunningId(String runningId) {
        return informationRepository.findByRunningId(runningId);
    }
}
