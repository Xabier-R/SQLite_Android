package com.example.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BibliotecaSQLite extends SQLiteOpenHelper {
    //Sentencias SQL para crear las tablas

    String sqlCreate1 ="CREATE TABLE Libros (ISBN INTEGER PRIMARY KEY ," +" Titulo TEXT)";
    String sqlCreate2 ="CREATE TABLE Usuarios (idUsuario INTEGER PRIMARY KEY ," +" Nombre TEXT)";
    String sqlCreate3 ="CREATE TABLE Prestamos (ISBN INTEGER  REFERENCES  Libros(ISBN)," +" idUsuario INTEGER  REFERENCES  Usuarios(idUsuario), PRIMARY KEY (ISBN,idUsuario) )";




    public BibliotecaSQLite(Context contexto, String nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }

    @Override

    public void onCreate(SQLiteDatabase db) {
        //Se ejecuta la sentencia SQL de creación de la tabla
        db.execSQL(sqlCreate1);
        db.execSQL(sqlCreate2);
        db.execSQL(sqlCreate3);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS Libros");
        db.execSQL(sqlCreate1);
        db.execSQL("DROP TABLE IF EXISTS Usuarios");
        db.execSQL(sqlCreate2);
        db.execSQL("DROP TABLE IF EXISTS Prestamos");
        db.execSQL(sqlCreate3);



    }

}
