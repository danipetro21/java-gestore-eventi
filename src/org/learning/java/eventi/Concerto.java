package org.learning.java.eventi;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Concerto extends Evento{

    private LocalTime ora;
    private BigDecimal prezzo;

    public Concerto(String titolo, int postiTotali, LocalDate data, LocalTime ora, BigDecimal prezzo) {
        super(titolo, postiTotali, data);
        this.ora = ora;
        this.prezzo = prezzo;
    }

    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    public LocalDateTime formatedOra(){
        LocalDateTime dataOra;
        dataOra = this.getData().atTime(getOra());
        return dataOra;
    }

    public String formatedPrice(){
        DecimalFormat decimalFormat = new DecimalFormat("##.##€");
        String formattedNumber = decimalFormat.format(getPrezzo());
        return formattedNumber;
    }

    @Override
    public String toString() {
        return "Data e ora: " + formatedOra() + " - Titolo: " + getTitolo() + " - Prezzo: " + formatedPrice();
    }
}
