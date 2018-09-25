package android.serry.weatherapplication.presenters;

import android.content.Context;
import android.serry.weatherapplication.listeners.OnLoadWeatherFromServerListener;
import android.serry.weatherapplication.models.WeatherResponse;
import android.serry.weatherapplication.viewsActivities.BookmarkWeatherView;

public class BookmarkWeatherPresenterImp implements BookmarkWeatherPresenter, OnLoadWeatherFromServerListener {
    private BookmarkWeatherView bookmarkWeatherView;
    private Context context;

    public BookmarkWeatherPresenterImp(BookmarkWeatherView bookmarkWeatherView, Context context) {
        this.context = context;
        this.bookmarkWeatherView = bookmarkWeatherView;
    }

    @Override
    public void onCreate() {
        bookmarkWeatherView.initViews();
    }

    @Override
    public void getWeatherInfo(String lat, String lng) {
        WeatherResponse weatherResponse = new WeatherResponse();
        weatherResponse.connectWithServerToGetWeatherInfo(context, lat, lng, this);
    }

    @Override
    public void onLoadWeatherInfo(WeatherResponse weatherResponse) {
        bookmarkWeatherView.setViews(weatherResponse);
    }

    @Override
    public void onError() {
        bookmarkWeatherView.showErrorMessage();
    }
}
