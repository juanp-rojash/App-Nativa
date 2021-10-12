package com.example.apptranporterva;

public class Reserva {

    private Asiento[] sillas;
    private String id;
    private int costo;

    public Asiento[] getSillas() {
        return sillas;
    }
    public void setSillas(Asiento[] sillas) {
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

    public Reserva(Asiento[] sillas, String id) {
        int suma = 0;

        setSillas(sillas);
        setId(id);

        for(int i=0; i<sillas.length; i++){
            suma += sillas[i].getValor();
        }

        setCosto(suma);
    }
}
