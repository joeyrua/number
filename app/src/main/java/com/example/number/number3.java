package com.example.number;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class number3 extends AppCompatActivity {
    SQLiteDatabase db;
    static final String db_name = "names";
    static final String tb_name = "tb_names";
    EditText name;
    Cursor c;
    TextView TV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number3);
        name = findViewById(R.id.editText3);
        TV = findViewById(R.id.show);
        db = openOrCreateDatabase(db_name, Context.MODE_PRIVATE, null);
        String DBTable = " CREATE  TABLE IF NOT EXISTS " + tb_name + "(_id INTEGER PRIMARY KEY AUTOINCREMENT," + "name VARCH(32))";
        db.execSQL(DBTable);
    }
    public void add(View v) {
        ContentValues cv = new ContentValues(1);
        cv.put("name",name.getText().toString());
        db.insert(tb_name, null, cv);//輸入資料

        c = db.rawQuery("SELECT * FROM " + tb_name, null);//搜尋資料
        String str = "";


            c.moveToFirst();
            do {
                str += c.getString(1)+ "\n";

            }
            while (c.moveToNext());

            TV.setText(str);




    }
    public void del(View v) {
        String sql = "DELETE FROM tb_names where name = '" + name.getText().toString() + "'";
        db.execSQL(sql);

        c = db.rawQuery("SELECT * FROM " + tb_name, null);//搜尋資料
        String str = "";

        c.moveToFirst();
        do {
            str += c.getString(1)+ "\n";
        }
        while (c.moveToNext());
        TV.setText(str);
    }
    public void back(View v) {
        Intent intent = new Intent();
        intent.setClass(number3.this, number2.class);
        startActivity(intent);
        finish();
    }
    public void  next(View v) {
        Intent intent = new Intent();
        intent.setClass(number3.this, number4.class);

        c = db.rawQuery("SELECT * FROM " + tb_name, null);//搜尋資料
        String str = "";
        c.moveToFirst();
        do {
            str += c.getString(1)+ "\t";
        }
        while (c.moveToNext());

        Bundle bundle = new Bundle();
        bundle.putString("Name",str);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }
    public boolean onKeyDown(int KeyCode , KeyEvent event) {
        if (KeyCode == KeyEvent.KEYCODE_BACK) {
            return false;
        }
        return super.onKeyDown(KeyCode, event);
    }
}
