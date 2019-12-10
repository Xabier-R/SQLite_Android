package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNombre,editTextApellido,editTextNumero;
    private Button insertar;
    private  ContactosSQLite usdbh;
    private  SQLiteDatabase db;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextApellido = findViewById(R.id.editTextApellido);
        editTextNumero = findViewById(R.id.editTextNumero);
        insertar = findViewById(R.id.btnInsertar);



        usdbh =new ContactosSQLite(this, "DBContactos", null, 1);

        db = usdbh.getWritableDatabase();

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


    }
}
