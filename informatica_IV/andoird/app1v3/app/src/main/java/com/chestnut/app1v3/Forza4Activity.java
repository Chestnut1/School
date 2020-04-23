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

import java.util.Vector;

public class Forza4Activity extends AppCompatActivity {
    private static final String TAG = "Forza 4 acrtivity";

    private final int ROWS = 6;
    private final int COLS = 7;
    private int player = 1;  //true -> 1, false -> 2

    int m[][];
    Button btn[][];

    Vector<Button> vBtn;

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
        vBtn = new Vector<Button>();

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
            vBtn = new Vector<Button>();
            tb0.addView(btn);
        }
        for(int i=0; i<COLS; i++){
            btn = new Button(this);
            btn.setLayoutParams(new ViewGroup.LayoutParams(30, 30));
            btn.setTransitionName("btn_1_"+i);
            btn.setOnClickListener(new myListener());
            vBtn = new Vector<Button>();
            tb1.addView(btn);
        }
        for(int i=0; i<COLS; i++){
            btn = new Button(this);
            btn.setLayoutParams(new ViewGroup.LayoutParams(30, 30));
            btn.setTransitionName("btn_2_"+i);
            btn.setOnClickListener(new myListener());
            vBtn = new Vector<Button>();
            tb2.addView(btn);
        }
        for(int i=0; i<COLS; i++){
            btn = new Button(this);
            btn.setLayoutParams(new ViewGroup.LayoutParams(30, 30));
            btn.setTransitionName("btn_3_"+i);
            btn.setOnClickListener(new myListener());
            vBtn = new Vector<Button>();
            tb3.addView(btn);
        }
        for(int i=0; i<COLS; i++){
            btn = new Button(this);
            btn.setLayoutParams(new ViewGroup.LayoutParams(30, 30));
            btn.setTransitionName("btn_4_"+i);
            btn.setOnClickListener(new myListener());
            vBtn = new Vector<Button>();
            tb4.addView(btn);
        }
        for(int i=0; i<COLS; i++){
            btn = new Button(this);
            btn.setLayoutParams(new ViewGroup.LayoutParams(50, 30));
            btn.setTransitionName("btn_5_"+i);
            btn.setOnClickListener(new myListener());
            vBtn = new Vector<Button>();
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
            boolean trovato = false;
            while(x<ROWS && !trovato){
                if(m[x][y] == 0) x++;
                else trovato = true;
            }
            x--;

            m[x][y] = player;

            //modifica aspetto grafico
            for(int i=0; i<vBtn.size();i++){
                if(vBtn.get(i).getTransitionName().equals(String.valueOf("btn_"+x+"_"+y))){
                    if(player == 1){
                        vBtn.get(i).setBackgroundResource(R.color.coloreRosso);
                        player = 2;
                    }else{
                        vBtn.get(i).setBackgroundResource(R.color.coloreVerdeFigo);
                        player = 1;
                    }
                }
                vBtn.get(i).setEnabled(false);
            }


            //controllo vittoria
            if(controlloOrizzontale(x,y)){
                //vince(gioc,"ORIZZONTALE");
            }else if(controlloVerticale(x,y)){
                //vince(gioc,"VERTICALE");
            }else if(controlloDiagPrinc(x,y)){
                //vince(gioc,"DIAGONALE PRINCIPALE");
            }else if(controlloDiagSec(x,y)){
                //vince(gioc, "DIAGONALE SECONDARIA");
            }
        }


        private boolean controlloOrizzontale(int i, int j){
            int cnt = 1;
            int y = j +1;
            while(y<COLS && m[i][y] == m[i][j]){
                cnt++;
                y++;
            }

            y = j-1;
            while(y >= 0 && m[i][y] == m[i][j]){
                cnt++;
            }

            if(cnt ==4) return true;
            else return false;

        }

        private boolean controlloVerticale(int i, int j){
            int cnt =1;
            int x = i + 1;

            //dal basso in giu'
            while(x < ROWS && m[x][j] == m[i][j]){
                cnt++;
                x++;
            }

            if(cnt == 4) return true;
            else return false;
        }

        private boolean controlloDiagPrinc(int i, int j){
            int cnt = 1;
            int x = i + 1;
            int y = j + 1;

            while(x < ROWS && y < COLS && m[x][y] == m[i][j]){
                cnt++;
                x++;
                y++;
            }

            x = i - 1;
            y = j - 1;
            while(x >= 0 && y >= 0 && m[x][y] == m[i][j]){
                cnt++;
                x--;
                y--;
            }

            if(cnt == 4) return true;
            else return false;
        }

        private boolean controlloDiagSec(int i, int j){
            int cnt = 1;
            int x = i + 1;
            int y = j - 1;

            while(x < ROWS && y >= 0 && m[x][y] == m[i][j]){
                cnt++;
                x++;
                y--;
            }

            x = i - 1;
            y = j + 1;
            while(x >= 0 && y < COLS && m[x][y] == m[i][j]){
                cnt++;
                x--;
                y++;
            }

            if(cnt == 4) return true;
            else return false;
        }
    }
}
