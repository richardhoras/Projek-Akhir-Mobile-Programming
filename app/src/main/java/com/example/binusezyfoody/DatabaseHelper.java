package com.example.binusezyfoody;
import android.content.ContentValues;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "binusezyfoody";
    private static final int DB_VERSION = 1;
    public DatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE HISTORY ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "created_at TEXT DEFAULT CURRENT_DATE, "
                + "TYPE TEXT, "
                + "NAME1 TEXT, "
                + "PRICE1 INTEGER, "
                + "QUANTITY1 INTEGER, "
                + "NAME2 TEXT, "
                + "PRICE2 INTEGER, "
                + "QUANTITY2 INTEGER, "
                + "NAME3 TEXT, "
                + "PRICE3 INTEGER, "
                + "QUANTITY3 INTEGER, "
                + "NAME4 TEXT, "
                + "PRICE4 INTEGER, "
                + "QUANTITY4 INTEGER, "
                + "ADDRESS TEXT);");
        db.execSQL("CREATE TABLE WALLET ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, "
                + "NOMINAL INTEGER);");
        db.execSQL("CREATE TABLE PRODUK ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, "
                + "TYPE TEXT, "
                + "PRICE INTEGER, "
                + "STOCK INTEGER);");
        insertWallet(db, "user1", 0);
        insertProduk(db, "Air Mineral", "Drink", 123, 1000);
        insertProduk(db, "Jus Apel", "Drink", 123, 1000);
        insertProduk(db, "Jus Mangga", "Drink", 123, 1000);
        insertProduk(db, "Jus Alpukat", "Drink", 123, 1000);
        insertProduk(db, "Oreo", "Snack", 123, 1000);
        insertProduk(db, "Taro", "Snack", 123, 1000);
        insertProduk(db, "Tango", "Snack", 123, 1000);
        insertProduk(db, "KitKat", "Snack", 123, 1000);
        insertProduk(db, "Nasi Campur", "Food", 123, 1000);
        insertProduk(db, "Ayam Goreng", "Food", 123, 1000);
        insertProduk(db, "Ayam Bakar", "Food", 123, 1000);
        insertProduk(db, "Ayam Rebus", "Food", 123, 1000);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
    private static void insertProduk(SQLiteDatabase db, String name, String type, int price, int stock) {
        ContentValues produkValues = new ContentValues();
        produkValues.put("NAME", name);
        produkValues.put("TYPE", type);
        produkValues.put("PRICE", price);
        produkValues.put("STOCK", stock);
        db.insert("PRODUK", null, produkValues);
    }
    private static void insertWallet(SQLiteDatabase db, String name, int nominal) {
        ContentValues walletValues = new ContentValues();
        walletValues.put("NAME", name);
        walletValues.put("NOMINAL", nominal);
        db.insert("WALLET", null, walletValues);
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
