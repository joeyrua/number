package com.example.number;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.jar.Attributes;

public class number4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number4);
        TextView db = findViewById(R.id.db);
        final TextView result = findViewById(R.id.result1);
        Button ra = findViewById(R.id.random1);
        Button back = findViewById(R.id.back2);

        final Bundle bundle = this.getIntent().getExtras();
        final String str = bundle.getString("Name");
        db.setText(str);

       // final String[] myNames = {"a","b","c","d"};


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(number4.this,number3.class);
                startActivity(intent);
                finish();
            }
        });
        /*ra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int rando = (int) (Math.random() * 4);
                result.setText(myNames[rando]);
            }
        });*/
    }

    public boolean onKeyDown(int KeyCode , KeyEvent event) {
        if (KeyCode == KeyEvent.KEYCODE_BACK) {
            return false;
        }
        return super.onKeyDown(KeyCode, event);
    }

}
