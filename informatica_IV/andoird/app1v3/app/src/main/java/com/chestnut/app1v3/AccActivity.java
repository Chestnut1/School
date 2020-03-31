package com.chestnut.app1v3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AccActivity extends AppCompatActivity implements SensorEventListener{
    private static final String TAG = "AccActivitgy";

    private int x,y,z;
    private TextView txtX, txtY, txtZ;
    private Button btnEsci;

    private SensorManager sensorManager;
    private Sensor accelerometro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acc);

        //BIND COMPENENTS
        txtX = findViewById(R.id.xValue);
        txtY = findViewById(R.id.yValue);
        txtZ = findViewById(R.id.zValue);
        btnEsci = findViewById(R.id.btnEsciAcc);

        //LISTENER
        btnEsci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccActivity.this.finish();
            }
        });

        //SENSOR
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);   //assegno la funzione al sensor manager
        accelerometro = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sensorManager.registerListener((SensorEventListener) this, accelerometro, SensorManager.SENSOR_DELAY_NORMAL);   //attivo il sensore e inizio a registrare i dati


    }

    @Override   //triggerato tutte le volte che viene rilevata una modifica sugli assi
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){    //controllo se il sensore e' l'accelerometro
            Log.d(TAG,"X: " + event.values[0] + " Y: " +
                    event.values[1] + " Z: " +
                    event.values[2]
            );
            txtX.setText("X: " + event.values[0]);
            txtY.setText("Y: " + event.values[1]);
            txtZ.setText("Z: " + event.values[2]);
        }


    }

    @Override   //triggerato tutte le volte che il gestore del sensore va a modificare la precisione con cui deve rispondere il sensore stesso
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
