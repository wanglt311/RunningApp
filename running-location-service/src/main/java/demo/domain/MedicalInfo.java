package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Embeddable;

/**
 * Created by vagrant on 6/8/17.
 */
//for json data convert to medicalinfo object
@JsonInclude(JsonInclude.Include.NON_NULL)
@Embeddable
@Data
public class MedicalInfo {
    private Long bfr;
    private Long fmi;

    public MedicalInfo() {
    }

    public MedicalInfo(Long bfr, Long fmi) {
        this.bfr = bfr;
        this.fmi = fmi;
    }
}
