package pl.mikbac.salary_app.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mikbac.salary_app.model.CountryModel;

import java.util.List;
import java.util.Optional;

/**
 * Created by MikBac on 2018
 */

public interface CountryRepository extends JpaRepository<CountryModel, Long> {

    /**
     * Find country by country code.
     *
     * @param countryCode of selected country.
     * @return optional {@link CountryModel}.
     */
    Optional<CountryModel> findByCountryCode(String countryCode);

    /**
     * Find the list of all countries.
     *
     * @return list of all countries {@link CountryModel}.
     */
    List<CountryModel> findAll();

}
