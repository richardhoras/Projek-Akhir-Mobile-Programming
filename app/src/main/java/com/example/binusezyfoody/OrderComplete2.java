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

public class OrderComplete2 extends AppCompatActivity {
    public String nasiCampur="0", ayamGoreng="0", nasiUduk="0", ayamRebus="0";
    public int snasiCampur = 0, sayamGoreng = 0, sayamBakar = 0, sayamRebus = 0, saldos = 0, total = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete2);
        Intent intent = getIntent();
        TextView nasiCampurs = findViewById(R.id.nasi_campur);
        TextView ayamGorengs = findViewById(R.id.ayam_goreng);
        TextView nasiUduks = findViewById(R.id.ayam_bakar);
        TextView ayamRebuss = findViewById(R.id.ayam_rebus);
        TextView totals = findViewById(R.id.total);
        nasiCampur = intent.getStringExtra("nasiCampur");
        ayamGoreng = intent.getStringExtra("ayamGoreng");
        nasiUduk = intent.getStringExtra("nasiUduk");
        ayamRebus = intent.getStringExtra("ayamRebus");
        SQLiteOpenHelper DatabaseHelpers = new DatabaseHelper(this);
        SQLiteDatabase dbz = DatabaseHelpers.getReadableDatabase();
        Cursor c = dbz.query("WALLET",
                new String[] {"NOMINAL"},
                null, null, null, null, null
        );
        c.moveToFirst();
        saldos = c.getInt(0);
        c.close();
        dbz.close();
        TextView saldo = findViewById(R.id.teks_saldo);
        saldo.setText("Saldo: "+saldos+",00");
        SQLiteOpenHelper DatabaseHelper = new DatabaseHelper(this);
        SQLiteDatabase db = DatabaseHelper.getReadableDatabase();
        Cursor cursor = db.query("PRODUK",
                new String[] {"STOCK"},
                "TYPE = ?", new String[] {"Food"}, null, null, null
        );
        cursor.moveToFirst();
        snasiCampur = cursor.getInt(0);
        cursor.moveToNext();
        sayamGoreng = cursor.getInt(0);
        cursor.moveToNext();
        sayamBakar = cursor.getInt(0);
        cursor.moveToNext();
        sayamRebus = cursor.getInt(0);
        cursor.close();
        db.close();
        SQLiteOpenHelper DatabaseHelperk = new DatabaseHelper(this);
        SQLiteDatabase dbs = DatabaseHelperk.getWritableDatabase();
        int updateds = 0;
        if(nasiCampur!=null){
            total = total + Integer.parseInt(nasiCampur);
            nasiCampurs.setText("Nasi Campur\n" + intent.getStringExtra("nasiCampur") + " x Rp 123");
            updateFoods(dbs, "nasiCampur", snasiCampur, Integer.parseInt(nasiCampur));
            updateds = 1;
        }else{
            nasiCampur = "0";
            nasiCampurs.setText("Nasi Campur\n0 x Rp 123");
        }
        if(ayamGoreng != null){
            total = total + Integer.parseInt(ayamGoreng);
            ayamGorengs.setText("Ayam Goreng\n" + intent.getStringExtra("ayamGoreng") + " x Rp 123");
            updateFoods(dbs, "Ayam Goreng", sayamGoreng, Integer.parseInt(ayamGoreng));
            updateds = 1;
        }else{
            ayamGoreng = "0";
            ayamGorengs.setText("Ayam Goreng\n0 x Rp 123");
        }
        if(nasiUduk != null){
            total = total + Integer.parseInt(nasiUduk);
            nasiUduks.setText("Ayam Bakar\n" + intent.getStringExtra("nasiUduk") + " x Rp 123");
            updateFoods(dbs, "Ayam Bakar", sayamBakar, Integer.parseInt(nasiUduk));
            updateds = 1;
        }else{
            nasiUduk = "0";
            nasiUduks.setText("Ayam Bakar\n0 x Rp 123");
        }
        if(ayamRebus != null){
            total = total + Integer.parseInt(ayamRebus);
            ayamRebuss.setText("Ayam Rebus\n" + intent.getStringExtra("ayamRebus") + " x Rp 123");
            updateFoods(dbs, "Ayam Rebus", sayamRebus, Integer.parseInt(ayamRebus));
            updateds = 1;
        }else{
            ayamRebus = "0";
            ayamRebuss.setText("Ayam Rebus\n0 x Rp 123");
        }
        if(updateds == 1){
            insertHistory(dbs, "Food", "nasiCampur", 123, Integer.parseInt(nasiCampur), "Ayam Goreng", 123, Integer.parseInt(ayamGoreng), "Ayam Bakar", 123, Integer.parseInt(nasiUduk), "Ayam Rebus", 123, Integer.parseInt(ayamRebus), "dummy");
        }
        dbs.close();
        total = total * 123;
        totals.setText("Total: Rp. " + total + ",00");
    }
    public void onClickMainMenu(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    private static void updateFoods(SQLiteDatabase dbs, String name, int stock, int quantity) {
        ContentValues foodValues = new ContentValues();
        foodValues.put("STOCK", (stock - quantity));
        dbs.update("PRODUK", foodValues,"NAME = ?", new String[] {name});
    }
    private static void insertHistory(SQLiteDatabase db, String type, String name1, int price1, int quantity1, String name2, int price2, int quantity2, String name3, int price3, int quantity3, String name4, int price4, int quantity4, String address) {
        ContentValues historyValues = new ContentValues();
        historyValues.put("TYPE", type);
        historyValues.put("NAME1", name1);
        historyValues.put("PRICE1", price1);
        historyValues.put("QUANTITY1", quantity1);
        historyValues.put("NAME2", name2);
        historyValues.put("PRICE2", price2);
        historyValues.put("QUANTITY2", quantity2);
        historyValues.put("NAME3", name3);
        historyValues.put("PRICE3", price3);
        historyValues.put("QUANTITY3", quantity3);
        historyValues.put("NAME4", name4);
        historyValues.put("PRICE4", price4);
        historyValues.put("QUANTITY4", quantity4);
        historyValues.put("ADDRESS", address);
        db.insert("HISTORY", null, historyValues);
    }
}