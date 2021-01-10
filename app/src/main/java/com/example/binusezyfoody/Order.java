package com.example.binusezyfoody;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class Order extends AppCompatActivity {
    public String airMineral="0", jusApel="0", jusMangga="0", jusAlpukat="0", drinkType;
    public int sMineral = 0, sApel = 0, sMangga = 0, sAlpukat = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Intent intent = getIntent();
        TextView orderan = findViewById(R.id.teks_orderan);
        orderan.setText(intent.getStringExtra("drinks"));
        drinkType = intent.getStringExtra("drinks");
        airMineral = intent.getStringExtra("airMineral");
        jusApel = intent.getStringExtra("jusApel");
        jusMangga = intent.getStringExtra("jusMangga");
        jusAlpukat = intent.getStringExtra("jusAlpukat");
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
        TextView stocks = findViewById(R.id.teks_stock);
        if(drinkType.equals("Air Mineral\nRp 123")){
            stocks.setText("Stock: "+sMineral);
        }else if(drinkType.equals("Jus Apel\nRp 123")){
            stocks.setText("Stock: "+sApel);
        }else if(drinkType.equals("Jus Mangga\nRp 123")){
            stocks.setText("Stock: "+sMangga);
        }else if(drinkType.equals("Jus Alpukat\nRp 123")){
            stocks.setText("Stock: "+sAlpukat);
        }
    }
    public void onClickOrderMore(View view) {
        int lanjut = 0;
        EditText editText = findViewById(R.id.editText);
        if(drinkType.equals("Air Mineral\nRp 123")){
            this.airMineral = editText.getText().toString();
            if(this.airMineral.equals("")){
                this.airMineral = "0";
            }
            if(Integer.parseInt(this.airMineral) <= sMineral){
                lanjut = 1;
            }
        }else if(drinkType.equals("Jus Apel\nRp 123")){
            this.jusApel = editText.getText().toString();
            if(this.jusApel.equals("")){
                this.jusApel = "0";
            }
            if(Integer.parseInt(this.jusApel) <= sApel){
                lanjut = 1;
            }
        }else if(drinkType.equals("Jus Mangga\nRp 123")){
            this.jusMangga = editText.getText().toString();
            if(this.jusMangga.equals("")){
                this.jusMangga = "0";
            }
            if(Integer.parseInt(this.jusMangga) <= sMangga){
                lanjut = 1;
            }
        }else if(drinkType.equals("Jus Alpukat\nRp 123")){
            this.jusAlpukat = editText.getText().toString();
            if(this.jusAlpukat.equals("")){
                this.jusAlpukat = "0";
            }
            if(Integer.parseInt(this.jusAlpukat) <= sAlpukat){
                lanjut = 1;
            }
        }
        if(lanjut == 1){
            Intent intent = new Intent(this, Drinks.class);
            intent.putExtra("airMineral", this.airMineral);
            intent.putExtra("jusApel", this.jusApel);
            intent.putExtra("jusMangga", this.jusMangga);
            intent.putExtra("jusAlpukat", this.jusAlpukat);
            startActivity(intent);
        }
    }
    public void onClickMyOrder(View view) {
        int lanjut = 0;
        EditText editText = findViewById(R.id.editText);
        if(drinkType.equals("Air Mineral\nRp 123")){
            this.airMineral = editText.getText().toString();
            if(this.airMineral.equals("")){
                this.airMineral = "0";
            }
            if(Integer.parseInt(this.airMineral) <= sMineral){
                lanjut = 1;
            }
        }else if(drinkType.equals("Jus Apel\nRp 123")){
            this.jusApel = editText.getText().toString();
            if(this.jusApel.equals("")){
                this.jusApel = "0";
            }
            if(Integer.parseInt(this.jusApel) <= sApel){
                lanjut = 1;
            }
        }else if(drinkType.equals("Jus Mangga\nRp 123")){
            this.jusMangga = editText.getText().toString();
            if(this.jusMangga.equals("")){
                this.jusMangga = "0";
            }
            if(Integer.parseInt(this.jusMangga) <= sMangga){
                lanjut = 1;
            }
        }else if(drinkType.equals("Jus Alpukat\nRp 123")){
            this.jusAlpukat = editText.getText().toString();
            if(this.jusAlpukat.equals("")){
                this.jusAlpukat = "0";
            }
            if(Integer.parseInt(this.jusAlpukat) <= sAlpukat){
                lanjut = 1;
            }
        }
        if(lanjut == 1){
            Intent intent = new Intent(this, MyOrder.class);
            intent.putExtra("airMineral", this.airMineral);
            intent.putExtra("jusApel", this.jusApel);
            intent.putExtra("jusMangga", this.jusMangga);
            intent.putExtra("jusAlpukat", this.jusAlpukat);
            startActivity(intent);
        }
    }
}