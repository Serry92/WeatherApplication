package android.serry.weatherapplication.viewsActivities;

import android.serry.weatherapplication.models.WeatherResponse;

public interface BookmarkWeatherView {

    void initViews();

    void setViews(WeatherResponse weatherResponse);

    void showErrorMessage();
}
