package android.serry.weatherapplication.models;

import android.arch.persistence.room.PrimaryKey;
import android.content.Context;
import android.serry.weatherapplication.R;
import android.serry.weatherapplication.connections.ApiClient;
import android.serry.weatherapplication.connections.Apis;
import android.serry.weatherapplication.listeners.OnLoadWeatherFromServerListener;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherResponse {
    @PrimaryKey(autoGenerate = true)
    private String id;
    private String name;
    private BookmarkMain main;
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

    public BookmarkMain getMain() {
        return main;
    }

    public BookmarkWind getWind() {
        return wind;
    }

    public void connectWithServerToGetWeatherInfo(final Context context, String lat, String lng, final OnLoadWeatherFromServerListener onLoadWeatherFromServerListener) {
        Apis apis = ApiClient.getApiClient().create(Apis.class);
        Call<WeatherResponse> responseCall = apis.getWeatherInfo(lat, lng, context.getResources().getString(R.string.app_id), context.getResources().getString(R.string.units));
        responseCall.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(@NonNull Call<WeatherResponse> call, @NonNull Response<WeatherResponse> response) {
                Log.w("response ", new Gson().toJson(response));
                if (response.body() != null)
                    onLoadWeatherFromServerListener.onLoadWeatherInfo(response.body());
                else
                    onLoadWeatherFromServerListener.onError();
            }

            @Override
            public void onFailure(@NonNull Call<WeatherResponse> call, @NonNull Throwable t) {
                Toast.makeText(context, context.getResources().getString(R.string.error), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
