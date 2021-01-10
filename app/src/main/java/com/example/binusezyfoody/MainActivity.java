package com.example.binusezyfoody;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickMyOrder(View view) {
        Intent intent = new Intent(this, MyOrder.class);
        startActivity(intent);
    }
    public void onClickHistory(View view) {
        Intent intent = new Intent(this, History.class);
        startActivity(intent);
    }
    public void onClickDrinks(View view) {
        Intent intent = new Intent(this, Drinks.class);
        startActivity(intent);
    }
    public void onClickSnacks(View view) {
        Intent intent = new Intent(this, Snacks.class);
        startActivity(intent);
    }
    public void onClickFoods(View view) {
        Intent intent = new Intent(this, Foods.class);
        startActivity(intent);
    }
    public void onClickTopUp(View view) {
        Intent intent = new Intent(this, TopUp.class);
        startActivity(intent);
    }
}