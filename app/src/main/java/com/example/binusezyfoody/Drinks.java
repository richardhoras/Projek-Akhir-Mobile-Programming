package com.example.binusezyfoody;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
public class Drinks extends AppCompatActivity {
    public String airMineral="0", jusApel="0", jusMangga="0", jusAlpukat="0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);
        Intent intent = getIntent();
        airMineral = intent.getStringExtra("airMineral");
        jusApel = intent.getStringExtra("jusApel");
        jusMangga = intent.getStringExtra("jusMangga");
        jusAlpukat = intent.getStringExtra("jusAlpukat");
    }
    public void onClickMyOrder(View view) {
        Intent intent = new Intent(this, MyOrder.class);
        intent.putExtra("airMineral", this.airMineral);
        intent.putExtra("jusApel", this.jusApel);
        intent.putExtra("jusMangga", this.jusMangga);
        intent.putExtra("jusAlpukat", this.jusAlpukat);
        startActivity(intent);
    }
    public void onClickAirMineral(View view) {
        Intent intent = new Intent(this, Order.class);
        intent.putExtra("drinks", "Air Mineral\nRp 123");
        intent.putExtra("airMineral", this.airMineral);
        intent.putExtra("jusApel", this.jusApel);
        intent.putExtra("jusMangga", this.jusMangga);
        intent.putExtra("jusAlpukat", this.jusAlpukat);
        startActivity(intent);
    }
    public void onClickJusApel(View view) {
        Intent intent = new Intent(this, Order.class);
        intent.putExtra("drinks", "Jus Apel\nRp 123");
        intent.putExtra("airMineral", this.airMineral);
        intent.putExtra("jusApel", this.jusApel);
        intent.putExtra("jusMangga", this.jusMangga);
        intent.putExtra("jusAlpukat", this.jusAlpukat);
        startActivity(intent);
    }
    public void onClickJusMangga(View view) {
        Intent intent = new Intent(this, Order.class);
        intent.putExtra("drinks", "Jus Mangga\nRp 123");
        intent.putExtra("airMineral", this.airMineral);
        intent.putExtra("jusApel", this.jusApel);
        intent.putExtra("jusMangga", this.jusMangga);
        intent.putExtra("jusAlpukat", this.jusAlpukat);
        startActivity(intent);
    }
    public void onClickJusAlpukat(View view) {
        Intent intent = new Intent(this, Order.class);
        intent.putExtra("drinks", "Jus Alpukat\nRp 123");
        intent.putExtra("airMineral", this.airMineral);
        intent.putExtra("jusApel", this.jusApel);
        intent.putExtra("jusMangga", this.jusMangga);
        intent.putExtra("jusAlpukat", this.jusAlpukat);
        startActivity(intent);
    }
}