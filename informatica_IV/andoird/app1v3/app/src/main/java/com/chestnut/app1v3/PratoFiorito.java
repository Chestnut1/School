package com.chestnut.app1v3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TableRow;
import android.widget.TextView;

import java.security.KeyStore;
import java.util.Random;
import java.util.Vector;

public class PratoFiorito extends AppCompatActivity {
    private static final int BOMBS = 10;
    private static final int ROWS = 9;
    private static final int COLS = 9;
    private static final String TAG = "PratoFioritoActivity";

    TableRow tbR0, tbR1, tbR2, tbR3, tbR4, tbR5, tbR6, tbR7, tbR8;
    ImageButton btn;
    Vector<ImageButton> vBtn;
    int m[][];
    int ctnClicked = (ROWS*COLS) - BOMBS;
    TextView title;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prato_fiorito);

        //initializing matrix to 0
        m = new int[ROWS][COLS];
        for(int r = 0; r < ROWS; r++){
            for (int c = 0; c < COLS; c++){
                m[r][c] = 0;
            }
        }

        bindComponents();

        //setting player name
        Intent intent;
        intent = getIntent();
        title.setText("Benvenuto, " + intent.getStringExtra("g1"));

    }

    void bindComponents(){
        tbR0 = findViewById(R.id.tbR0);
        tbR1 = findViewById(R.id.tbR1);
        tbR2 = findViewById(R.id.tbR2);
        tbR3 = findViewById(R.id.tbR3);
        tbR4 = findViewById(R.id.tbR4);
        tbR5 = findViewById(R.id.tbR5);
        tbR6 = findViewById(R.id.tbR6);
        tbR7 = findViewById(R.id.tbR7);
        tbR8 = findViewById(R.id.tbR8);
        reset = findViewById(R.id.resetButton);
        title = findViewById(R.id.title);

        //initialize vBtn
        vBtn = new Vector<ImageButton>();

        //add buttons to rows
        for (int i =0; i < ROWS; i++){
            for(int k = 0; k < COLS; k++){
                btn = new ImageButton(this);
                btn.setTransitionName("btn_" + i + "_" + k);
                btn.setOnClickListener(new MyListener());
                btn.setImageResource(R.drawable.ic_fiore);
                vBtn.add(btn);

                switch(i){
                    case 0:
                        tbR0.addView(btn);
                        break;
                    case 1:
                        tbR1.addView(btn);
                        break;
                    case 2:
                        tbR2.addView(btn);
                        break;
                    case 3:
                        tbR3.addView(btn);
                        break;
                    case 4:
                        tbR4.addView(btn);
                        break;
                    case 5:
                        tbR5.addView(btn);
                        break;
                    case 6:
                        tbR6.addView(btn);
                        break;
                    case 7:
                        tbR7.addView(btn);
                        break;
                    case 8:
                        tbR8.addView(btn);
                        break;
                    default:
                        break;
                }
            }
        }

        //randomize bombs bombs
        Random rnd;
        rnd = new Random();
        int xr,yr;
        for(int i =0; i < BOMBS; i+=0){
            xr = rnd.nextInt(ROWS);
            yr = rnd.nextInt(COLS);
            if(m[xr][yr] == 0){
                m[xr][yr] = -1;
                i++;
            }
        }

        //computing near bombs
        int ctn = 0;
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(m[r][c] != -1) {
                    //up left
                    if(r != 0 && c != 0 && m[r-1][c-1] == -1) ctn++;
                    //up
                    if(r != 0 && m[r-1][c] == -1) ctn++;
                    //up right
                    if(r != 0 && c != COLS-1 && m[r-1][c+1] == -1) ctn++;
                    //lef
                    if(c != 0 && m[r][c-1] == -1) ctn++;
                    //right
                    if(c != COLS -1 && m[r][c+1] == -1) ctn++;
                    //down left
                    if(r != ROWS-1 && c != 0 && m[r+1][c-1] == -1) ctn++;
                    //down
                    if(r != ROWS-1 && m[r+1][c] == -1) ctn++;
                    //down right
                    if(r != ROWS-1 && c != COLS-1 && m[r+1][c+1] == -1) ctn++;
                    m[r][c] = ctn;
                    ctn = 0;
                }
            }
        }

    }


    class MyListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            ImageButton b = (ImageButton) v;
            int x,y;
            x = Integer.parseInt(b.getTransitionName().split("_")[1]);
            y = Integer.parseInt(b.getTransitionName().split("_")[2]);

            boolean found = false;
            for(int i =0; i<vBtn.size() && !found; i++){
                if(vBtn.elementAt(i).getTransitionName().equals("btn_" + x + "_" + y)){
                    found = true;
                    switch (m[x][y]){
                        case -1:
                            vBtn.elementAt(i).setImageResource(R.drawable.ic_b);
                            perso();
                            break;
                        case 0:
                            vBtn.elementAt(i).setImageResource(R.drawable.ic_0);
                            break;
                        case 1:
                            vBtn.elementAt(i).setImageResource(R.drawable.ic_1);
                            break;
                        case 2:
                            vBtn.elementAt(i).setImageResource(R.drawable.ic_2);
                            break;
                        case 3:
                            vBtn.elementAt(i).setImageResource(R.drawable.ic_3);
                            break;
                        case 4:
                            vBtn.elementAt(i).setImageResource(R.drawable.ic_4);
                            break;
                        case 5:
                            vBtn.elementAt(i).setImageResource(R.drawable.ic_5);
                            break;
                        case 6:
                            vBtn.elementAt(i).setImageResource(R.drawable.ic_6);
                            break;
                        case 7:
                            vBtn.elementAt(i).setImageResource(R.drawable.ic_7);
                            break;
                        case 8:
                            vBtn.elementAt(i).setImageResource(R.drawable.ic_8);
                            break;
                        default:
                            break;
                    }
                    vBtn.elementAt(i).setEnabled(false);
                    ctnClicked -= 1 ;


                }
            }

            if(ctnClicked == 0){
                vittoria();
            }


        }
    }

    void perso(){

    }

    void vittoria(){

    }
}
