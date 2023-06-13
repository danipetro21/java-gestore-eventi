package org.learning.java.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Evento {

    private String titolo;
    private int postiTotali;
    private int postiPrenotati;
    private LocalDate data;

    public Evento(String titolo, int postiTotali, LocalDate data) {
        this.postiPrenotati = 0;
        this.titolo = titolo;
        this.postiTotali = postiTotali;
        this.data = data;
    }


    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getPostiTotali() {
        return postiTotali;
    }

    public int getPostiPrenotati() {
        return postiPrenotati;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }


    public void prenota(LocalDate dataP) {
        boolean isAfter = data.isAfter(dataP);
        if (!isAfter || postiTotali<postiPrenotati) {
            System.out.println("Mi dispiace ma l'evento è già passato o non sono disponibili i posti che hai prenotato!");
        } else {
            postiPrenotati ++;
            postiTotali -= postiPrenotati;
            System.out.println("Prenotazione avvenuta con successo!!");
        }
    }

    public void disdici(LocalDate dataP) {
        boolean isAfter = data.isAfter(dataP);
        if (!isAfter || postiPrenotati < 0) {
            System.out.println("Mi dispiace ma l'evento è già passato o non ci sono prenotazioni");
        } else {
            postiPrenotati --;
            postiTotali ++;
            System.out.println("Evento disdetto con successo");
        }
    }

    @Override
    public String toString() {
        return "Titolo evento: " + titolo + '\n' +
                "Data evento: " + data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + '\n' + "Posti prenotati: " + postiPrenotati + '\n' + "Posti disponibili: " + postiTotali + '\n';
    }
}
