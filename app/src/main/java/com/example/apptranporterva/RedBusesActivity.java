package com.example.apptranporterva;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RedBusesActivity extends AppCompatActivity {

    Usuario user;
    Transferencia tmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redbuses);

        Bundle recibir = getIntent().getExtras();
        user = (Usuario) recibir.getSerializable("Usuario");
        tmp = (Transferencia) recibir.getSerializable("Estado");

        TextView tvnombre = (TextView) findViewById(R.id.textViewUserNameRed);
        TextView tvsaldo = (TextView) findViewById(R.id.textViewUserMoneyRed);

        tvnombre.setText(user.getNombre());
        tvsaldo.setText(Integer.toString(user.getSaldo()));

        ImageView iv = (ImageView) findViewById(R.id.imageViewRedBus);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RedBusesActivity.this, ReservaP2Activity.class);

                Bundle bundle = new Bundle();
                bundle.putSerializable("Usuario", user);
                bundle.putSerializable("Estado", tmp);

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
