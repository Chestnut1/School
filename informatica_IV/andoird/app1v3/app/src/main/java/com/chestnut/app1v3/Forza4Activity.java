package com.chestnut.app1v3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

public class Forza4Activity extends AppCompatActivity {
    private static final String TAG = "Forza 4 acrtivity";

    private final int ROWS = 6;
    private final int COLS = 7;
    private boolean player = true;  //true -> 1, false -> 2

    int m[][];
    Button btn[][];


    TableRow tb0, tb1, tb2, tb3, tb4, tb5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forza4);

        Log.e(TAG, "Activity avviata con successo");

        //initialize matrix
        m = new int[ROWS][COLS];
        for(int i=0; i<ROWS; i++){
            for(int j=0; j<COLS; j++){
                m[i][j] = 0;
            }
        }

        //bind components
        bindCOmponents();

    }

    void bindCOmponents(){
        btn = new Button[ROWS][COLS];

        tb0 = findViewById(R.id.tbR0);
        tb1 = findViewById(R.id.tbR1);
        tb2 = findViewById(R.id.tbR2);
        tb3 = findViewById(R.id.tbR3);
        tb4 = findViewById(R.id.tbR4);
        tb5 = findViewById(R.id.tbR5);

        //create button matrix
        Button btn;

        for(int i=0; i<COLS; i++){
            btn = new Button(this);
            btn.setLayoutParams(new ViewGroup.LayoutParams(30, 30));
            btn.setTransitionName("btn_0_"+i);
            btn.setOnClickListener(new myListener());
            tb0.addView(btn);
        }
        for(int i=0; i<COLS; i++){
            btn = new Button(this);
            btn.setLayoutParams(new ViewGroup.LayoutParams(30, 30));
            btn.setTransitionName("btn_1_"+i);
            btn.setOnClickListener(new myListener());
            tb1.addView(btn);
        }
        for(int i=0; i<COLS; i++){
            btn = new Button(this);
            btn.setLayoutParams(new ViewGroup.LayoutParams(30, 30));
            btn.setTransitionName("btn_2_"+i);
            btn.setOnClickListener(new myListener());
            tb2.addView(btn);
        }
        for(int i=0; i<COLS; i++){
            btn = new Button(this);
            btn.setLayoutParams(new ViewGroup.LayoutParams(30, 30));
            btn.setTransitionName("btn_3_"+i);
            btn.setOnClickListener(new myListener());
            tb3.addView(btn);
        }
        for(int i=0; i<COLS; i++){
            btn = new Button(this);
            btn.setLayoutParams(new ViewGroup.LayoutParams(30, 30));
            btn.setTransitionName("btn_4_"+i);
            btn.setOnClickListener(new myListener());
            tb4.addView(btn);
        }
        for(int i=0; i<COLS; i++){
            btn = new Button(this);
            btn.setLayoutParams(new ViewGroup.LayoutParams(50, 30));
            btn.setTransitionName("btn_5_"+i);
            btn.setOnClickListener(new myListener());
            tb5.addView(btn);
        }
    }

    class myListener implements View.OnClickListener{
        private static final String TAG = "ClassListener";

        @Override
        public void onClick(View v) {
            Button b = (Button) v;
            int x,y;
            x = Integer.parseInt(b.getTransitionName().split("_")[1]);
            y = Integer.parseInt(b.getTransitionName().split("_")[2]);

            inserisciMoneta(x,y);
        }

        private void inserisciMoneta(int x, int y){

        }
    }
}
