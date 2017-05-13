package com.example.tolga.memorygame.ui.ui;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import com.example.tolga.memorygame.R;

public class CardsActivity extends AppCompatActivity{
    int cmatch = 0;
    int score =0;
    int crash=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);

        Intent i = getIntent();
        String s = i.getStringExtra("mesaj");
        TextView txt = (TextView) findViewById(R.id.textView);
        txt.setText("Welcome "+ s);

        GridLayout g = (GridLayout) findViewById(R.id.gridLayout);
        Cards cc[] = new Cards[28];
        for (int j=1; j<=28; j++){

            cc[j-1] = new Cards(this, j);
            cc[j-1].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Cards k = (Cards)v;

                    if (cmatch>0){
                        final Cards k2 = (Cards) findViewById(cmatch);

                        if (k2.frontID==k.frontID&&k2.getId()!=k.getId()){
                            k2.noChange=false;
                            k.noChange=false;

                            if (score==14){

                                Intent ifinish = new Intent(CardsActivity.this, ResultActivity.class);
                                startActivity(ifinish);
                            }

                        }else{
                            Handler h = new Handler();
                            h.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    k.change();
                                    k2.change();
                                }
                            },500);
                            crash++;
                            cmatch = 0;
                        }
                    }else{
                        cmatch= k.getId();
                    }
                }
            });

        }
        for (int j=0; j<28; j++){
            int rg = (int) (Math.random()*28);
            Cards c = cc [rg];
            cc [rg] = cc [j];
            cc[j]= c;
        }

        for (int j=0; j<28; j++) {
            g.addView(cc[j]);
        }

    }

}
