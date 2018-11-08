import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;


public class ExchangeRate {

    private JSONObject downloadExchangeRate(String countryCode) {

        try {

            String url = "http://api.nbp.pl/api/exchangerates/rates/A/"+countryCode+"/today/?format=json";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
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

    public double getExchangeRate(String countryCode) {

        double exchangeRate = 1.0;

        try {

            JSONObject response = downloadExchangeRate(countryCode);

            exchangeRate = response.getJSONArray("rates").getJSONObject(0).getDouble("mid");

            return exchangeRate;

        } catch (Exception e) {

            return 1.0;

        }


    }


}
