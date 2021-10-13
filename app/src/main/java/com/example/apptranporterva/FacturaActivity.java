package com.example.apptranporterva;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FacturaActivity extends AppCompatActivity {

    Usuario user;
    Reserva factura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura);

        Bundle recibir = getIntent().getExtras();
        user = (Usuario) recibir.getSerializable("Usuario");
        factura = (Reserva) recibir.getSerializable("Factura") ;

        TextView tvnombre = (TextView) findViewById(R.id.textViewUserNameF);
        TextView tvsaldo = (TextView) findViewById(R.id.textViewUserMoneyF);

        tvnombre.setText(user.getNombre());
        tvsaldo.setText(Integer.toString(user.getSaldo()));

        TextView tvidF = (TextView) findViewById(R.id.textViewFid);
        TextView tvcostoF = (TextView) findViewById(R.id.textViewFcosto);
        TextView tvasientosF = (TextView) findViewById(R.id.textViewFasientos);
        TextView tvidR = (TextView) findViewById(R.id.textViewFidReserva);

        int numeroAleatorio = (int) (Math.random()*100+1);
        String sillasR = "";

        tvidF.setText(factura.getId());
        tvcostoF.setText(Integer.toString(user.getSaldo()));

        for(int i=0; i<factura.getSillas().length; i++){
            sillasR += " " + factura.getSillas()[i].getId() + " - ";
        }

        tvasientosF.setText(sillasR);
        tvidR.setText(Integer.toString(numeroAleatorio));

        Button btninicio = (Button) findViewById(R.id.buttonFinicio);

        btninicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FacturaActivity.this, MenuActivity.class);

                Bundle bundle = new Bundle();
                bundle.putSerializable("Usuario", user);

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
