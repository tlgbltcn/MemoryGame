package com.example.tolga.memorygame.ui.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatDrawableManager;
import android.widget.Button;

import com.example.tolga.memorygame.R;


public class Cards extends Button {
    boolean copen = false;
    boolean noChange= true;
    int backroundID;
    int frontID = 0;
    Drawable drear;
    Drawable dfront;





    public Cards (Context context,int id) {
        super(context);
        setId(id);
        backroundID = R.drawable.back;


        if (id%14==0) {
            frontID = R.drawable.d1 ;
        }
        if (id%14==1) {
            frontID = R.drawable.d2;
        }
        if (id%14==2) {
            frontID = R.drawable.d3;
        }
        if (id%14==3) {
            frontID = R.drawable.d4;
        }
        if (id%14==4) {
            frontID = R.drawable.d5;
        }
        if (id%14==5) {
            frontID = R.drawable.d6;
        }
        if (id%14==6) {
            frontID = R.drawable.d7;
        }
        if (id%14==7) {
            frontID = R.drawable.d8;
        }

        if (id%14==8) {
            frontID = R.drawable.d9;
        }

        if (id%14==9) {
            frontID = R.drawable.d10;
        }

        if (id%14==10) {
            frontID = R.drawable.d11;
        }

        if (id%14==11) {
            frontID = R.drawable.d12;
        }


        if (id%14==12) {
            frontID = R.drawable.d13;
        }

        if (id%14==13) {
            frontID = R.drawable.d14;
        }


        drear = AppCompatDrawableManager.get().getDrawable(context,backroundID);
        dfront = AppCompatDrawableManager.get().getDrawable(context,frontID);
        setBackground(drear);


    }

    public void change(){
        if(noChange){
            if (!copen){
                setBackground(dfront);
                copen = true;
            }else{
                setBackground(drear);
                copen = false;
            }
        }
    }
}
