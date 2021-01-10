package com.example.binusezyfoody;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
public class Foods extends AppCompatActivity {
    public String nasiCampur="0", ayamGoreng="0", ayamBakar="0", ayamRebus="0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods);
        Intent intent = getIntent();
        nasiCampur = intent.getStringExtra("nasiCampur");
        ayamGoreng = intent.getStringExtra("ayamGoreng");
        ayamBakar = intent.getStringExtra("ayamBakar");
        ayamRebus = intent.getStringExtra("ayamRebus");
    }
    public void onClickMyOrder2(View view) {
        Intent intent = new Intent(this, MyOrder2.class);
        intent.putExtra("nasiCampur", this.nasiCampur);
        intent.putExtra("ayamGoreng", this.ayamGoreng);
        intent.putExtra("ayamBakar", this.ayamBakar);
        intent.putExtra("ayamRebus", this.ayamRebus);
        startActivity(intent);
    }
    public void onClicknasiCampur(View view) {
        Intent intent = new Intent(this, Order2.class);
        intent.putExtra("foods", "Nasi Campur\nRp 123");
        intent.putExtra("nasiCampur", this.nasiCampur);
        intent.putExtra("ayamGoreng", this.ayamGoreng);
        intent.putExtra("ayamBakar", this.ayamBakar);
        intent.putExtra("ayamRebus", this.ayamRebus);
        startActivity(intent);
    }
    public void onClickayamGoreng(View view) {
        Intent intent = new Intent(this, Order2.class);
        intent.putExtra("foods", "Ayam Geprek\nRp 123");
        intent.putExtra("nasiCampur", this.nasiCampur);
        intent.putExtra("ayamGoreng", this.ayamGoreng);
        intent.putExtra("ayamBakar", this.ayamBakar);
        intent.putExtra("ayamRebus", this.ayamRebus);
        startActivity(intent);
    }
    public void onClickayamBakar(View view) {
        Intent intent = new Intent(this, Order2.class);
        intent.putExtra("foods", "Nasi Uduk\nRp 123");
        intent.putExtra("nasiCampur", this.nasiCampur);
        intent.putExtra("ayamGoreng", this.ayamGoreng);
        intent.putExtra("ayamBakar", this.ayamBakar);
        intent.putExtra("ayamRebus", this.ayamRebus);
        startActivity(intent);
    }
    public void onClickayamRebus(View view) {
        Intent intent = new Intent(this, Order2.class);
        intent.putExtra("foods", "Ayam Rebus\nRp 123");
        intent.putExtra("nasiCampur", this.nasiCampur);
        intent.putExtra("ayamGoreng", this.ayamGoreng);
        intent.putExtra("ayamBakar", this.ayamBakar);
        intent.putExtra("ayamRebus", this.ayamRebus);
        startActivity(intent);
    }
}