package com.example.tolga.memorygame.ui.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tolga.memorygame.R;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {
    private String s;
    private String name;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent ifinish = getIntent();
        s = ifinish.getStringExtra("score");
        name = ifinish.getStringExtra("name");
        TextView txt = (TextView) findViewById(R.id.try_txt);
        txt.setText("You tried it " +s+ " times");

        btn = (Button) findViewById(R.id.btn_restart);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent i = new Intent(ResultActivity.this, CardsActivity.class);
        i.putExtra("mesaj",name);
        startActivity(i);
    }
}
