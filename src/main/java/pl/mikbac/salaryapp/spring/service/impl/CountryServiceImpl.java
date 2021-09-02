package pl.mikbac.salaryapp.spring.service.impl;

import org.springframework.stereotype.Service;
import pl.mikbac.salaryapp.spring.repository.CountryRepository;
import pl.mikbac.salaryapp.model.CountryModel;
import pl.mikbac.salaryapp.spring.service.CountryService;

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
