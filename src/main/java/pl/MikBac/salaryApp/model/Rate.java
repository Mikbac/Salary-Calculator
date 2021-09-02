package pl.MikBac.salaryApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by MikBac on 2018
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Rate {

    private BigDecimal mid;

}
