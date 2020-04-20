package com.chestnut.app1v3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class Forza4Activity extends AppCompatActivity {
    private static final String TAG = "Forza 4 acrtivity";

    public int m[][];   //integer matrix
    Button b[][];   //button matrix
    public boolean player1 = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forza4);

        Log.e(TAG, "Activity avviata con successo");

        //initialize matrix
        for(int r=0; r<5; r++){
            for(int c=0; c<4; c++){
                m[r][c] = 0;
            }
        }

        //binding
        bindComponents();

        //adding listeners
    }

    void bindComponents(){

    }
}
