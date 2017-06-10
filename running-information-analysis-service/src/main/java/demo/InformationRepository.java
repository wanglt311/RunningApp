package demo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by vagrant on 6/10/17.
 */
public interface InformationRepository extends JpaRepository<RunningInformation, Long>{
    
}
