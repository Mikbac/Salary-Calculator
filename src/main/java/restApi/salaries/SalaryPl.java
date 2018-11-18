package restApi.salaries;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;


public class SalaryPl {

    private static JSONObject downloadExchangeRate(String countryCode) {

        try {

            String url = "http://api.nbp.pl/api/exchangerates/rates/A/" + countryCode + "/?format=json";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject myresponse = new JSONObject(response.toString());

            return myresponse;

        } catch (Exception e) {

            return null;

        }


    }

    public static BigDecimal getExchangeRate(String countryCode) {

        if (countryCode.equalsIgnoreCase("PLN"))
            return BigDecimal.valueOf(1);

        BigDecimal exchangeRate = BigDecimal.valueOf(1.0);

        try {

            JSONObject response = downloadExchangeRate(countryCode);

            exchangeRate = response.getJSONArray("rates").getJSONObject(0).getBigDecimal("mid");

            return exchangeRate;

        } catch (Exception e) {

            return BigDecimal.valueOf(0);

        }


    }

    public static BigDecimal getPlnSalary(BigDecimal valueFromClient, BigDecimal fixedCosts, BigDecimal tax, String currencyCode) {

        BigDecimal baseValue = (valueFromClient.multiply(BigDecimal.valueOf(22))).subtract(fixedCosts);
        BigDecimal salary = baseValue.subtract(baseValue.multiply(tax.divide(BigDecimal.valueOf(100))));

        BigDecimal exchangePLN = getExchangeRate(currencyCode);
        BigDecimal salaryPLN = exchangePLN.multiply(salary);

        return salaryPLN.setScale(2, RoundingMode.CEILING);

    }


}
