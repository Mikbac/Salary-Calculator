package pl.mikbac.salary_app.data.impl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.mikbac.salary_app.data.Data;

/**
 * Created by MikBac on 07.09.2019
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountryData implements Data {

    private String countryCode;
    private String currencyCode;

}
