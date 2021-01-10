package com.example.binusezyfoody;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
public class Snacks extends AppCompatActivity {
    public String oreo="0", taro="0", tango="0", kitKat="0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snacks);
        Intent intent = getIntent();
        oreo = intent.getStringExtra("oreo");
        taro = intent.getStringExtra("taro");
        tango = intent.getStringExtra("tango");
        kitKat = intent.getStringExtra("kitKat");
    }
    public void onClickMyOrder3(View view) {
        Intent intent = new Intent(this, MyOrder3.class);
        intent.putExtra("oreo", this.oreo);
        intent.putExtra("taro", this.taro);
        intent.putExtra("tango", this.tango);
        intent.putExtra("kitKat", this.kitKat);
        startActivity(intent);
    }
    public void onClickoreo(View view) {
        Intent intent = new Intent(this, Order3.class);
        intent.putExtra("snacks", "oreo\nRp 123");
        intent.putExtra("oreo", this.oreo);
        intent.putExtra("taro", this.taro);
        intent.putExtra("tango", this.tango);
        intent.putExtra("kitKat", this.kitKat);
        startActivity(intent);
    }
    public void onClicktaro(View view) {
        Intent intent = new Intent(this, Order3.class);
        intent.putExtra("snacks", "Taro\nRp 123");
        intent.putExtra("oreo", this.oreo);
        intent.putExtra("taro", this.taro);
        intent.putExtra("tango", this.tango);
        intent.putExtra("kitKat", this.kitKat);
        startActivity(intent);
    }
    public void onClicktango(View view) {
        Intent intent = new Intent(this, Order3.class);
        intent.putExtra("snacks", "tango\nRp 123");
        intent.putExtra("oreo", this.oreo);
        intent.putExtra("taro", this.taro);
        intent.putExtra("tango", this.tango);
        intent.putExtra("kitKat", this.kitKat);
        startActivity(intent);
    }
    public void onClickkitKat(View view) {
        Intent intent = new Intent(this, Order3.class);
        intent.putExtra("snacks", "KitKat\nRp 123");
        intent.putExtra("oreo", this.oreo);
        intent.putExtra("taro", this.taro);
        intent.putExtra("tango", this.tango);
        intent.putExtra("kitKat", this.kitKat);
        startActivity(intent);
    }
}