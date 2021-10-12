package com.example.apptranporterva;

public class Asiento {

    private String id;
    private boolean reservado;
    private boolean seperado;
    private int valor;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public boolean isReservado() {
        return reservado;
    }
    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    public boolean isSeperado() {
        return seperado;
    }
    public void setSeperado(boolean seperado) {
        this.seperado = seperado;
    }

    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }

    public Asiento(String id) {
        setId(id);
        setReservado(false);
        setSeperado(false);
        setValor(10000);
    }
}
