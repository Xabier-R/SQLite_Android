package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Contactos extends AppCompatActivity {


    private EditText editTextNombre,editTextApellido,editTextNumero;
    private Button insertar,consultar;
    private  ContactosSQLite condbh;
    private SQLiteDatabase db;
    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos);

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextApellido = findViewById(R.id.editTextApellido);
        editTextNumero = findViewById(R.id.editTextNumero);
        insertar = findViewById(R.id.btnInsertar);
        consultar = findViewById(R.id.btnConsultar);

        editText = findViewById(R.id.editText);


        condbh =new ContactosSQLite(this, "DBContactos", null, 1);

        db = condbh.getWritableDatabase();

        insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Si hemos abierto correctamente la base de datos
                if (db != null){

                    ContentValues nuevoContacto = new ContentValues();
                    nuevoContacto.put("nombre", editTextNombre.getText().toString() );
                    nuevoContacto.put("apellido", editTextApellido.getText().toString() );
                    nuevoContacto.put("numero", editTextNumero.getText().toString());

                    db.insert("Contactos", null, nuevoContacto);

                }

            }

        });

        consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editText.setText("");

                Cursor c =db.rawQuery("SELECT idUsuario, nombre, apellido, numero FROM Contactos", null);
                if (c.moveToFirst()){
                    //Recorremos el cursor hasta que no haya más registros.
                    do {int codigo = c.getInt(0);
                        String nombre =c.getString(1);
                        String apellido = c.getString(2);
                        int numero = c.getInt(3);

                        editText.append (codigo +" -"+nombre + " -" +apellido+" -"+numero+ "\n" );

                    }
                    while (c.moveToNext());


                }
            }


        });

    }
}
