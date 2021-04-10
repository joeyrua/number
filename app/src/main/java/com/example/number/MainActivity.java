package com.example.number;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity /*implements DialogInterface.OnKeyListener*/ {
    TextView TV,TV2,TV3;
    Button repeat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TV = findViewById(R.id.t1);
        TV2 = findViewById(R.id.t2);
        TV3 = findViewById(R.id.t3);
        repeat = findViewById(R.id.button);


    }

    private Handler handle = new Handler();
    private Runnable start = new startchange();
    private Runnable stop = new stopchange();

    public void repeat(View v) {
        handle.post(start);
        handle.postDelayed(stop, 5000);
        repeat.setEnabled(false);


    }
    public void next(View v) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, number2.class);
        startActivity(intent);
        finish();
    }


    private class startchange implements Runnable {
        @Override
        public void run() {
            int a = (int) (Math.random() * 10);//0~9
            String a1 = String.valueOf(a);
            TV.setText(a1.toString()+"\n");


            int b = (int) (Math.random() * 99 + 1);//1~99
            String b1 = String.valueOf(b);
            TV2.setText(b1);

            int c = (int) (Math.random() * 99 + 101);//101~199
            String c1 = String.valueOf(c);
            TV3.setText(c1);


        }
    }

    private class stopchange implements Runnable {
        @Override
        public void run() {
            handle.removeCallbacks(start);
            repeat.setEnabled(true);
        }
    }

    public boolean onKeyDown(int KeyCode,KeyEvent event) {
        if (KeyCode == KeyEvent.KEYCODE_BACK) {
            ConfirmExit();
            return true;
        }
        return super.onKeyDown(KeyCode, event);
    }

    public void ConfirmExit() {
        AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);
        ad.setTitle("離開標語");
        ad.setMessage("是否要離開?");
        ad.setNegativeButton("是", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.exit(0);
            }
        }).setPositiveButton("否", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).show();
    }
}
