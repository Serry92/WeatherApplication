package android.serry.weatherapplication.models;

import android.app.ProgressDialog;
import android.arch.persistence.room.PrimaryKey;
import android.content.Context;
import android.serry.weatherapplication.R;
import android.serry.weatherapplication.connections.ApiClient;
import android.serry.weatherapplication.connections.Apis;
import android.serry.weatherapplication.listeners.OnLoadWeatherFromServerListener;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherResponse {
    @PrimaryKey(autoGenerate = true)
    private String id;
    private String name;
    private String cod;
    private BookmarkCoOrd coord;
    private BookmarkMain main;
    private List<BookmarkWeather> weather;
    private BookmarkWind wind;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public BookmarkCoOrd getCoord() {
        return coord;
    }

    public void setCoord(BookmarkCoOrd coord) {
        this.coord = coord;
    }

    public BookmarkMain getMain() {
        return main;
    }

    public void setMain(BookmarkMain main) {
        this.main = main;
    }

    public List<BookmarkWeather> getWeather() {
        return weather;
    }

    public void setWeather(List<BookmarkWeather> weather) {
        this.weather = weather;
    }

    public BookmarkWind getWind() {
        return wind;
    }

    public void setWind(BookmarkWind wind) {
        this.wind = wind;
    }

    public void connectWithServerToGetWeatherInfo(Context context, String lat, String lng, final OnLoadWeatherFromServerListener onLoadWeatherFromServerListener) {
        final ProgressDialog pd = ProgressDialog.show(context, null, "Please wait");
        Apis apis = ApiClient.getApiClient().create(Apis.class);
        Call<WeatherResponse> responseCall = apis.getWeatherInfo(lat, lng, context.getResources().getString(R.string.app_id), context.getResources().getString(R.string.units));
        responseCall.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(@NonNull Call<WeatherResponse> call, @NonNull Response<WeatherResponse> response) {

                Log.w("response ", new Gson().toJson(response));
                pd.dismiss();
                if (response.body() != null)
                    onLoadWeatherFromServerListener.onLoadWeatherInfo(response.body());
                else
                    onLoadWeatherFromServerListener.onError();
            }

            @Override
            public void onFailure(@NonNull Call<WeatherResponse> call, @NonNull Throwable t) {
                pd.dismiss();
            }
        });
    }
}
