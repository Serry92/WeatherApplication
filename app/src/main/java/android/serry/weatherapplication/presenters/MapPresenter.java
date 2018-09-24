package android.serry.weatherapplication.presenters;

import android.view.View;

import com.google.android.gms.maps.model.LatLng;

public interface MapPresenter {
    void onCreate(View view);

    void addNewLocation(LatLng latLng);
}
