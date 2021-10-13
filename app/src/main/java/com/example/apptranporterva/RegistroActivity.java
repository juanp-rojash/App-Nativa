package com.example.apptranporterva;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistroActivity extends AppCompatActivity {

    Usuario registro;
    String nombre, correo, password, celular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        Button btn = (Button) findViewById(R.id.buttonRegistro);
        EditText etNombre = (EditText) findViewById(R.id.editTextRNombre);
        EditText etCorreo = (EditText) findViewById(R.id.editTextREmail);
        EditText etPassword = (EditText) findViewById(R.id.editTextRPassword);
        EditText etCelular = (EditText) findViewById(R.id.editTextRCelular);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre = etNombre.getText().toString();
                correo = etCorreo.getText().toString();
                password = etPassword.getText().toString();
                celular = etCelular.getText().toString();

                if(TextUtils.isEmpty(nombre) || TextUtils.isEmpty(correo) || TextUtils.isEmpty(password) || TextUtils.isEmpty(celular)){
                    Toast.makeText(RegistroActivity.this, "Error en los datos, ingreselos de manera correcta", Toast.LENGTH_SHORT).show();
                }
                else{
                    registro = new Usuario(nombre, correo, password, celular);
                    Toast.makeText(RegistroActivity.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegistroActivity.this, MainActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Usuario", registro);

                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
    }
}
