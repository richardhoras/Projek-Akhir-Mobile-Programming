package com.example.binusezyfoody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Order3 extends AppCompatActivity {
    public String oreo="0", taro="0", tango="0", kitKat="0", snackType;
    public int soreo = 0, staro = 0, stango = 0, skitKat = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order3);
        Intent intent = getIntent();
        TextView orderan = findViewById(R.id.teks_orderan);
        orderan.setText(intent.getStringExtra("snacks"));
        snackType = intent.getStringExtra("snacks");
        oreo = intent.getStringExtra("oreo");
        taro = intent.getStringExtra("taro");
        tango = intent.getStringExtra("tango");
        kitKat = intent.getStringExtra("kitKat");
        SQLiteOpenHelper DatabaseHelper = new DatabaseHelper(this);
        SQLiteDatabase db = DatabaseHelper.getReadableDatabase();
        Cursor cursor = db.query("PRODUK",
                new String[] {"STOCK"},
                "TYPE = ?", new String[] {"Snack"}, null, null, null
        );
        cursor.moveToFirst();
        soreo = cursor.getInt(0);
        cursor.moveToNext();
        staro = cursor.getInt(0);
        cursor.moveToNext();
        stango = cursor.getInt(0);
        cursor.moveToNext();
        skitKat = cursor.getInt(0);
        cursor.close();
        db.close();
        TextView stocks = findViewById(R.id.teks_stock);
        if(snackType.equals("Oreo\nRp 123")){
            stocks.setText("Stock: "+soreo);
        }else if(snackType.equals("Taro\nRp 123")){
            stocks.setText("Stock: "+staro);
        }else if(snackType.equals("Tango\nRp 123")){
            stocks.setText("Stock: "+stango);
        }else if(snackType.equals("KitKat\nRp 123")){
            stocks.setText("Stock: "+skitKat);
        }
    }
    public void onClickOrderMore(View view) {
        int lanjut = 0;
        EditText editText = findViewById(R.id.editText);
        if(snackType.equals("Oreo\nRp 123")){
            this.oreo = editText.getText().toString();
            if(this.oreo.equals("")){
                this.oreo = "0";
            }
            if(Integer.parseInt(this.oreo) <= soreo){
                lanjut = 1;
            }
        }else if(snackType.equals("Taro\nRp 123")){
            this.taro = editText.getText().toString();
            if(this.taro.equals("")){
                this.taro = "0";
            }
            if(Integer.parseInt(this.taro) <= staro){
                lanjut = 1;
            }
        }else if(snackType.equals("Tango\nRp 123")){
            this.tango = editText.getText().toString();
            if(this.tango.equals("")){
                this.tango = "0";
            }
            if(Integer.parseInt(this.tango) <= stango){
                lanjut = 1;
            }
        }else if(snackType.equals("KitKat\nRp 123")){
            this.kitKat = editText.getText().toString();
            if(this.kitKat.equals("")){
                this.kitKat = "0";
            }
            if(Integer.parseInt(this.kitKat) <= skitKat){
                lanjut = 1;
            }
        }
        if(lanjut == 1){
            Intent intent = new Intent(this, Snacks.class);
            intent.putExtra("oreo", this.oreo);
            intent.putExtra("taro", this.taro);
            intent.putExtra("tango", this.tango);
            intent.putExtra("kitKat", this.kitKat);
            startActivity(intent);
        }
    }
    public void onClickMyOrder3(View view) {
        int lanjut = 0;
        EditText editText = findViewById(R.id.editText);
        if(snackType.equals("Oreo\nRp 123")){
            this.oreo = editText.getText().toString();
            if(this.oreo.equals("")){
                this.oreo = "0";
            }
            if(Integer.parseInt(this.oreo) <= soreo){
                lanjut = 1;
            }
        }else if(snackType.equals("Taro\nRp 123")){
            this.taro = editText.getText().toString();
            if(this.taro.equals("")){
                this.taro = "0";
            }
            if(Integer.parseInt(this.taro) <= staro){
                lanjut = 1;
            }
        }else if(snackType.equals("Tango\nRp 123")){
            this.tango = editText.getText().toString();
            if(this.tango.equals("")){
                this.tango = "0";
            }
            if(Integer.parseInt(this.tango) <= stango){
                lanjut = 1;
            }
        }else if(snackType.equals("KitKat\nRp 123")){
            this.kitKat = editText.getText().toString();
            if(this.kitKat.equals("")){
                this.kitKat = "0";
            }
            if(Integer.parseInt(this.kitKat) <= skitKat){
                lanjut = 1;
            }
        }
        if(lanjut == 1){
            Intent intent = new Intent(this, MyOrder3.class);
            intent.putExtra("oreo", this.oreo);
            intent.putExtra("taro", this.taro);
            intent.putExtra("tango", this.tango);
            intent.putExtra("kitKat", this.kitKat);
            startActivity(intent);
        }
    }
}