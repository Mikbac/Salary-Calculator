package pl.mikbac.salary_app.constants;

/**
 * Created by MikBac on 19.10.2021
 */
public interface NBPApiConstants {

    String PATH = "/api/exchangerates/rates/A/";

    interface Query {
        interface Name {
            String FORMAT = "format";
        }

        interface Value {
            String JSON = "json";
        }
    }
}
