package com.example.binusezyfoody;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TopUp extends AppCompatActivity {
    public String toping = "0";
    public int saldos = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);
        SQLiteOpenHelper DatabaseHelper = new DatabaseHelper(this);
        SQLiteDatabase db = DatabaseHelper.getReadableDatabase();
        Cursor cursor = db.query("WALLET",
                new String[] {"NOMINAL"},
                null, null, null, null, null
        );
        cursor.moveToFirst();
        saldos = cursor.getInt(0);
        TextView saldoz = findViewById(R.id.teks_saldo);
        saldoz.setText("Saldo: "+this.saldos);
        db.close();
    }
    public void onClickMainMenu(View view) {
        SQLiteOpenHelper DatabaseHelper = new DatabaseHelper(this);
        SQLiteDatabase dbs = DatabaseHelper.getWritableDatabase();
        EditText editText = findViewById(R.id.editText);
        this.toping = editText.getText().toString();
        if(Integer.parseInt(toping) <= 2000000){
            updateWallet(dbs, saldos, Integer.parseInt(toping));
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
    private static void updateWallet(SQLiteDatabase dbs, int saldos, int toping) {
        ContentValues walletValues = new ContentValues();
        walletValues.put("NOMINAL", (saldos + toping));
        dbs.update("WALLET", walletValues,"NAME = ?", new String[] {"user1"} );
    }
}