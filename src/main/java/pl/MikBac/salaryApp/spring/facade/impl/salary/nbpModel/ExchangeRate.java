/**
 * Created by MikBac on 2018
 */

package pl.MikBac.salaryApp.spring.facade.impl.salary.nbpModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRate {

    private Rate[] rates;

}
