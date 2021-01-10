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

public class Order2 extends AppCompatActivity {
    public String nasiCampur="0", ayamGoreng="0", ayamBakar="0", ayamRebus="0", foodType;
    public int snasiCampur = 0, sAyam = 0, sNasi = 0, sPecel = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order2);
        Intent intent = getIntent();
        TextView orderan = findViewById(R.id.teks_orderan);
        orderan.setText(intent.getStringExtra("foods"));
        foodType = intent.getStringExtra("foods");
        nasiCampur = intent.getStringExtra("nasiCampur");
        ayamGoreng = intent.getStringExtra("ayamGoreng");
        ayamBakar = intent.getStringExtra("ayamBakar");
        ayamRebus = intent.getStringExtra("ayamRebus");
        SQLiteOpenHelper DatabaseHelper = new DatabaseHelper(this);
        SQLiteDatabase db = DatabaseHelper.getReadableDatabase();
        Cursor cursor = db.query("PRODUK",
                new String[] {"STOCK"},
                "TYPE = ?", new String[] {"Food"}, null, null, null
        );
        cursor.moveToFirst();
        snasiCampur = cursor.getInt(0);
        cursor.moveToNext();
        sAyam = cursor.getInt(0);
        cursor.moveToNext();
        sNasi = cursor.getInt(0);
        cursor.moveToNext();
        sPecel = cursor.getInt(0);
        cursor.close();
        db.close();
        TextView stocks = findViewById(R.id.teks_stock);
        if(foodType.equals("nasiCampur\nRp 123")){
            stocks.setText("Stock: "+snasiCampur);
        }else if(foodType.equals("Ayam Geprek\nRp 123")){
            stocks.setText("Stock: "+sAyam);
        }else if(foodType.equals("Nasi Uduk\nRp 123")){
            stocks.setText("Stock: "+sNasi);
        }else if(foodType.equals("Ayam Rebus\nRp 123")){
            stocks.setText("Stock: "+sPecel);
        }
    }
    public void onClickOrderMore(View view) {
        int lanjut = 0;
        EditText editText = findViewById(R.id.editText);
        if(foodType.equals("nasiCampur\nRp 123")){
            this.nasiCampur = editText.getText().toString();
            if(this.nasiCampur.equals("")){
                this.nasiCampur = "0";
            }
            if(Integer.parseInt(this.nasiCampur) <= snasiCampur){
                lanjut = 1;
            }
        }else if(foodType.equals("Ayam Geprek\nRp 123")){
            this.ayamGoreng = editText.getText().toString();
            if(this.ayamGoreng.equals("")){
                this.ayamGoreng = "0";
            }
            if(Integer.parseInt(this.ayamGoreng) <= sAyam){
                lanjut = 1;
            }
        }else if(foodType.equals("Nasi Uduk\nRp 123")){
            this.ayamBakar = editText.getText().toString();
            if(this.ayamBakar.equals("")){
                this.ayamBakar = "0";
            }
            if(Integer.parseInt(this.ayamBakar) <= sNasi){
                lanjut = 1;
            }
        }else if(foodType.equals("Ayam Rebus\nRp 123")){
            this.ayamRebus = editText.getText().toString();
            if(this.ayamRebus.equals("")){
                this.ayamRebus = "0";
            }
            if(Integer.parseInt(this.ayamRebus) <= sPecel){
                lanjut = 1;
            }
        }
        if(lanjut == 1){
            Intent intent = new Intent(this, Foods.class);
            intent.putExtra("nasiCampur", this.nasiCampur);
            intent.putExtra("ayamGoreng", this.ayamGoreng);
            intent.putExtra("ayamBakar", this.ayamBakar);
            intent.putExtra("ayamRebus", this.ayamRebus);
            startActivity(intent);
        }
    }
    public void onClickMyOrder2(View view) {
        int lanjut = 0;
        EditText editText = findViewById(R.id.editText);
        if(foodType.equals("Nasi Campur\nRp 123")){
            this.nasiCampur = editText.getText().toString();
            if(this.nasiCampur.equals("")){
                this.nasiCampur = "0";
            }
            if(Integer.parseInt(this.nasiCampur) <= snasiCampur){
                lanjut = 1;
            }
        }else if(foodType.equals("Ayam Goreng\nRp 123")){
            this.ayamGoreng = editText.getText().toString();
            if(this.ayamGoreng.equals("")){
                this.ayamGoreng = "0";
            }
            if(Integer.parseInt(this.ayamGoreng) <= sAyam){
                lanjut = 1;
            }
        }else if(foodType.equals("Ayam Bakar\nRp 123")){
            this.ayamBakar = editText.getText().toString();
            if(this.ayamBakar.equals("")){
                this.ayamBakar = "0";
            }
            if(Integer.parseInt(this.ayamBakar) <= sNasi){
                lanjut = 1;
            }
        }else if(foodType.equals("Ayam Rebus\nRp 123")){
            this.ayamRebus = editText.getText().toString();
            if(this.ayamRebus.equals("")){
                this.ayamRebus = "0";
            }
            if(Integer.parseInt(this.ayamRebus) <= sPecel){
                lanjut = 1;
            }
        }
        if(lanjut == 1){
            Intent intent = new Intent(this, MyOrder2.class);
            intent.putExtra("nasiCampur", this.nasiCampur);
            intent.putExtra("ayamGoreng", this.ayamGoreng);
            intent.putExtra("ayamBakar", this.ayamBakar);
            intent.putExtra("ayamRebus", this.ayamRebus);
            startActivity(intent);
        }
    }
}