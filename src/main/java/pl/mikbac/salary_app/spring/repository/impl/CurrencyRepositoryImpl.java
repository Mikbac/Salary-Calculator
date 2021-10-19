package pl.mikbac.salary_app.spring.repository.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.mikbac.salary_app.constants.GlobalConstants.Currency;
import pl.mikbac.salary_app.constants.NBPApiConstants;
import pl.mikbac.salary_app.constants.NBPApiConstants.Query.Name;
import pl.mikbac.salary_app.constants.NBPApiConstants.Query.Value;
import pl.mikbac.salary_app.exception.InvalidApiAddressException;
import pl.mikbac.salary_app.model.ExchangeRate;
import pl.mikbac.salary_app.spring.property.NbpProperties;
import pl.mikbac.salary_app.spring.repository.CurrencyRepository;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Optional;

/**
 * Created by MikBac on 07.09.2019
 */

@Log4j2
@Repository
public class CurrencyRepositoryImpl implements CurrencyRepository {

    @Resource
    private NbpProperties nbpProperties;

    @Resource
    private RestTemplate restTemplate;

    @Override
    public Optional<BigDecimal> getExchangeRate(final String currencyCode) {
        final String url = getUrl(currencyCode);

        if (currencyCode.equalsIgnoreCase(Currency.PLN)) {
            return Optional.of(BigDecimal.valueOf(1));
        }
        try {
            ExchangeRate exchangeRate = restTemplate.getForObject(url, ExchangeRate.class);
            if (exchangeRate != null) {
                return Optional.ofNullable(exchangeRate.getRates()[0].getMid());
            } else {
                return Optional.empty();
            }
        } catch (HttpClientErrorException e) {
            throw new InvalidApiAddressException(url);
        }
    }

    private String getUrl(final String currencyCode) {
        return UriComponentsBuilder
                .fromUriString(nbpProperties.getAddress())
                .path(NBPApiConstants.PATH + currencyCode)
                .queryParam(Name.FORMAT, Value.JSON)
                .build()
                .toUriString();
    }

}
