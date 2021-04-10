package com.example.number;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class number2 extends AppCompatActivity implements View.OnClickListener {
    EditText ET1, ET2;
    TextView TV;
    Button st;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number2);
        ET1 = findViewById(R.id.editText);
        ET2 = findViewById(R.id.editText2);
        TV = findViewById(R.id.result);
        st = findViewById(R.id.button3);
        st.setOnClickListener(this);
    }
    public  void back(View v) {
        Intent intent = new Intent();
        intent.setClass(number2.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void next(View v) {
        Intent intent = new Intent();
        intent.setClass(number2.this, number3.class);
        startActivity(intent);
        finish();
    }

    private Handler handle = new Handler();
    private Runnable start = new startchange();
    private Runnable stop = new stopchange();

    @Override
    public void onClick(View v) {

        String a, b;
        a = ET1.getText().toString();
        b = ET2.getText().toString();
        if (v.getId() == R.id.button3) {
            if (a.trim().equals("") || b.trim().equals("")) {
                Toast.makeText(this, "請務必輸入值", Toast.LENGTH_LONG).show();
                TV.setText("");
            } else {
                int a1 = Integer.parseInt(a);//low
                int b1 = Integer.parseInt(b);//high
                int c = (int)(Math.random()*(b1-a1+1)+a1) ;//(int) (Math.random() * (high - low + 1) + low) low到high亂數（含high）
                String c1 = String.valueOf(c);
                if (a1 > b1) {
                    Toast.makeText(this, "第一個值不能大於第二個值，請重新輸入", Toast.LENGTH_LONG).show();
                    TV.setText("");
                }
                else if (a1 <0  || b1<0 ) {
                    Toast.makeText(this, "輸入的值不能為負數，請重新輸入", Toast.LENGTH_LONG).show();
                    TV.setText("");
                }
                else if (a1 ==0 || b1==0) {
                    Toast.makeText(this, "輸入的值不能為0，請重新輸入", Toast.LENGTH_LONG).show();
                    TV.setText("");
                }
                else if(a1==b1){
                    Toast.makeText(this,"第一個值與第二個值不能相同，請重新輸入",Toast.LENGTH_LONG).show();
                    TV.setText("");
                }
                else {
                    TV.setText("恭喜" + c1 + "號得到筆電一台");

                }
            }


        }

    }

    private class startchange implements Runnable {
        @Override
        public void run() {

        }
    }

    private class stopchange implements Runnable {
        @Override
        public void run() {

        }
    }

    public boolean onKeyDown(int KeyCode , KeyEvent event) {
        if (KeyCode == KeyEvent.KEYCODE_BACK) {
            return false;
        }
        return super.onKeyDown(KeyCode, event);
    }
}
