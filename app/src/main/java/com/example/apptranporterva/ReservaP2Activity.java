package com.example.apptranporterva;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ReservaP2Activity extends AppCompatActivity {

    Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservap2);

        Bundle recibir = getIntent().getExtras();
        user = (Usuario) recibir.getSerializable("Usuario");

        TextView tvnombre = (TextView) findViewById(R.id.textViewUserNameRes2);
        TextView tvsaldo = (TextView) findViewById(R.id.textViewUserMoneyRes2);

        tvnombre.setText(user.getNombre());
        tvsaldo.setText(Integer.toString(user.getSaldo()));

        Button btnContinuar = (Button) findViewById(R.id.buttonRes2);

        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReservaP2Activity.this, ReservaP3Activity.class);

                Bundle bundle = new Bundle();
                bundle.putSerializable("Usuario", user);

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

}
