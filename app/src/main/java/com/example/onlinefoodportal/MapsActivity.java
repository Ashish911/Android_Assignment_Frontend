package com.example.onlinefoodportal;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.widget.Toast;

import com.example.onlinefoodportal.model.LatitudeLongitude;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        List<LatitudeLongitude> latlngs = new ArrayList<>();
        latlngs.add(new LatitudeLongitude(27.706195, 85.3278509, "Softwarica College Of IT & E-Commerce"));
        latlngs.add(new LatitudeLongitude(27.6780028, 85.311468, "The Urban Hub"));
        latlngs.add(new LatitudeLongitude(27.7159845, 85.3138627, "Trisara Lazimpat"));
        latlngs.add(new LatitudeLongitude(27.7153689, 85.3030434, "Pizza Hut Durbar Marg"));
        latlngs.add(new LatitudeLongitude(27.7153667, 85.3030434, "KFC Durbar Marg"));
        latlngs.add(new LatitudeLongitude(27.7179415, 85.2767057, "Monkey Temple Cage & Bar"));
        latlngs.add(new LatitudeLongitude(27.722498, 85.2727168, "Tropical Rest"));
        latlngs.add(new LatitudeLongitude(27.7134906, 85.308061, "Kathmandu Steak House Restaurant"));
        latlngs.add(new LatitudeLongitude(27.7185966, 85.310049, "Kathmandu Grill Restaurant & bar"));
        latlngs.add(new LatitudeLongitude(27.7138569, 85.3135519, "Fire and Ice Pizza (Thamel)"));
        latlngs.add(new LatitudeLongitude(27.7160761, 85.3063972, "Fusion Himalaya Restaurant"));

        CameraUpdate center,zoom;
        for (int i = 0; i < latlngs.size() ; i++) {
            center = CameraUpdateFactory.newLatLng(new LatLng(latlngs.get(i).getLat(),latlngs.get(i).getLon()));
            zoom = CameraUpdateFactory.zoomTo(10);
            mMap.addMarker(new MarkerOptions().position(new LatLng(latlngs.get(i).getLat(),latlngs.get(i).getLon()))
                    .title(latlngs.get(i).getMarker()));

            mMap.moveCamera(center);
            mMap.animateCamera(zoom);
            mMap.getUiSettings().setZoomControlsEnabled(true);
        }

    }
}
