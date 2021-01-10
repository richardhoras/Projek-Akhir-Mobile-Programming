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
public class MyOrder extends AppCompatActivity {
    public String airMineral="0", jusApel="0", jusMangga="0", jusAlpukat="0";
    public int saldos = 0, total = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);
        Intent intent = getIntent();
        TextView airMinerals = findViewById(R.id.air_mineral);
        TextView jusApels = findViewById(R.id.jus_apel);
        TextView jusManggas = findViewById(R.id.jus_mangga);
        TextView jusAlpukats = findViewById(R.id.jus_alpukat);
        TextView totals = findViewById(R.id.total);
        airMineral= intent.getStringExtra("airMineral");
        jusApel = intent.getStringExtra("jusApel");
        jusMangga = intent.getStringExtra("jusMangga");
        jusAlpukat = intent.getStringExtra("jusAlpukat");
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
        if(airMineral != null){
            total = total + Integer.parseInt(airMineral);
            airMinerals.setText("Air Mineral\n" + intent.getStringExtra("airMineral") + " x Rp 123");
        }else{
            airMinerals.setText("Air Mineral\n0 x Rp 123");
        }
        if(jusApel != null){
            total = total + Integer.parseInt(jusApel);
            jusApels.setText("Jus Apel\n" + intent.getStringExtra("jusApel") + " x Rp 123");
        }else{
            jusApels.setText("Jus Apel\n0 x Rp 123");
        }
        if(jusMangga != null){
            total = total + Integer.parseInt(jusMangga);
            jusManggas.setText("Jus Mangga\n" + intent.getStringExtra("jusMangga") + " x Rp 123");
        }else{
            jusManggas.setText("Jus Mangga\n0 x Rp 123");
        }
        if(jusAlpukat != null){
            total = total + Integer.parseInt(jusAlpukat);
            jusAlpukats.setText("Jus Alpukat\n" + intent.getStringExtra("jusAlpukat") + " x Rp 123");
        }else{
            jusAlpukats.setText("Jus Alpukat\n0 x Rp 123");
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
            Intent intent = new Intent(this, OrderComplete.class);
            intent.putExtra("airMineral", this.airMineral);
            intent.putExtra("jusApel", this.jusApel);
            intent.putExtra("jusMangga", this.jusMangga);
            intent.putExtra("jusAlpukat", this.jusAlpukat);
            startActivity(intent);
        }
    }
    public void onClickHapus1(View view) {
        Intent intent = new Intent(this, MyOrder.class);
        intent.putExtra("airMineral", "0");
        intent.putExtra("jusApel", this.jusApel);
        intent.putExtra("jusMangga", this.jusMangga);
        intent.putExtra("jusAlpukat", this.jusAlpukat);
        startActivity(intent);
    }
    public void onClickHapus2(View view) {
        Intent intent = new Intent(this, MyOrder.class);
        intent.putExtra("airMineral", this.airMineral);
        intent.putExtra("jusApel", "0");
        intent.putExtra("jusMangga", this.jusMangga);
        intent.putExtra("jusAlpukat", this.jusAlpukat);
        startActivity(intent);
    }
    public void onClickHapus3(View view) {
        Intent intent = new Intent(this, MyOrder.class);
        intent.putExtra("airMineral", this.airMineral);
        intent.putExtra("jusApel", this.jusApel);
        intent.putExtra("jusMangga", "0");
        intent.putExtra("jusAlpukat", this.jusAlpukat);
        startActivity(intent);
    }
    public void onClickHapus4(View view) {
        Intent intent = new Intent(this, MyOrder.class);
        intent.putExtra("airMineral", this.airMineral);
        intent.putExtra("jusApel", this.jusApel);
        intent.putExtra("jusMangga", this.jusMangga);
        intent.putExtra("jusAlpukat", "0");
        startActivity(intent);
    }
    private static void updateWallet(SQLiteDatabase dbs, int saldos, int totals) {
        ContentValues walletValues = new ContentValues();
        walletValues.put("NOMINAL", (saldos - totals));
        dbs.update("WALLET", walletValues,"NAME = ?", new String[] {"user1"} );
    }
}