package com.chestnut.app1v3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TrisActivity extends AppCompatActivity {
    private static final String TAG = "Tris Activity";

    public int m[][];
    Button b[][];
    public boolean player1;
    public TextView lblTile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tris);

        Log.e(TAG, "Activity avviata con successo");

        //initialize matrix
        for(int r=0; r<3; r++){
            for(int c=0; c<3; c++){
                m[r][c] = 0;
            }
        }

        //set new title
        Intent intent;
        intent = new Intent();
        lblTile.setText(intent.getStringExtra("g1") + " VS " +intent.getStringExtra("g2"));

        player1 = true; //player 1 start

        //bind components
        bindComponents();

        //add listener to buttons
        addListeners();
    }

    public void initGame(){


    }

    public void bindComponents(){
        lblTile.findViewById(R.id.lblTitolo);

        b = new Button[3][3];

        b[0][0].findViewById(R.id.btn00);   b[0][0].setTransitionName("btn_0_0");
        b[0][1].findViewById(R.id.btn00);   b[0][1].setTransitionName("btn_0_1");
        b[0][2].findViewById(R.id.btn00);   b[0][2].setTransitionName("btn_0_2");
        b[1][0].findViewById(R.id.btn00);   b[1][0].setTransitionName("btn_1_0");
        b[1][1].findViewById(R.id.btn00);   b[1][1].setTransitionName("btn_1_1");
        b[1][2].findViewById(R.id.btn00);   b[1][2].setTransitionName("btn_1_2");
        b[2][0].findViewById(R.id.btn00);   b[2][0].setTransitionName("btn_2_0");
        b[2][1].findViewById(R.id.btn00);   b[2][1].setTransitionName("btn_2_1");
        b[2][2].findViewById(R.id.btn00);   b[2][2].setTransitionName("btn_2_2");
    }

    public void addListeners(){
        for(int r=0; r<3; r++){
            for(int c=0; c<3; c++){
                b[r][c].setOnClickListener(new myListener());
            }
        }
    }

    class myListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {

        }
    }
}
