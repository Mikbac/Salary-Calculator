/**
 * Created by MikBac on 17.08.2019
 */

package pl.MikBac.salaryApp.spring.repository.salary.impl.strategies.address;

public enum Address {

    NBP("http://api.nbp.pl");

    private String url;

    Address(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
