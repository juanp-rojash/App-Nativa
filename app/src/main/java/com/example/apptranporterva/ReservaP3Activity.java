package com.example.apptranporterva;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ReservaP3Activity extends AppCompatActivity {

    Usuario user;
    Transferencia tmp;
    int costo = 0;
    Switch switch1, switch2, switch3;
    boolean sa1 = false, sa2 = false, sa3 = false, sb1 = false, sb2 = false,
            sb3 = false, sc1 = false, sd1 = false, sd2 = false, sd3 = false,
            se1 = false, se2 = false, se3 = false;
    ImageView a1, a2, a3, b1, b2, b3, c1, d1, d2, d3, e1, e2, e3;
    TextView tvCosto;
    Button btnCompra;
    static boolean bund = false;


    Asiento A1 = new Asiento("a1");
    Asiento A2 = new Asiento("a2");
    Asiento A3 = new Asiento("a3");
    Asiento B1 = new Asiento("b4");
    Asiento B2 = new Asiento("b5");
    Asiento B3 = new Asiento("b6");
    Asiento C1 = new Asiento("c7");
    Asiento D1 = new Asiento("d8");
    Asiento D2 = new Asiento("d9");
    Asiento D3 = new Asiento("d10");
    Asiento E1 = new Asiento("e11");
    Asiento E2 = new Asiento("e12");
    Asiento E3 = new Asiento("e13");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservap3);

        Bundle recibir = getIntent().getExtras();
        user = (Usuario) recibir.getSerializable("Usuario");

        TextView tvnombre = (TextView) findViewById(R.id.textViewUserNameRes3);
        TextView tvsaldo = (TextView) findViewById(R.id.textViewUserMoneyRes3);

        tvnombre.setText(user.getNombre());
        tvsaldo.setText(Integer.toString(user.getSaldo()));

        switch1 = (Switch) findViewById(R.id.switchRes3_1);
        switch2 = (Switch) findViewById(R.id.switchRes3_2);
        switch3 = (Switch) findViewById(R.id.switchRes3_3);

        a1 = (ImageView) findViewById(R.id.imageViewa1);
        a2 = (ImageView) findViewById(R.id.imageViewa2);
        a3 = (ImageView) findViewById(R.id.imageViewa3);
        b1 = (ImageView) findViewById(R.id.imageViewb1);
        b2 = (ImageView) findViewById(R.id.imageViewb2);
        b3 = (ImageView) findViewById(R.id.imageViewb3);
        c1 = (ImageView) findViewById(R.id.imageViewc1);
        d1 = (ImageView) findViewById(R.id.imageViewd1);
        d2 = (ImageView) findViewById(R.id.imageViewd2);
        d3 = (ImageView) findViewById(R.id.imageViewd3);
        e1 = (ImageView) findViewById(R.id.imageViewe1);
        e2 = (ImageView) findViewById(R.id.imageViewe2);
        e3 = (ImageView) findViewById(R.id.imageViewe3);

        tvCosto = (TextView) findViewById(R.id.textViewRes3Costo);

        btnCompra = (Button) findViewById(R.id.buttonRes3Compra);

        if(bund){
            tmp = (Transferencia) recibir.getSerializable("Estado");

            A1 = tmp.getA1();
            A2 = tmp.getA2();
            A3 = tmp.getA3();
            B1 = tmp.getB1();
            B2 = tmp.getB2();
            B3 = tmp.getB3();
            C1 = tmp.getC1();
            D1 = tmp.getD1();
            D2 = tmp.getD2();
            D3 = tmp.getD3();
            E1 = tmp.getE1();
            E2 = tmp.getE2();
            E3 = tmp.getE3();

            if (A1.getReservado()) a1.setImageResource(R.drawable.sillar);
            if (A2.getReservado()) a2.setImageResource(R.drawable.sillar);
            if (A3.getReservado()) a3.setImageResource(R.drawable.sillar);
            if (B1.getReservado()) b1.setImageResource(R.drawable.sillar);
            if (B2.getReservado()) b2.setImageResource(R.drawable.sillar);
            if (B3.getReservado()) b3.setImageResource(R.drawable.sillar);
            if (C1.getReservado()) c1.setImageResource(R.drawable.sillar);
            if (D1.getReservado()) d1.setImageResource(R.drawable.sillar);
            if (D2.getReservado()) d2.setImageResource(R.drawable.sillar);
            if (D3.getReservado()) d3.setImageResource(R.drawable.sillar);
            if (E1.getReservado()) e1.setImageResource(R.drawable.sillar);
            if (E2.getReservado()) e2.setImageResource(R.drawable.sillar);
            if (E3.getReservado()) e3.setImageResource(R.drawable.sillar);
        }
    }

    public void onclick(View view){

        if (view.getId() == R.id.switchRes3_1){
            if (switch1.isChecked()){
                switch2.setChecked(false);
                switch3.setChecked(false);
            }
        }
        else if (view.getId() == R.id.switchRes3_2){
            if (switch2.isChecked()){
                switch1.setChecked(false);
                switch3.setChecked(false);
            }
        }
        else if (view.getId() == R.id.switchRes3_3){
            if (switch3.isChecked()){
                switch1.setChecked(false);
                switch2.setChecked(false);
            }
        }
        else if (view.getId() == R.id.imageViewa1 && A1.getReservado() == false){
            if (sa1 == false){
                A1.setSeperado(true);
                a1.setImageResource(R.drawable.sillaa);
                sa1 = true;
                costo += A1.getValor();
                tvCosto.setText(Integer.toString(costo));
            }
            else {
                A1.setSeperado(false);
                a1.setImageResource(R.drawable.silla);
                sa1 = false;
                costo = costo - A1.getValor();
                tvCosto.setText(Integer.toString(costo));
            }
        }
        else if (view.getId() == R.id.imageViewa2 && A2.getReservado() == false){
            if (sa2 == false){
                A2.setSeperado(true);
                a2.setImageResource(R.drawable.sillaa);
                sa2 = true;
                costo += A2.getValor();
                tvCosto.setText(Integer.toString(costo));
            }
            else {
                A2.setSeperado(false);
                a2.setImageResource(R.drawable.silla);
                sa2 = false;
                costo = costo - A2.getValor();
                tvCosto.setText(Integer.toString(costo));
            }
        }
        else if (view.getId() == R.id.imageViewa3 && A3.getReservado() == false){
            if (sa3 == false){
                A3.setSeperado(true);
                a3.setImageResource(R.drawable.sillaa);
                sa3 = true;
                costo += A3.getValor();
                tvCosto.setText(Integer.toString(costo));
            }
            else {
                A3.setSeperado(false);
                a3.setImageResource(R.drawable.silla);
                sa3 = false;
                costo = costo - A3.getValor();
                tvCosto.setText(Integer.toString(costo));
            }
        }
        else if (view.getId() == R.id.imageViewb1 && B1.getReservado() == false){
            if (sb1 == false){
                B1.setSeperado(true);
                b1.setImageResource(R.drawable.sillaa);
                sb1 = true;
                costo += B1.getValor();
                tvCosto.setText(Integer.toString(costo));
            }
            else {
                B1.setSeperado(false);
                b1.setImageResource(R.drawable.silla);
                sb1 = false;
                costo = costo - B1.getValor();
                tvCosto.setText(Integer.toString(costo));
            }
        }
        else if (view.getId() == R.id.imageViewb2 && B2.getReservado() == false){
            if (sb2 == false){
                B2.setSeperado(true);
                b2.setImageResource(R.drawable.sillaa);
                sb2 = true;
                costo += B2.getValor();
                tvCosto.setText(Integer.toString(costo));
            }
            else {
                B2.setSeperado(false);
                b2.setImageResource(R.drawable.silla);
                sb2 = false;
                costo = costo - B2.getValor();
                tvCosto.setText(Integer.toString(costo));
            }
        }
        else if (view.getId() == R.id.imageViewb3 && B3.getReservado() == false){
            if (sb3 == false){
                B3.setSeperado(true);
                b3.setImageResource(R.drawable.sillaa);
                sb3 = true;
                costo += B3.getValor();
                tvCosto.setText(Integer.toString(costo));
            }
            else {
                B3.setSeperado(false);
                b3.setImageResource(R.drawable.silla);
                sb3 = false;
                costo = costo - B3.getValor();
                tvCosto.setText(Integer.toString(costo));
            }
        }
        else if (view.getId() == R.id.imageViewc1 && C1.getReservado() == false){
            if (sc1 == false){
                C1.setSeperado(true);
                c1.setImageResource(R.drawable.sillaa);
                sc1 = true;
                costo += C1.getValor();
                tvCosto.setText(Integer.toString(costo));
            }
            else {
                C1.setSeperado(false);
                c1.setImageResource(R.drawable.silla);
                sc1 = false;
                costo = costo - C1.getValor();
                tvCosto.setText(Integer.toString(costo));
            }
        }
        else if (view.getId() == R.id.imageViewd1 && D1.getReservado() == false){
            if (sd1 == false){
                D1.setSeperado(true);
                d1.setImageResource(R.drawable.sillaa);
                sd1 = true;
                costo += D1.getValor();
                tvCosto.setText(Integer.toString(costo));
            }
            else {
                D1.setSeperado(false);
                d1.setImageResource(R.drawable.silla);
                sd1 = false;
                costo = costo - D1.getValor();
                tvCosto.setText(Integer.toString(costo));
            }
        }
        else if (view.getId() == R.id.imageViewd2 && D2.getReservado() == false){
            if (sd2 == false){
                D2.setSeperado(true);
                d2.setImageResource(R.drawable.sillaa);
                sd2 = true;
                costo += D2.getValor();
                tvCosto.setText(Integer.toString(costo));
            }
            else {
                D2.setSeperado(false);
                d2.setImageResource(R.drawable.silla);
                sd2 = false;
                costo = costo - D2.getValor();
                tvCosto.setText(Integer.toString(costo));
            }
        }
        else if (view.getId() == R.id.imageViewd3 && D3.getReservado() == false){
            if (sd3 == false){
                D3.setSeperado(true);
                d3.setImageResource(R.drawable.sillaa);
                sd3 = true;
                costo += D3.getValor();
                tvCosto.setText(Integer.toString(costo));
            }
            else {
                D3.setSeperado(false);
                d3.setImageResource(R.drawable.silla);
                sd3 = false;
                costo = costo - D3.getValor();
                tvCosto.setText(Integer.toString(costo));
            }
        }
        else if (view.getId() == R.id.imageViewe1 && E1.getReservado() == false){
            if (se1 == false){
                E1.setSeperado(true);
                e1.setImageResource(R.drawable.sillaa);
                se1 = true;
                costo += E1.getValor();
                tvCosto.setText(Integer.toString(costo));
            }
            else {
                E1.setSeperado(false);
                e1.setImageResource(R.drawable.silla);
                se1 = false;
                costo = costo - E1.getValor();
                tvCosto.setText(Integer.toString(costo));
            }
        }
        else if (view.getId() == R.id.imageViewe2 && E2.getReservado() == false){
            if (se2 == false){
                E2.setSeperado(true);
                e2.setImageResource(R.drawable.sillaa);
                se2 = true;
                costo += E2.getValor();
                tvCosto.setText(Integer.toString(costo));
            }
            else {
                E2.setSeperado(false);
                e2.setImageResource(R.drawable.silla);
                se2 = false;
                costo = costo - E2.getValor();
                tvCosto.setText(Integer.toString(costo));
            }
        }
        else if (view.getId() == R.id.imageViewe3 && E3.getReservado() == false){
            if (se3 == false){
                E3.setSeperado(true);
                e3.setImageResource(R.drawable.sillaa);
                se3 = true;
                costo += E3.getValor();
                tvCosto.setText(Integer.toString(costo));
            }
            else {
                E3.setSeperado(false);
                e3.setImageResource(R.drawable.silla);
                se3 = false;
                costo = costo - E3.getValor();
                tvCosto.setText(Integer.toString(costo));
            }
        }
        else if (view.getId() == R.id.buttonRes3Compra){
            if ((switch1.isChecked() || switch2.isChecked() || switch3.isChecked()) && costo > 0 && user.getSaldo() >= costo){

                String asientos = "";
                Transferencia estado = new Transferencia();

                int numeroAleatorio = (int) (Math.random()*100+1);

                if(A1.getSeperado() == true){
                    A1.setReservado(true);
                    a1.setImageResource(R.drawable.sillar);
                    asientos += A1.getId() + ",";
                }
                if(A2.getSeperado() == true){
                    A2.setReservado(true);
                    a2.setImageResource(R.drawable.sillar);
                    asientos += A2.getId() + ",";
                }
                if(A3.getSeperado() == true){
                    A3.setReservado(true);
                    a3.setImageResource(R.drawable.sillar);
                    asientos += A3.getId() + ",";
                }
                if(B1.getSeperado() == true){
                    B1.setReservado(true);
                    b1.setImageResource(R.drawable.sillar);
                    asientos += B1.getId() + ",";
                }
                if(B2.getSeperado() == true){
                    B2.setReservado(true);
                    b2.setImageResource(R.drawable.sillar);
                    asientos += B2.getId() + ",";
                }
                if(B3.getSeperado() == true){
                    B3.setReservado(true);
                    b3.setImageResource(R.drawable.sillar);
                    asientos += B3.getId() + ",";
                }
                if(C1.getSeperado() == true){
                    C1.setReservado(true);
                    c1.setImageResource(R.drawable.sillar);
                    asientos += C1.getId() + ",";
                }
                if(D1.getSeperado() == true){
                    D1.setReservado(true);
                    d1.setImageResource(R.drawable.sillar);
                    asientos += D1.getId() + ",";
                }
                if(D2.getSeperado() == true){
                    D2.setReservado(true);
                    d2.setImageResource(R.drawable.sillar);
                    asientos += D2.getId() + ",";
                }
                if(D3.getSeperado() == true){
                    D3.setReservado(true);
                    d3.setImageResource(R.drawable.sillar);
                    asientos += D3.getId() + ",";
                }
                if(E1.getSeperado() == true){
                    E1.setReservado(true);
                    e1.setImageResource(R.drawable.sillar);
                    asientos += E1.getId() + ",";
                }
                if(E2.getSeperado() == true){
                    E2.setReservado(true);
                    e2.setImageResource(R.drawable.sillar);
                    asientos += E2.getId() + ",";
                }
                if(E3.getSeperado() == true){
                    E3.setReservado(true);
                    e3.setImageResource(R.drawable.sillar);
                    asientos += E3.getId() + ",";
                }

                estado.setA1(A1);
                estado.setA2(A2);
                estado.setA3(A3);
                estado.setB1(B1);
                estado.setB2(B2);
                estado.setB3(B3);
                estado.setC1(C1);
                estado.setD1(D1);
                estado.setD2(D2);
                estado.setD3(D3);
                estado.setE1(E1);
                estado.setE2(E2);
                estado.setE3(E3);

                bund = true;

                Reserva facturacion = new Reserva(asientos, Integer.toString(numeroAleatorio));

                Intent intent = new Intent(ReservaP3Activity.this, FacturaActivity.class);

                user.setSaldo(user.getSaldo() - costo);

                Bundle bundle = new Bundle();
                bundle.putSerializable("Usuario", user);
                bundle.putSerializable("Factura", facturacion);
                bundle.putSerializable("Estado", estado);


                intent.putExtras(bundle);
                asientos = "";
                startActivity(intent);
            }
            else{
                Toast.makeText(ReservaP3Activity.this, "Asegure que selecciona un horario, alguna silla por lo menos y que pueda pagar el costo de la reserva", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
