package com.example.apptranporterva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Usuario registrado;
    String correo, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.buttonInicio);
        TextView tv = (TextView) findViewById(R.id.textViewRegistrarme);
        EditText etCorreo = (EditText) findViewById(R.id.editTextIEmail);
        EditText etPassword = (EditText) findViewById(R.id.editTextIPassword);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegistroActivity.class);
                startActivity(intent);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle recibir = getIntent().getExtras();
                registrado = (Usuario) recibir.getSerializable("Usuario");

                correo = etCorreo.getText().toString();
                password = etPassword.getText().toString();

                if (TextUtils.isEmpty(correo) || TextUtils.isEmpty(password)){
                    Toast.makeText(MainActivity.this, "Error en los datos, ingreselos de manera correcta", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(correo.equals(registrado.getCorreo()) && password.equals(registrado.getPassword())){
                        Intent intentMenu = new Intent(MainActivity.this, MenuActivity.class);

                        Bundle bundle = new Bundle();
                        bundle.putSerializable("Usuario", registrado);

                        intentMenu.putExtras(bundle);
                        startActivity(intentMenu);
                    }
                }
            }
        });


    }
}