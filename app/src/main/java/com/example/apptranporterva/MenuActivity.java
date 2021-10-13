package com.example.apptranporterva;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity{

    Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Bundle recibir = getIntent().getExtras();
        user = (Usuario) recibir.getSerializable("Usuario");

        TextView tvnombre = (TextView) findViewById(R.id.textViewUserName);
        TextView tvsaldo = (TextView) findViewById(R.id.textViewUserMoney);

        tvnombre.setText(user.getNombre());
        tvsaldo.setText(Integer.toString(user.getSaldo()));

        Button btnReserva = (Button) findViewById(R.id.buttonMReserva);
        Button btnRedBuses = (Button) findViewById(R.id.buttonMRedBus);
        Button btnRecarga = (Button) findViewById(R.id.buttonMRecarga);
        Button btnInfo = (Button) findViewById(R.id.buttonMInfo);

        Bundle bundle = new Bundle();
        bundle.putSerializable("Usuario", user);

        btnReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReserva = new Intent(MenuActivity.this, ReservaP1Activity.class);
                intentReserva.putExtras(bundle);
                startActivity(intentReserva);
            }
        });

        btnRedBuses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRedBus = new Intent(MenuActivity.this, RedBusesActivity.class);
                intentRedBus.putExtras(bundle);
                startActivity(intentRedBus);
            }
        });

        btnRecarga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRecarga = new Intent(MenuActivity.this, RecargaActivity.class);
                intentRecarga.putExtras(bundle);
                startActivity(intentRecarga);
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentInfo = new Intent(MenuActivity.this, InformacionActivity.class);
                intentInfo.putExtras(bundle);
                startActivity(intentInfo);
            }
        });

    }
}
