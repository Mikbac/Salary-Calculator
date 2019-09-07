/**
 * Created by MikBac on 07.09.2019
 */

package pl.MikBac.salaryApp.spring.repository.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.MikBac.salaryApp.exception.InvalidApiAddressException;
import pl.MikBac.salaryApp.spring.repository.CurrencyRepository;
import pl.MikBac.salaryApp.spring.repository.impl.address.Address;
import pl.MikBac.salaryApp.spring.repository.impl.nbpModel.ExchangeRate;

import java.math.BigDecimal;
import java.util.Optional;

@Log4j2
@Repository
public class CurrencyRepositoryImpl implements CurrencyRepository {

    private String getUrl(final String currencyCode) {
        return Address.NBP.getUrl() + "/api/exchangerates/rates/A/" + currencyCode + "/?format=json";
    }

    @Override
    public Optional<BigDecimal> getExchangeRate(final String currencyCode) {
        String url = getUrl(currencyCode);
        if (currencyCode.equalsIgnoreCase("PLN")) {
            return Optional.ofNullable(BigDecimal.valueOf(1));
        }
        try {
            RestTemplate restTemplate = new RestTemplate();
            ExchangeRate exchangeRate = restTemplate.getForObject(url, ExchangeRate.class);
            return Optional.ofNullable(exchangeRate.getRates()[0].getMid());
        } catch (HttpClientErrorException e) {
            log.error("Invalid API address for url: {}", () -> url);
            throw new InvalidApiAddressException(url);
        }
    }

}
