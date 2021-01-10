package com.example.binusezyfoody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MyOrder3 extends AppCompatActivity {
    public String oreo="0", taro="0", tango="0", kitKat="0";
    public int saldos = 0, total = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order3);
        Intent intent = getIntent();
        TextView oreos = findViewById(R.id.oreo);
        TextView taros = findViewById(R.id.taro);
        TextView tangos = findViewById(R.id.tango);
        TextView kitKats = findViewById(R.id.kit_kat);
        TextView totals = findViewById(R.id.total);
        oreo = intent.getStringExtra("oreo");
        taro = intent.getStringExtra("taro");
        tango = intent.getStringExtra("tango");
        kitKat = intent.getStringExtra("kitKat");
        SQLiteOpenHelper DatabaseHelper = new DatabaseHelper(this);
        SQLiteDatabase db = DatabaseHelper.getReadableDatabase();
        Cursor cursor = db.query("WALLET",
                new String[] {"NOMINAL"},
                null, null, null, null, null
        );
        cursor.moveToFirst();
        saldos = cursor.getInt(0);
        cursor.close();
        db.close();
        TextView saldo = findViewById(R.id.teks_saldo);
        saldo.setText("Saldo: "+saldos+",00");
        if(oreo != null){
            total = total + Integer.parseInt(oreo);
            oreos.setText("Oreo\n" + intent.getStringExtra("oreo") + " x Rp 123");
        }else{
            oreos.setText("Oreo\n0 x Rp 123");
        }
        if(taro != null){
            total = total + Integer.parseInt(taro);
            taros.setText("Taro\n" + intent.getStringExtra("taro") + " x Rp 123");
        }else{
            taros.setText("Taro\n0 x Rp 123");
        }
        if(tango != null){
            total = total + Integer.parseInt(tango);
            tangos.setText("Tango\n" + intent.getStringExtra("tango") + " x Rp 123");
        }else{
            tangos.setText("Tango\n0 x Rp 123");
        }
        if(kitKat != null){
            total = total + Integer.parseInt(kitKat);
            kitKats.setText("KitKat\n" + intent.getStringExtra("kitKat") + " x Rp 123");
        }else{
            kitKats.setText("KitKat\n0 x Rp 123");
        }
        total = total * 123;
        totals.setText("Total: Rp. " + total + ",00");
    }
    public void onClickPayNow(View view) {
        if(total <= saldos){
            SQLiteOpenHelper DatabaseHelper = new DatabaseHelper(this);
            SQLiteDatabase dbs = DatabaseHelper.getWritableDatabase();
            updateWallet(dbs, saldos, total);
            dbs.close();
            Intent intent = new Intent(this, OrderComplete3.class);
            intent.putExtra("oreo", this.oreo);
            intent.putExtra("taro", this.taro);
            intent.putExtra("tango", this.tango);
            intent.putExtra("kitKat", this.kitKat);
            startActivity(intent);
        }
    }
    public void onClickHapus1(View view) {
        Intent intent = new Intent(this, MyOrder3.class);
        intent.putExtra("oreo", "0");
        intent.putExtra("taro", this.taro);
        intent.putExtra("tango", this.tango);
        intent.putExtra("kitKat", this.kitKat);
        startActivity(intent);
    }
    public void onClickHapus2(View view) {
        Intent intent = new Intent(this, MyOrder3.class);
        intent.putExtra("oreo", this.oreo);
        intent.putExtra("taro", "0");
        intent.putExtra("tango", this.tango);
        intent.putExtra("kitKat", this.kitKat);
        startActivity(intent);
    }
    public void onClickHapus3(View view) {
        Intent intent = new Intent(this, MyOrder3.class);
        intent.putExtra("oreo", this.oreo);
        intent.putExtra("taro", this.taro);
        intent.putExtra("tango", "0");
        intent.putExtra("kitKat", this.kitKat);
        startActivity(intent);
    }
    public void onClickHapus4(View view) {
        Intent intent = new Intent(this, MyOrder3.class);
        intent.putExtra("oreo", this.oreo);
        intent.putExtra("taro", this.taro);
        intent.putExtra("tango", this.tango);
        intent.putExtra("kitKat", "0");
        startActivity(intent);
    }
    private static void updateWallet(SQLiteDatabase dbs, int saldos, int totals) {
        ContentValues walletValues = new ContentValues();
        walletValues.put("NOMINAL", (saldos - totals));
        dbs.update("WALLET", walletValues,"NAME = ?", new String[] {"user1"} );
    }
}