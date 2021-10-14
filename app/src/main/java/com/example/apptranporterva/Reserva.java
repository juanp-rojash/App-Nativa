package com.example.apptranporterva;

import java.io.Serializable;

public class Reserva implements Serializable {

    private String sillas;
    private String id;
    private int costo;

    public String getSillas() {
        return sillas;
    }
    public void setSillas(String sillas) {
        this.sillas = sillas;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public int getCosto() {
        return costo;
    }
    public void setCosto(int costo) {
        this.costo = costo;
    }

    public Reserva(String sillas, String id) {
        int suma = 0;
        String[] separar = sillas.split(",");

        setSillas(sillas);
        setId(id);

        suma = separar.length * 10000;

        setCosto(suma);
    }
}
