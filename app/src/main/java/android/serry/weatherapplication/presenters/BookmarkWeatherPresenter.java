package android.serry.weatherapplication.presenters;

public interface BookmarkWeatherPresenter {
    void onCreate();

    void getWeatherInfo(String  lat, String lng);
}
