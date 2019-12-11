package com.example.sqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Biblioteca extends AppCompatActivity {

    private SQLiteDatabase db;
    private  BibliotecaSQLite bidbh;
    private Button insertarL,borrarL,insertarUsu,borrarUsu,insertarPres,borrarPres;
    private EditText editTextISBN,editTextTitulo,editTextID,editTextNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biblioteca);

        //Libros
        insertarL = findViewById(R.id.btnInsertarL);
        borrarL = findViewById(R.id.btnBorrarL);
        editTextISBN = findViewById(R.id.editTextISBN);
        editTextTitulo = findViewById(R.id.editTextTitulo);


        //Usuarios
        insertarUsu = findViewById(R.id.btnInsertarUsu);
        borrarUsu = findViewById(R.id.btnBorrarUsu);
        editTextID = findViewById(R.id.editTextID);
        editTextNombre = findViewById(R.id.editTextNombre);


        //Prestamos
        insertarPres = findViewById(R.id.btnInsertarPrest);
        borrarPres = findViewById(R.id.btnBorrarPrest);


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
        insertarPres.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //Si hemos abierto correctamente la base de datos
                if (db != null) {
                    try{
                        ContentValues nuevoUsuario = new ContentValues();
                        nuevoUsuario.put("ISBN", editTextISBN.getText().toString());
                        nuevoUsuario.put("idUsuario", editTextID.getText().toString());

                        db.insert("Prestamos", null, nuevoUsuario);
                    }
                    catch (SQLiteException e)
                    {
                       /* AlertDialog.Builder dialogo1 = new AlertDialog.Builder();
                        dialogo1.setTitle("Error al insertar");
                        dialogo1.setMessage("El libro o el usuario no existen");

                        dialogo1.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        // Continue with delete operation
                                    }
                                });*/
                       
                    }


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
    }

}
