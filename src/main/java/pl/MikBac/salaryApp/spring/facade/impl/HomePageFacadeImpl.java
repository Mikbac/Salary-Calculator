/**
 * Created by MikBac on 19.08.2019
 */

package pl.MikBac.salaryApp.spring.facade.impl;

import org.springframework.stereotype.Component;
import pl.MikBac.salaryApp.model.CountryModel;
import pl.MikBac.salaryApp.spring.facade.HomePageFacade;
import pl.MikBac.salaryApp.spring.service.CountryService;

import javax.annotation.Resource;
import java.util.List;

@Component
public class HomePageFacadeImpl implements HomePageFacade {

    @Resource
    private CountryService countryService;

    @Override
    public List<CountryModel> getCountries() {
        return countryService.getAll();
    }

}
