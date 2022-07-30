package HomeWork07;

import HomeWork07.FiveDays.FiveDays;
import HomeWork07.WeatherResponse.WeatherResponse;
import HomeWork07.enums.Periods;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

public class AccuWeatherProvider  implements WeatherProvider {

    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECAST_ENDPOINT = "forecasts";
    private static final String CURRENT_CONDITIONS_ENDPOINT = "currentconditions";
    private static final String API_VERSION = "v1";
    private static final String FORECAST_TYPE = "daily";
    private static final String FORECAST_PERIOD = "5day";
    private static final String API_KEY = ApplicationGlobalState.getInstance().getApiKey();

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void getWeather(Periods periods) throws IOException {
        String cityKey = detectCityKey();
        if (periods.equals(Periods.NOW)) {
            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http")
                    .host(BASE_HOST)
                    .addPathSegment(CURRENT_CONDITIONS_ENDPOINT)
                    .addPathSegment(API_VERSION)
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(url)
                    .build();

            String response = client.newCall(request).execute().body().string();
            System.out.println(response);

            StringReader reader1 = new StringReader(response);

            List<WeatherResponse> weatherResponseList = objectMapper.readValue(reader1, new TypeReference <List<WeatherResponse>>() {});
            System.out.println("Weather text: " + weatherResponseList.get(0).getWeatherText() +
                    ", Temperature :" + weatherResponseList.get(0).getTemperature().getMetric().getValue()+weatherResponseList.get(0).getTemperature().getMetric().getUnit());


        } else if (periods.equals(Periods.FIVE_DAYS)) {

            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http")
                    .host(BASE_HOST)
                    .addPathSegment(FORECAST_ENDPOINT)
                    .addPathSegment(API_VERSION)
                    .addPathSegment(FORECAST_TYPE)
                    .addPathSegment(FORECAST_PERIOD)
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(url)
                    .build();

            ObjectMapper objectMapper1 = new ObjectMapper();

            String response1 = client.newCall(request).execute().body().string();
            System.out.println(response1);

            StringReader reader2 = new StringReader(response1);
            FiveDays fiveDaysresponce = objectMapper1.readValue(reader2, FiveDays.class);

            for (int i = 0; i<5; i++)
            {
                System.out.println("В городе: " + ApplicationGlobalState.getInstance().getSelectedCity() +
                    ", дата: " +fiveDaysresponce.getDailyForecasts().get(i).getDate() +
                  ", ожидается днём: " + fiveDaysresponce.getDailyForecasts().get(i).getDay().getIconPhrase() +
                    ", температура: " + fiveDaysresponce.getDailyForecasts().get(i).getTemperature().getMaximum().getValue() +
                    fiveDaysresponce.getDailyForecasts().get(i).getTemperature().getMaximum().getUnit());
            }

        }
    }

    public String detectCityKey() throws IOException {
        String selectedCity = ApplicationGlobalState.getInstance().getSelectedCity();

        HttpUrl detectLocationURL = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment("locations")
                .addPathSegment(API_VERSION)
                .addPathSegment("cities")
                .addPathSegment("autocomplete")
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("q", selectedCity)
                .build();

        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(detectLocationURL)
                .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            throw new IOException("Невозможно прочесть информацию о городе. " +
                    "Код ответа сервера = " + response.code() + " тело ответа = " + response.body().string());
        }
        String jsonResponse = response.body().string();
        System.out.println("Произвожу поиск города " + selectedCity);

        if (objectMapper.readTree(jsonResponse).size() > 0) {
            String cityName = objectMapper.readTree(jsonResponse).get(0).at("/LocalizedName").asText();
            String countryName = objectMapper.readTree(jsonResponse).get(0).at("/Country/LocalizedName").asText();
            System.out.println("Найден город " + cityName + " в стране " + countryName);
        } else throw new IOException("Server returns 0 cities");

        return objectMapper.readTree(jsonResponse).get(0).at("/Key").asText();
    }

}


