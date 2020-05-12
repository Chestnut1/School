package com.chestnut.app1v3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Main Activity";
    private Button btnSal, btnAltoBasso, btnAcc, btnTris, btnTrisVsPc, btnForza4, btnPrato;
    private TextView txtSal;

    private int switchSal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e(TAG, "acitivity avviata con successo!");

        bindComponent();
        setupEventListener();
    }
    void bindComponent(){
        btnSal = findViewById(R.id.bntSaluta);
        txtSal = findViewById(R.id.txtSaluta);
        btnAltoBasso = findViewById(R.id.btnAltoBasso);
        btnAcc = findViewById(R.id.btnAccelerometro);
        btnTris = findViewById(R.id.btntris);
        btnTrisVsPc = findViewById(R.id.btnTrisVsPc);
        btnForza4 = findViewById(R.id.btnforza4);
        btnPrato = findViewById(R.id.btnPrato);
    }
    void setupEventListener(){
        btnSal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchSal==0){
                    switchSal+=1;
                    txtSal.setText("Benvenuto Luca!");
                }else{
                    switchSal-=1;
                    txtSal.setText("Benvenuto!");
                }
            }
        });

        btnAltoBasso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Avvio nuova activity per giocare alto basso
                Intent intent = new Intent(MainActivity.this, AltoBassoActivity.class);
                intent.putExtra("var", "valore");
                startActivity(intent);
            }
        });

        btnAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AccActivity.class);
                startActivity(intent);
            }
        });

        btnTris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TrisActivity.class);
                intent.putExtra("g1","Marco");
                intent.putExtra("g2", "Luca");
                startActivity(intent);
            }
        });

        btnTrisVsPc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TrisVsPcActivity.class);
                startActivity(intent);
            }
        });

        btnForza4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Forza4Activity.class);
                startActivity(intent);
            }
        });

        btnPrato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PratoFiorito.class);
                intent.putExtra("g1", "Luca");
                startActivity(intent);
            }
        });
    }
}
