/**
 * Created by MikBac on 2018
 */

package pl.MikBac.salaryApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRate {

    private Rate[] rates;

}
