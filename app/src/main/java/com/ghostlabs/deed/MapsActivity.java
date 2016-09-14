package com.ghostlabs.deed;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener, GoogleMap.OnMarkerClickListener  {

    private GoogleMap mMap;
    private static final int REQUEST_LOCATION = 0;
    int REQUEST_ACCESS_FINE_LOCATION;
    LocationRequest mLocationRequest;
    Location currentLocation;
    GoogleApiClient client;
    double user_latitude;
    double user_longitude;
    boolean gps_enabled;
    String address;
    Context context;
    LatLng user_coordinates;
    LatLng cry_coordinates;
    LatLng eklavya_coordinated;
    private Polyline Line;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        client=new GoogleApiClient.Builder(this).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(LocationServices.API).build();
        client.connect();
        mLocationRequest=new LocationRequest();

    }


    @TargetApi(Build.VERSION_CODES.M)
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED ) {

            mMap.setMyLocationEnabled(true);
        } else {
            if (shouldShowRequestPermissionRationale(android.Manifest.permission.ACCESS_FINE_LOCATION)) {
                Toast.makeText(MapsActivity.this, "Location permission is needed", Toast.LENGTH_SHORT).show();
            }
            requestPermissions(new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);

        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == REQUEST_LOCATION) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                mMap.setMyLocationEnabled(true);
            } else {
                Toast.makeText(MapsActivity.this, "Permission not granted", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            super.onRequestPermissionsResult(requestCode,permissions,grantResults);
        }
    }



    @Override
    protected void onStart() {
        Log.d("FUNCTION","onStart");
        super.onStart();
        client.connect();
    }

    @Override
    protected void onStop() {
        Log.d("FUNCTION","onStop");
        client.disconnect();
        super.onStop();

    }
    @Override
    public void onConnected(Bundle bundle) {

        Log.d("FUNCTION","onConnected");

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        mLocationRequest.setInterval(1000);
        currentLocation= LocationServices.FusedLocationApi.getLastLocation(client);


        if(currentLocation==null) {
            Toast.makeText(this, "Could not fetch current location", Toast.LENGTH_LONG).show();
            LocationServices.FusedLocationApi.requestLocationUpdates(client, mLocationRequest,this);
        }
        //If the retrieved location is not null place a marker at that position
        else{

            user_latitude = currentLocation.getLatitude();
            user_longitude = currentLocation.getLongitude();



            if (currentLocation != null)
                Log.d("CURR LOCATION VAL", String.valueOf(currentLocation));
            user_coordinates = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());
            cry_coordinates=new LatLng(13.071160, 80.240431);
            eklavya_coordinated=new LatLng(13.153393, 79.896321);

            mMap.addMarker(new MarkerOptions().position(user_coordinates).title("Marker at current location")).showInfoWindow();
            mMap.moveCamera(CameraUpdateFactory.newLatLng(user_coordinates));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(user_coordinates,10));

            mMap.addMarker(new MarkerOptions().position(cry_coordinates).title("cry"));
            mMap.addMarker(new MarkerOptions().position(eklavya_coordinated).title("Smile Foundation"));
            mMap.setOnMarkerClickListener(this);
            drawlines();
            drawlines1();

        }

        LocationServices.FusedLocationApi.requestLocationUpdates(client, mLocationRequest, this);


    }

    private void drawlines() {
        PolylineOptions lineOption=new PolylineOptions()
                .add(user_coordinates)
                .add(cry_coordinates)
                .width(20)
                .color(Color.RED);

        Line=mMap.addPolyline(lineOption);


    }
    private void drawlines1() {
        PolylineOptions lineOption=new PolylineOptions()
                .add(user_coordinates)
                .add(eklavya_coordinated)
                .width(20)
                .color(Color.GREEN);
        Line=mMap.addPolyline(lineOption);


    }



    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }



    public void orgnearyou(View view) {
        Intent intent=new Intent(this,OrderDetails.class);
        startActivity(intent);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }
}



