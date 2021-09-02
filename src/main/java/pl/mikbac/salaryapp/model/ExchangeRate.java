package pl.mikbac.salaryapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * Created by MikBac on 2018
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRate {

    private Rate[] rates;

}
