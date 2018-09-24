package android.serry.weatherapplication.views;

import android.os.Bundle;
import android.serry.weatherapplication.R;
import android.serry.weatherapplication.models.Bookmark;
import android.serry.weatherapplication.models.WeatherResponse;
import android.serry.weatherapplication.presenters.BookmarkWeatherPresenterImp;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class BookmarkWeatherActivity extends AppCompatActivity implements BookmarkWeatherView {
    private TextView tvLocation, tvHumidityDec, tvTempDesc, tvWindDeg, tvWindSpeed;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bookmark bookmark = getIntent().getParcelableExtra("bookmark");
        if (bookmark != null) {
            setContentView(R.layout.activity_bookmarkweather);
            BookmarkWeatherPresenterImp bookmarkWeatherPresenterImp = new BookmarkWeatherPresenterImp(this, this);
            bookmarkWeatherPresenterImp.onCreate();
            bookmarkWeatherPresenterImp.getWeatherInfo(bookmark.getLat(), bookmark.getLng());
        }
    }


    @Override
    public void initViews() {
        tvLocation = findViewById(R.id.tv_location_name);
        tvHumidityDec = findViewById(R.id.tv_humidity_desc);
        tvTempDesc = findViewById(R.id.tv_temp_desc);
        tvWindDeg = findViewById(R.id.tv_wind_deg_desc);
        tvWindSpeed = findViewById(R.id.tv_wind_speed_desc);
    }

    @Override
    public void setViews(WeatherResponse weatherResponse) {
        tvLocation.setText(weatherResponse.getName());
        tvHumidityDec.setText(weatherResponse.getMain().getHumidity());
        tvTempDesc.setText(weatherResponse.getMain().getTemp());
        tvWindSpeed.setText(weatherResponse.getWind().getSpeed());
        tvWindDeg.setText(weatherResponse.getWind().getDeg());
    }
}
