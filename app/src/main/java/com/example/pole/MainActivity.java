package com.example.pole;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements MainActivity2 {

    private Integer counter = 0;
    private Integer counter1 = 0;


    private static final String TAG = "MainActivity";


    @Override
    protected void onResume() {
        super.onResume();
        resetUI();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void onClickBtnAddCont(View view) {


        counter++;

        TextView counterView = findViewById(R.id.txt_counter);
        counterView.setText(counter.toString());
    }


    public void onClickBtnAddCont1(View view) {
        counter1++;
        TextView counterView = findViewById(R.id.txt_counter1);
        counterView.setText(counter1.toString());
    }



    public void onClickButtonClear(View view) {
        counter = 0;
        counter1 = 0;

        resetUI();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter", counter);
        outState.putInt("counter1", counter1);
        Log.d(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("counter")) {
            counter = savedInstanceState.getInt("counter");
        }
        if ((savedInstanceState != null && savedInstanceState.containsKey("counter1"))) {
            counter1 = savedInstanceState.getInt("counter1");
        }
        Log.d(TAG, "onRestoreInstanceState");
    }
    private void resetUI() {
        ((TextView) findViewById(R.id.txt_counter)).setText(counter.toString());
        Log.d(TAG, "resetUI");
        ((TextView) findViewById(R.id.txt_counter1)).setText(counter1.toString());
        Log.d(TAG, "resetUI");
    }
}
