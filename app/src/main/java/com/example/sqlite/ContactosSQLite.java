package com.example.sqlite;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class ContactosSQLite extends SQLiteOpenHelper {
    //Sentencia SQL para crear la tabla de Contactos
    String sqlCreate ="CREATE TABLE Contactos (idUsuario INTEGER PRIMARY KEY AUTOINCREMENT ," +" nombre TEXT, apellido TEXT, numero INTEGER)";

    public ContactosSQLite(Context contexto, String nombre, CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }

    @Override

    public void onCreate(SQLiteDatabase db) {
        //Se ejecuta la sentencia SQL de creación de la tabla
        db.execSQL(sqlCreate);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS Contactos");
        db.execSQL(sqlCreate);
    }

}