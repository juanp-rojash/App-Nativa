package com.example.apptranporterva;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ReservaP1Activity extends AppCompatActivity {

    Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservap1);

        Bundle recibir = getIntent().getExtras();
        user = (Usuario) recibir.getSerializable("Usuario");

        TextView tvnombre = (TextView) findViewById(R.id.textViewUserNameRes1);
        TextView tvsaldo = (TextView) findViewById(R.id.textViewUserMoneyRes1);

        tvnombre.setText(user.getNombre());
        tvsaldo.setText(user.getSaldo());

        ImageView iv = (ImageView) findViewById(R.id.imageViewRes1);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReservaP1Activity.this, ReservaP2Activity.class);

                Bundle bundle = new Bundle();
                bundle.putSerializable("Usuario", user);

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
