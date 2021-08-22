/**
 * Created by MikBac on 07.09.2019
 */

package pl.MikBac.salaryApp.spring.repository.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.MikBac.salaryApp.exception.InvalidApiAddressException;
import pl.MikBac.salaryApp.model.ExchangeRate;
import pl.MikBac.salaryApp.spring.property.NbpProperties;
import pl.MikBac.salaryApp.spring.repository.CurrencyRepository;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Optional;

@Log4j2
@Repository
public class CurrencyRepositoryImpl implements CurrencyRepository {

    @Resource
    private NbpProperties nbpProperties;

    private String getUrl(final String currencyCode) {
        return nbpProperties.getAddress() + "/api/exchangerates/rates/A/" + currencyCode + "/?format=json";
    }

    @Override
    public Optional<BigDecimal> getExchangeRate(final String currencyCode) {
        String url = getUrl(currencyCode);
        if (currencyCode.equalsIgnoreCase("PLN")) {
            return Optional.of(BigDecimal.valueOf(1));
        }
        try {
            RestTemplate restTemplate = new RestTemplate();
            ExchangeRate exchangeRate = restTemplate.getForObject(url, ExchangeRate.class);
            if (exchangeRate != null) {
                return Optional.ofNullable(exchangeRate.getRates()[0].getMid());
            } else {
                return Optional.empty();
            }
        } catch (HttpClientErrorException e) {
            log.error("Invalid API address for url: {}", () -> url);
            throw new InvalidApiAddressException(url);
        }
    }

}
