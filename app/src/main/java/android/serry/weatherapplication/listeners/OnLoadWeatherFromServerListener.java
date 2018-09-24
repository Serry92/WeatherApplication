package android.serry.weatherapplication.listeners;

import android.serry.weatherapplication.models.WeatherResponse;

public interface OnLoadWeatherFromServerListener {
    void onLoadWeatherInfo(WeatherResponse weatherResponse);
    void onError();
}
