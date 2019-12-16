package com.example.sensors;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
//import android.location.LocationListener;
//import android.location.LocationListener;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // private fields of the class
    private TextView tv_lat, tv_long;
    private LocationManager lm;
    Button start,stop;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button start = (Button) findViewById(R.id.start);
        Button stop = (Button) findViewById(R.id.stop);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // pull the textviews from the xml and get access to the location manager
        tv_lat = (TextView) findViewById(R.id.tv_lat);
        tv_long = (TextView) findViewById(R.id.tv_long);
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);


// add in the location

    }

@RequiresApi(api = Build.VERSION_CODES.M)
public void start(View v){
    // add in the location listener
    addLocationListener();
}

public void stop(View v){

        lm = null;

}


    // private method that will add a location listener to the location manager
    @RequiresApi(api = Build.VERSION_CODES.M)
// private method that will add a location listener to the location manager
    private void addLocationListener() {
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    Activity#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for Activity#requestPermissions for more details.
            return;
        }
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 5, new
                LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {
// the location of the device has changed so update the
// textviews to reflect this
                        tv_lat.setText("Latitude: " + location.getLatitude());
                        tv_long.setText("Longitude: " + location.getLongitude());
                    }

                    @Override
                    public void onProviderDisabled(String provider) {
// if GPS has been disabled then update the textviews to reflect

// this
                        if (provider == LocationManager.GPS_PROVIDER) {
                            tv_lat.setText(R.string.tv_lat_text);
                            tv_long.setText(R.string.tv_long_text);
                        }
                    }

                    @Override
                    public void onProviderEnabled(String provider) {
// if there is a last known location then set it on the
//textviews
                        if (provider == LocationManager.GPS_PROVIDER) {
                            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                                // TODO: Consider calling
                                //    Activity#requestPermissions
                                // here to request the missing permissions, and then overriding
                                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                //                                          int[] grantResults)
                                // to handle the case where the user grants the permission. See the documentation
                                // for Activity#requestPermissions for more details.
                                return;
                            }
                            Location l =
                                    lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                            if (l != null) {
                                tv_lat.setText("Latitude: " + l.getLatitude());
                                tv_long.setText("Longitude: " + l.getLongitude());
                            }
                        }
                    }

                    @Override
                    public void onStatusChanged(String provider, int status, Bundle
                            extras) {
                    }
                });
    }

}