package com.example.binusezyfoody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class History extends AppCompatActivity {
    public TextView t[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        final LinearLayout lm = findViewById(R.id.datas);
        final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        SQLiteOpenHelper DatabaseHelper = new DatabaseHelper(this);
        SQLiteDatabase db = DatabaseHelper.getReadableDatabase();
        Cursor cursor = db.query("HISTORY",
                new String[] {"_id", "created_at", "TYPE", "NAME1", "PRICE1", "QUANTITY1", "NAME2", "PRICE2", "QUANTITY2", "NAME3", "PRICE3", "QUANTITY3", "NAME4", "PRICE4", "QUANTITY4", "ADDRESS"},
                null, null, null, null, null
        );
        int loops = cursor.getCount();
        t = new TextView[loops];
        for(int i=0;i<loops;i++){
            if(i==0){
                cursor.moveToFirst();
            }else{
                cursor.moveToNext();
            }
            t[i]=new TextView(this);
            t[i].setLayoutParams(params);
            String hist = cursor.getString(1) + "\nType: "+cursor.getString(2)+"\n";
            if(cursor.getInt(5) > 0){
                hist += (cursor.getString(3)+" QTY: "+cursor.getInt(5)+" Price: "+cursor.getInt(4)+"\n");
            }
            if(cursor.getInt(8) > 0){
                hist += (cursor.getString(6)+" QTY: "+cursor.getInt(8)+" Price: "+cursor.getInt(7)+"\n");
            }
            if(cursor.getInt(11) > 0){
                hist += (cursor.getString(9)+" QTY: "+cursor.getInt(11)+" Price: "+cursor.getInt(10)+"\n");
            }
            if(cursor.getInt(14) > 0){
                hist += (cursor.getString(12)+" QTY: "+cursor.getInt(14)+" Price: "+cursor.getInt(13)+"\n");
            }
            hist += ("Alamat: " + cursor.getString(15)+"\n");
            t[i].setText(hist);
            lm.addView(t[i]);
        }
        cursor.close();
        db.close();
    }
    public void onClickMainMenu(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}