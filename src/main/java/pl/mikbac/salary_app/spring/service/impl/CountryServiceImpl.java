package pl.mikbac.salary_app.spring.service.impl;

import org.springframework.stereotype.Service;
import pl.mikbac.salary_app.model.CountryModel;
import pl.mikbac.salary_app.spring.repository.CountryRepository;
import pl.mikbac.salary_app.spring.service.CountryService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * Created by MikBac on 2018
 */

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
