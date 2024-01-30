package com.example.myapplication;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AccelerometerActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);



    }
    @Override
    public void onSensorChanged(SensorEvent event) {

        setAccelerometerText(String.valueOf(event.values[0]),findViewById(R.id.AccelerometerData),R.string.accelerometerData1 );
        setAccelerometerText(String.valueOf(event.values[1]),findViewById(R.id.AccelerometerData2),R.string.accelerometerData2 );
        setAccelerometerText(String.valueOf(event.values[2]),findViewById(R.id.AccelerometerData3),R.string.accelerometerData3 );

    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy){
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
    @Override
    protected void onStop() {
        super.onStop();
        sensorManager.unregisterListener(this);
    }


    public void setAccelerometerText(String value, TextView textView, int stringRes) {
        textView.setText(getString(stringRes, value));
    }
}
