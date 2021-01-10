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

public class OrderComplete extends AppCompatActivity {
    public String airMineral="0", jusApel="0", jusMangga="0", jusAlpukat="0";
    public int sMineral = 0, sApel = 0, sMangga = 0, sAlpukat = 0, total = 0, saldos = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete);
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
                "TYPE = ?", new String[] {"Drink"}, null, null, null
        );
        cursor.moveToFirst();
        sMineral = cursor.getInt(0);
        cursor.moveToNext();
        sApel = cursor.getInt(0);
        cursor.moveToNext();
        sMangga = cursor.getInt(0);
        cursor.moveToNext();
        sAlpukat = cursor.getInt(0);
        cursor.close();
        db.close();
        SQLiteOpenHelper DatabaseHelperk = new DatabaseHelper(this);
        SQLiteDatabase dbs = DatabaseHelperk.getWritableDatabase();
        int updateds = 0;
        if(airMineral!=null){
            total = total + Integer.parseInt(airMineral);
            airMinerals.setText("Air Mineral\n" + intent.getStringExtra("airMineral") + " x Rp 123");
            updateDrinks(dbs, "Air Mineral", sMineral, Integer.parseInt(airMineral));
            updateds = 1;
        }else{
            airMineral = "0";
            airMinerals.setText("Air Mineral\n0 x Rp 123");
        }
        if(jusApel != null){
            total = total + Integer.parseInt(jusApel);
            jusApels.setText("Jus Apel\n" + intent.getStringExtra("jusApel") + " x Rp 123");
            updateDrinks(dbs, "Jus Apel", sApel, Integer.parseInt(jusApel));
            updateds = 1;
        }else{
            jusApel = "0";
            jusApels.setText("Jus Apel\n0 x Rp 123");
        }
        if(jusMangga != null){
            total = total + Integer.parseInt(jusMangga);
            jusManggas.setText("Jus Mangga\n" + intent.getStringExtra("jusMangga") + " x Rp 123");
            updateDrinks(dbs, "Jus Mangga", sMangga, Integer.parseInt(jusMangga));
            updateds = 1;
        }else{
            jusMangga = "0";
            jusManggas.setText("Jus Mangga\n0 x Rp 123");
        }
        if(jusAlpukat != null){
            total = total + Integer.parseInt(jusAlpukat);
            jusAlpukats.setText("Jus Alpukat\n" + intent.getStringExtra("jusAlpukat") + " x Rp 123");
            updateDrinks(dbs, "Jus Alpukat", sAlpukat, Integer.parseInt(jusAlpukat));
            updateds = 1;
        }else{
            jusAlpukat = "0";
            jusAlpukats.setText("Jus Alpukat\n0 x Rp 123");
        }
        if(updateds == 1){
            insertHistory(dbs, "Drink", "Air Mineral", 123, Integer.parseInt(airMineral), "Jus Apel", 123, Integer.parseInt(jusApel), "Jus Mangga", 123, Integer.parseInt(jusMangga), "Jus Alpukat", 123, Integer.parseInt(jusAlpukat), "dummy");
        }
        dbs.close();
        total = total * 123;
        totals.setText("Total: Rp. " + total + ",00");
    }
    public void onClickMainMenu(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    private static void updateDrinks(SQLiteDatabase dbs, String name, int stock, int quantity) {
        ContentValues drinkValues = new ContentValues();
        drinkValues.put("STOCK", (stock - quantity));
        dbs.update("PRODUK", drinkValues,"NAME = ?", new String[] {name});
    }
    private static void insertHistory(SQLiteDatabase dbs, String type, String name1, int price1, int quantity1, String name2, int price2, int quantity2, String name3, int price3, int quantity3, String name4, int price4, int quantity4, String address) {
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
        dbs.insert("HISTORY", null, historyValues);
    }
}