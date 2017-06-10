package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vagrant on 6/10/17.
 */
@Service
public class InformationServiceImpl implements InformationService{
    private InformationRepository informationRepository;

    @Autowired
    public InformationServiceImpl(InformationRepository informationRepository) {
        this.informationRepository = informationRepository;
    }
    @Override
    public List<RunningInformation> saveRunningInformations(List<RunningInformation> runningInformations) {
        return informationRepository.save(runningInformations);
    }
}
