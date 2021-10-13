package com.example.apptranporterva;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RecargaActivity extends AppCompatActivity {

    Usuario user;
    String numeroTarjeta, nombreTitular, venc1, venc2, seguridad;
    int monto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recarga);

        Bundle recibir = getIntent().getExtras();
        user = (Usuario) recibir.getSerializable("Usuario");

        TextView tvnombre = (TextView) findViewById(R.id.textViewUserNameR);
        TextView tvsaldo = (TextView) findViewById(R.id.textViewUserMoneyR);

        tvnombre.setText(user.getNombre());
        tvsaldo.setText(Integer.toString(user.getSaldo()));

        EditText etNumeroT = (EditText) findViewById(R.id.editTextRNumT);
        EditText etNombreT = (EditText) findViewById(R.id.editTextRNombreT);
        EditText etVenc1 = (EditText) findViewById(R.id.editTextRVenci1);
        EditText etVenc2 = (EditText) findViewById(R.id.editTextRVenci2);
        EditText etSeguridad = (EditText) findViewById(R.id.editTextRSeguridad);
        EditText etMonto = (EditText) findViewById(R.id.editTextRMonto);

        Button btnRecarga = (Button) findViewById(R.id.buttonRRecarga);

        btnRecarga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numeroTarjeta = etNumeroT.getText().toString();
                nombreTitular = etNombreT.getText().toString();
                venc1 = etVenc1.getText().toString();
                venc2 = etVenc2.getText().toString();
                seguridad = etSeguridad.getText().toString();
                monto = Integer.parseInt(etMonto.getText().toString());

                if(TextUtils.isEmpty(numeroTarjeta) || TextUtils.isEmpty(nombreTitular) || TextUtils.isEmpty(venc1) || TextUtils.isEmpty(venc2) || TextUtils.isEmpty(seguridad) || monto == 0 ){
                    Toast.makeText(RecargaActivity.this, "Error en los datos, ingreselos de manera correcta", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(RecargaActivity.this, "Recarga exitosa", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RecargaActivity.this, MenuActivity.class);

                    user.setSaldo(user.getSaldo() + monto);

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Usuario", user);

                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
    }
}