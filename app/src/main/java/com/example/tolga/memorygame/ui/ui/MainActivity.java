package com.example.tolga.memorygame.ui.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.tolga.memorygame.BaseActivity.BaseActivity;
import com.example.tolga.memorygame.R;

public class MainActivity extends BaseActivity implements View.OnClickListener{
    private Button bStart;
    private EditText et;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle instance) {
        super.onCreate(instance);
        setStatusBar(true);
        et  = (EditText) findViewById(R.id.name_edttxt);
        bStart = (Button) findViewById(R.id.btn_start);
        bStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(MainActivity.this, CardsActivity.class);
        i.putExtra("mesaj",et.getText().toString());
        startActivity(i);
    }
}
