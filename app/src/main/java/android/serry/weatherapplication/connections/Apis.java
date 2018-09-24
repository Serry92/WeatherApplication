package android.serry.weatherapplication.connections;

import android.serry.weatherapplication.models.WeatherResponse;
import android.serry.weatherapplication.utilities.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Apis {
    @GET(Constants.API_CURRENT_WEATHER)
    Call<WeatherResponse> getWeatherInfo(@Query("lat") String lat, @Query("lon") String lng, @Query("APPID") String appID, @Query("units") String units);
}

