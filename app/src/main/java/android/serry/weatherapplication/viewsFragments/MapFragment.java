package android.serry.weatherapplication.viewsFragments;

import android.os.Bundle;
import android.serry.weatherapplication.R;
import android.serry.weatherapplication.presenters.MapPresenterImp;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class MapFragment extends Fragment implements MapView, OnMapReadyCallback, GoogleMap.OnMapLongClickListener {
    private static MapFragment instanceMapFragment;
    private MapPresenterImp mapPresenterImp;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mapPresenterImp = new MapPresenterImp(this, getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_maps, container, false);
        mapPresenterImp.onCreate(view);
        return view;

    }

    public static synchronized MapFragment getInstance() {
        if (instanceMapFragment == null) {
            instanceMapFragment = new MapFragment();
        }
        return new MapFragment();
    }

    @Override
    public void initViews(View view) {
        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng latLng = new LatLng(-34, 34);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap.setOnMapLongClickListener(this);
    }

    @Override
    public void onMapLongClick(LatLng latLng) {
        mapPresenterImp.addNewLocation(latLng);
    }
}
