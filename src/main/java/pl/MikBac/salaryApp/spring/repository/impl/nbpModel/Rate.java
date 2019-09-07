/**
 * Created by MikBac on 2018
 */

package pl.MikBac.salaryApp.spring.repository.impl.nbpModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Rate {

    private BigDecimal mid;

}
