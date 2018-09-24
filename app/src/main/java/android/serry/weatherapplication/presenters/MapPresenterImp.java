package android.serry.weatherapplication.presenters;

import android.app.ProgressDialog;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.serry.weatherapplication.R;
import android.serry.weatherapplication.listeners.OnUpdateDatabaseListener;
import android.serry.weatherapplication.models.Bookmark;
import android.serry.weatherapplication.viewsFragments.MapView;
import android.view.View;

import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapPresenterImp implements MapPresenter, OnUpdateDatabaseListener {
    private MapView mapView;
    private Context context;
    private ProgressDialog progressDialog;

    public MapPresenterImp(MapView mapView, Context context) {
        this.mapView = mapView;
        this.context = context;
    }

    @Override
    public void onCreate(View view) {
        mapView.initViews(view);
    }

    @Override
    public void addNewLocation(LatLng latLng) {
        progressDialog = ProgressDialog.show(context, null, context.getResources().getString(R.string.new_location));
        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        List<Address> addresses;
        try {
            addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);
            String cityName = addresses.get(0).getAddressLine(0);

            Bookmark bookmark = new Bookmark(cityName, String.valueOf(latLng.latitude), String.valueOf(latLng.longitude));
            bookmark.addBookmarkToDatabase(bookmark, context, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSuccess() {
        progressDialog.dismiss();
    }


}
