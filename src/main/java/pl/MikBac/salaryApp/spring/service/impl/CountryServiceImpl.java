/**
 * Created by MikBac on 2018
 */

package pl.MikBac.salaryApp.spring.service.impl;

import org.springframework.stereotype.Service;
import pl.MikBac.salaryApp.model.CountryModel;
import pl.MikBac.salaryApp.spring.repository.CountryRepository;
import pl.MikBac.salaryApp.spring.service.CountryService;

import javax.annotation.Resource;

@Service
public class CountryServiceImpl implements CountryService {

    @Resource
    CountryRepository countryRepository;

    @Override
    public Iterable<CountryModel> getAll() {
        return countryRepository.findAll();
    }

    @Override
    public CountryModel saveCountry(final CountryModel countryModel) {
        return countryRepository.save(countryModel);
    }

    @Override
    public Boolean isExistsCountryByCountryCode(final String countryCode) {
        return countryRepository.existsCountryByCountryCode(countryCode).orElse(null);
    }

    @Override
    public CountryModel findByCountryCode(final String countryCode) {
        return countryRepository.findByCountryCode(countryCode).orElse(null);
    }

}
