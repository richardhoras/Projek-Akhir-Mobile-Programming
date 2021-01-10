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

public class MyOrder2 extends AppCompatActivity {
    public String nasiCampur="0", ayamGoreng="0", ayamBakar="0", ayamRebus="0";
    public int saldos = 0, total = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order2);
        Intent intent = getIntent();
        TextView nasiCampurs = findViewById(R.id.nasi_campur);
        TextView ayamGorengs = findViewById(R.id.ayam_goreng);
        TextView ayamBakars = findViewById(R.id.ayam_bakar);
        TextView ayamRebuss = findViewById(R.id.ayam_rebus);
        TextView totals = findViewById(R.id.total);
        nasiCampur = intent.getStringExtra("nasiCampur");
        ayamGoreng = intent.getStringExtra("ayamGoreng");
        ayamBakar = intent.getStringExtra("ayamBakar");
        ayamRebus = intent.getStringExtra("ayamRebus");
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
        if(nasiCampur != null){
            total = total + Integer.parseInt(nasiCampur);
            nasiCampurs.setText("Nasi Campur\n" + intent.getStringExtra("nasiCampur") + " x Rp 123");
        }else{
            nasiCampurs.setText("Nasi Campur\n0 x Rp 123");
        }
        if(ayamGoreng != null){
            total = total + Integer.parseInt(ayamGoreng);
            ayamGorengs.setText("Ayam Geprek\n" + intent.getStringExtra("ayamGoreng") + " x Rp 123");
        }else{
            ayamGorengs.setText("Ayam Geprek\n0 x Rp 123");
        }
        if(ayamBakar != null){
            total = total + Integer.parseInt(ayamBakar);
            ayamBakars.setText("Nasi Uduk\n" + intent.getStringExtra("ayamBakar") + " x Rp 123");
        }else{
            ayamBakars.setText("Nasi Uduk\n0 x Rp 123");
        }
        if(ayamRebus != null){
            total = total + Integer.parseInt(ayamRebus);
            ayamRebuss.setText("Ayam Rebus\n" + intent.getStringExtra("ayamRebus") + " x Rp 123");
        }else{
            ayamRebuss.setText("Ayam Rebus\n0 x Rp 123");
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
            Intent intent = new Intent(this, OrderComplete2.class);
            intent.putExtra("nasiCampur", this.nasiCampur);
            intent.putExtra("ayamGoreng", this.ayamGoreng);
            intent.putExtra("ayamBakar", this.ayamBakar);
            intent.putExtra("ayamRebus", this.ayamRebus);
            startActivity(intent);
        }
    }
    public void onClickHapus1(View view) {
        Intent intent = new Intent(this, MyOrder2.class);
        intent.putExtra("nasiCampur", "0");
        intent.putExtra("ayamGoreng", this.ayamGoreng);
        intent.putExtra("ayamBakar", this.ayamBakar);
        intent.putExtra("ayamRebus", this.ayamRebus);
        startActivity(intent);
    }
    public void onClickHapus2(View view) {
        Intent intent = new Intent(this, MyOrder2.class);
        intent.putExtra("nasiCampur", this.nasiCampur);
        intent.putExtra("ayamGoreng", "0");
        intent.putExtra("ayamBakar", this.ayamBakar);
        intent.putExtra("ayamRebus", this.ayamRebus);
        startActivity(intent);
    }
    public void onClickHapus3(View view) {
        Intent intent = new Intent(this, MyOrder2.class);
        intent.putExtra("nasiCampur", this.nasiCampur);
        intent.putExtra("ayamGoreng", this.ayamGoreng);
        intent.putExtra("ayamBakar", "0");
        intent.putExtra("ayamRebus", this.ayamRebus);
        startActivity(intent);
    }
    public void onClickHapus4(View view) {
        Intent intent = new Intent(this, MyOrder2.class);
        intent.putExtra("nasiCampur", this.nasiCampur);
        intent.putExtra("ayamGoreng", this.ayamGoreng);
        intent.putExtra("ayamBakar", this.ayamBakar);
        intent.putExtra("ayamRebus", "0");
        startActivity(intent);
    }
    private static void updateWallet(SQLiteDatabase dbs, int saldos, int totals) {
        ContentValues walletValues = new ContentValues();
        walletValues.put("NOMINAL", (saldos - totals));
        dbs.update("WALLET", walletValues,"NAME = ?", new String[] {"user1"} );
    }
}