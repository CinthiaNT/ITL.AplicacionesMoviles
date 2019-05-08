package com.example.ejemplosqlite.base_de_datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ejemplosqlite.config.Config_DB;

public class BaseDeDatos extends SQLiteOpenHelper {

    public BaseDeDatos(Context context, String name,SQLiteDatabase.CursorFactory factory, int version){
        super(context,name,factory,version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
      for(String tabla: Config_DB.script_db){
          db.execSQL(tabla);
      }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
