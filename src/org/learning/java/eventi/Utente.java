package org.learning.java.eventi;

public class Utente {


    //DUE TIPI DI UTENTI:
    //ORGANIZZATORE - COMPRATORE;
    String tipo;

    public Utente(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
