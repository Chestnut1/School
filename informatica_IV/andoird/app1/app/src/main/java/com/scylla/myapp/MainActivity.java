package com.scylla.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.scylla.myapp.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main activity";
    private Button btnSal;
    private TextView txtSal;
    private Button btnAltobasso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }

        bindComponents();

        setupEventListener();
    }

    private void bindComponents(){
        btnSal = findViewById(R.id.btnSaluta);
        txtSal = findViewById(R.id.txtSaluta);
    }

    private void setupEventListener(){
        btnSal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                txtSal.setText("Benvenuto, Luca!");
            }
        });
        btnAltobasso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //avvio nuova activity per giocare alto basso
                Intent intent = new Intent(MainActivity.this,ActivityAltobasso.class);
                startActivity(intent);
            }
        });
    }
}
