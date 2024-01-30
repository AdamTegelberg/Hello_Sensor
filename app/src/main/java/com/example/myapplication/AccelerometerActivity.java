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
        String value1 = String.valueOf(event.values[0]);
        String value2 = String.valueOf(event.values[1]);
        String value3 = String.valueOf(event.values[2]);

        TextView textX = findViewById(R.id.AccelerometerData);
        TextView textY = findViewById(R.id.AccelerometerData2);
        TextView textZ = findViewById(R.id.AccelerometerData3);

        textX.setText(value1);
        textY.setText(value2);
        textZ.setText(value3);
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy){
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }
}