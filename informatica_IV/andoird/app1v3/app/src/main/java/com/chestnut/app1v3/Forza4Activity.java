package com.chestnut.app1v3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableRow;

public class Forza4Activity extends AppCompatActivity {
    private static final String TAG = "Forza 4 acrtivity";

    public int m[][];   //integer matrix
    Button b[][];   //button matrix
    public boolean player1 = true;

    TableRow tb[];

    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forza4);

        Log.e(TAG, "Activity avviata con successo");

        //initialize matrix
        m = new int[6][7];
        for(int r=0; r<6; r++){
            for(int c=0; c<7; c++){
                m[r][c] = 0;
            }
        }

        //binding
        tb[0] = findViewById(R.id.tbR1);
        tb[1] = findViewById(R.id.tbR2);
        tb[2] = findViewById(R.id.tbR3);
        tb[3] = findViewById(R.id.tbR4);
        tb[4] = findViewById(R.id.tbR5);
        tb[5] = findViewById(R.id.tbR6);


        for(int i=0; i<6; i++){
            for(int k=0; k<7; k++){
                btn = new Button(this);
                btn.setTransitionName("btn_"+ k +"_"+i);
                btn.setBackgroundResource(R.color.azzurroTrasparente);
                btn.setOnClickListener(new MyListener());
                tb[k].addView(btn);
            }
        }
        //adding listeners
    }

    void bindComponents(){

    }

    class MyListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            int x,y;
            Button btn = (Button) v;
            x = Integer.parseInt(btn.getTransitionName().split("_")[1]);
            y = Integer.parseInt(btn.getTransitionName().split("_")[1]);
        }

        private void inserisciMoneta(int x, int y){

        }
    }
}
