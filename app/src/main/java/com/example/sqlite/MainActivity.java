package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewNombre,textViewApellido,textViewNumero;
    private EditText editTextNombre,editTextApellido,editTextNumero;
    private Button insertar;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ContactosSQLite usdbh =new ContactosSQLite(this, "DBContactos", null, 1);

        SQLiteDatabase db = usdbh.getWritableDatabase();

        //Si hemos abierto correctamente la base de datos
        if (db != null){

            ContentValues nuevoContacto = new ContentValues();
            nuevoContacto.put("idUsuario", );
            nuevoContacto.put("nombre", );
            nuevoContacto.put("apellido", );
            nuevoContacto.put("numero", );

            db.insert("Contactos", null, nuevoContacto);

        }

    }
}
