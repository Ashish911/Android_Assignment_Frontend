package com.example.onlinefoodportal.ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.onlinefoodportal.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

/**
 * A simple {@link Fragment} subclass.
 */
public class LocationFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    int Permission_ID = 44;
    FusedLocationProviderClient mFusedLocationClient;
    double Long;
    double Lat;

    public LocationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_location, container, false);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }
}
