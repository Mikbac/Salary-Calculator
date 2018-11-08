package Services;

import Repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CountryServicempl implements CountryService{

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public double  earnings(String code) {return countryRepository.earnings(code);}

}
