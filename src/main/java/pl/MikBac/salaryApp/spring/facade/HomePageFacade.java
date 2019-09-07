/**
 * Created by MikBac on 19.08.2019
 */

package pl.MikBac.salaryApp.spring.facade;

import pl.MikBac.salaryApp.model.CountryModel;

public interface HomePageFacade {

    Iterable<CountryModel> getCountries();

}
