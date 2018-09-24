package android.serry.weatherapplication.views;

import android.serry.weatherapplication.models.WeatherResponse;

public interface BookmarkWeatherView {

    void initViews();

    void setViews(WeatherResponse weatherResponse);

    void showErrorMessage();
}
