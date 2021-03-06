/**
 * Created by MikBac on 2018
 */

package pl.MikBac.salaryApp.spring.service.impl;

import org.springframework.stereotype.Service;
import pl.MikBac.salaryApp.model.CountryModel;
import pl.MikBac.salaryApp.spring.repository.CountryRepository;
import pl.MikBac.salaryApp.spring.service.CountryService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    @Resource
    CountryRepository countryRepository;

    @Override
    public List<CountryModel> getAll() {
        return countryRepository.findAll();
    }

    @Override
    public void saveCountry(final CountryModel countryModel) {
        countryRepository.save(countryModel);
    }

    @Override
    public Optional<CountryModel> getCountryByCode(final String countryCode) {
        return countryRepository.findByCountryCode(countryCode);
    }

}
