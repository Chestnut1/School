package com.chestnut.app1v3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class TrisActivity extends AppCompatActivity {
    private static final String TAg = "TrisActivity";

    private TextView title;
    private String p1, p2;  //players
    private boolean currentPlayer;
    public int m[][];   //matrice interi

    Button b1,b2,b3,
           b4,b5,b6,
           b7,b8,b9;

    //Button b[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tris);


        //BINDING
        bindCompents();

        //read elements from .puExtra()
        Intent intent = getIntent();
        p1 = intent.getStringExtra("g1");
        p2 = intent.getStringExtra("g2");

        //initialize game
        title.setText(p1 + " VS " + p2);    //select player names
        currentPlayer = true;
        initMatrix(m);

        //LISTENER
        b1.setOnClickListener(new myListener()); b1.setTransitionName("btn_0_0");
        b2.setOnClickListener(new myListener()); b2.setTransitionName("btn_0_1");
        b3.setOnClickListener(new myListener()); b3.setTransitionName("btn_0_2");
        b4.setOnClickListener(new myListener()); b4.setTransitionName("btn_1_0");
        b5.setOnClickListener(new myListener()); b5.setTransitionName("btn_1_1");
        b6.setOnClickListener(new myListener()); b6.setTransitionName("btn_1_2");
        b7.setOnClickListener(new myListener()); b7.setTransitionName("btn_2_0");
        b8.setOnClickListener(new myListener()); b8.setTransitionName("btn_2_1");
        b9.setOnClickListener(new myListener()); b9.setTransitionName("btn_2_2");
    }

    public void bindCompents(){
        title = findViewById(R.id.lblTitolo);
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);
        b9 = findViewById(R.id.button9);
    }

    public void initMatrix(int m[][]){
        m = new int[3][3];      //initialize matrix ti 0
        for(int r = 0; r<3;r++){
            for(int c=0;c<3;c++){
                m[r][c] = 0;
            }
        }
    }

    public class myListener implements View.OnClickListener {
        private static final String TAG = "ClassListener";

        @Override
        public void onClick(View v) {   // v contains the object who triggered the functio
            int x,y;
            boolean win = false;

            Log.e(TAG, "bottone cliccato");
            //getting pressed button id/transition name
            Button buttonPressed = (Button) v;
            Log.i(TAG, String.valueOf(buttonPressed.getTransitionName()));
            x = Integer.parseInt(buttonPressed.getTransitionName().split("_")[1]);
            y = Integer.parseInt(buttonPressed.getTransitionName().split("_")[2]);

            if(currentPlayer){
                m[x][y] = 1;
                currentPlayer = !currentPlayer;
                buttonPressed.setBackgroundResource(R.color.verdeTris);
            }else{
                m[x][y] = 2;
                currentPlayer = !currentPlayer;
                buttonPressed.setBackgroundResource(R.color.rossoTris);
            }

            buttonPressed.setEnabled(false);    //turn off click option of the button

            //CHECK VICTORY
            if(m[0][y] == m[x][y] && m[1][y] == m[x][y] && m[2][y] == m[x][y]){         //vertical chek
                win = true;
            }else if(m[x][0] == m[x][y] && m[x][1]==m[x][y] && m[x][2] == m[x][y]){     //orizontal cheack
                win = true;
            }else if(m[0][0] == m[x][y] && m[1][1] == m[x][y] && m[2][2] == m[x][y]){ //primary diagonal chek
                win = true;
            }else if(m[0][2] == m[x][y] && m[1][1] == m[x][y] && m[2][0] == m[x][y]){ //secondary diagonal check
                win = true;
            }

            if(win){
                if(!currentPlayer){
                    title.setText(p1 + "WIN THE GAME!");
                    winning(p1);
                }else{
                    title.setText(p2 + "WIN THE GAME!");
                    winning(p2);
                }
                blockButtons();
            }

        }
    }

    public void winning(String winner){
        Toast.makeText(this, winner, Toast.LENGTH_LONG).show();
    }

    public void blockButtons(){
        //game finished, block every buttons
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
        b5.setEnabled(false);
        b6.setEnabled(false);
        b7.setEnabled(false);
        b8.setEnabled(false);
        b9.setEnabled(false);

    }

}
