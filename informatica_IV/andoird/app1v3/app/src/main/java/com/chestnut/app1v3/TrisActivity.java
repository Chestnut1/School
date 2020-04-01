package com.chestnut.app1v3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.Random;

public class TrisActivity extends AppCompatActivity {
    private TextView title;
    private String p1, p2;  //players
    private int currentPlayer = 0;
    private TableLayout grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tris);

        //BINDING
        title = findViewById(R.id.lblTitolo);
        grid = findViewById(R.id.grid);
        //read elements from .puExtra()
        Intent intent = getIntent();
        p1 = intent.getStringExtra("g1");
        p2 = intent.getStringExtra("g2");

        //set the title based on the start
        title.setText(p1 + " VS " + p2);
    }
}
