package com.example.sqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Biblioteca extends AppCompatActivity {

    private SQLiteDatabase db;
    private  BibliotecaSQLite bidbh;
    private Button insertarL,borrarL,consultarL,insertarUsu,borrarUsu,consultarUsu,insertarPres,borrarPres,consultarPres;
    private EditText editTextISBN,editTextTitulo,editTextID,editTextNombre,editTextL,editTextUsu,editTextPrest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biblioteca);

        //Libros
        insertarL = findViewById(R.id.btnInsertarL);
        borrarL = findViewById(R.id.btnBorrarL);
        editTextISBN = findViewById(R.id.editTextISBN);
        editTextTitulo = findViewById(R.id.editTextTitulo);
        consultarL= findViewById(R.id.btnConsultarL);
        editTextL= findViewById(R.id.editTextL);


        //Usuarios
        insertarUsu = findViewById(R.id.btnInsertarUsu);
        borrarUsu = findViewById(R.id.btnBorrarUsu);
        editTextID = findViewById(R.id.editTextID);
        editTextNombre = findViewById(R.id.editTextNombre);
        consultarUsu= findViewById(R.id.btnConsultarUsu);
        editTextUsu= findViewById(R.id.editTextUsu);


        //Prestamos
        insertarPres = findViewById(R.id.btnInsertarPrest);
        borrarPres = findViewById(R.id.btnBorrarPrest);
        consultarPres= findViewById(R.id.btnConsultarPrest);
        editTextPrest= findViewById(R.id.editTextPrest);


        bidbh = new BibliotecaSQLite(this, "DBBiblioteca", null, 1);

        db = bidbh.getWritableDatabase();

        insertarL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Si hemos abierto correctamente la base de datos
                if (db != null) {

                    ContentValues nuevoLibro = new ContentValues();
                    nuevoLibro.put("ISBN", editTextISBN.getText().toString());
                    nuevoLibro.put("Titulo", editTextTitulo.getText().toString());

                    db.insert("Libros", null, nuevoLibro);

                }

            }

        });

        borrarL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Si hemos abierto correctamente la base de datos

                if (db != null) {

                    db.delete("Libros", "ISBN" + "=" + editTextISBN.getText().toString(), null);

                }

            }

        });




        consultarL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editTextL.setText("");

                Cursor c =db.rawQuery("SELECT ISBN, titulo FROM Libros", null);
                if (c.moveToFirst()){
                    //Recorremos el cursor hasta que no haya más registros.
                    do {int ISBN = c.getInt(0);
                        String titulo =c.getString(1);


                        editTextL.append (ISBN +" - "+titulo + "\n" );

                    }
                    while (c.moveToNext());

                }


            }

        });


        insertarUsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Si hemos abierto correctamente la base de datos
                if (db != null) {

                    ContentValues nuevoUsuario = new ContentValues();
                    nuevoUsuario.put("idUsuario", editTextID.getText().toString());
                    nuevoUsuario.put("Nombre", editTextNombre.getText().toString());

                    db.insert("Usuarios", null, nuevoUsuario);

                }

            }

        });

        borrarUsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Si hemos abierto correctamente la base de datos

                if (db != null) {

                    db.delete("Usuarios", "idUsuario" + "=" + editTextID.getText().toString(), null);

                }

            }

        });

        consultarUsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editTextUsu.setText("");

                Cursor c =db.rawQuery("SELECT idUsuario, Nombre FROM Usuarios", null);
                if (c.moveToFirst()){
                    //Recorremos el cursor hasta que no haya más registros.
                    do {int idUsuario = c.getInt(0);
                        String Nombre =c.getString(1);


                        editTextUsu.append (idUsuario +" - "+Nombre + "\n" );

                    }
                    while (c.moveToNext());

                }


            }

        });

        insertarPres.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //Si hemos abierto correctamente la base de datos
                if (db != null) {

                    ContentValues nuevoUsuario = new ContentValues();
                    nuevoUsuario.put("ISBN", editTextISBN.getText().toString());
                    nuevoUsuario.put("idUsuario", editTextID.getText().toString());

                    db.insert("Prestamos", null, nuevoUsuario);



                }

            }

        });

        borrarPres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Si hemos abierto correctamente la base de datos

                if (db != null) {

                    db.delete("Usuarios", "ISBN" + "=" + editTextISBN.getText().toString()+" +"+"idUsuario"+ "=" + editTextID.getText().toString(), null);

                }

            }

        });




        consultarPres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editTextPrest.setText("");

                Cursor c =db.rawQuery("SELECT ISBN, idUsuario FROM Prestamos", null);
                if (c.moveToFirst()){
                    //Recorremos el cursor hasta que no haya más registros.
                    do {int ISBN = c.getInt(0);
                        int idUsuario =c.getInt(1);


                        editTextPrest.append (ISBN +" - "+idUsuario + "\n" );

                    }
                    while (c.moveToNext());

                }


            }

        });
    }

}
