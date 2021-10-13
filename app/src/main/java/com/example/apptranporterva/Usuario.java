package com.example.apptranporterva;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String nombre;
    private String correo;
    private String password;
    private int saldo;
    private String celular;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public int getSaldo() {
        return saldo;
    }
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Usuario(String nombre, String correo, String password, String celular) {
        setNombre(nombre);
        setCorreo(correo);
        setPassword(password);
        setCelular(celular);
        setSaldo(0);
    }
}
