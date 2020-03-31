package com.chestnut.myappv2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chestnut.myappv2.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main Activity";
    private Button btnSal;
    private TextView txtSal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
        //e per errore (rosso), d messaggi di routine, i messaggi informativi
        Log.e(TAG, "activity avviata correttamente!");

        bindComponent();
        setupEventListener();
    }

    void bindComponent(){
        //R calsse prinicpale ha accesso su tutta la classe di lavoro
        btnSal = findViewById(R.id.btnSaluta);
        txtSal = findViewById(R.id.textSaluta);
    }

    void setupEventListener(){
        btnSal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSal.setText("Ciao");
            }
        });
    }
}