package org.learning.java.eventi;


import java.time.LocalDate;
import java.util.ArrayList;

public class ProgramEventi {

    private String titolo;
    ArrayList<Evento> listaEventi;


    public ProgramEventi(String titolo) {
        this.titolo = titolo;
        this.listaEventi = new ArrayList<Evento>();
    }


    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public ArrayList<Evento> getListaEventi() {
        return listaEventi;
    }

    public void setListaEventi(ArrayList<Evento> listaEventi) {
        this.listaEventi = listaEventi;
    }

    public void addEvent(Evento evento) {
        listaEventi.add(evento);
    }

    public void getListaEventiByData(LocalDate data) {

        ArrayList<Evento> eventiByData = new ArrayList<Evento>();
        int c = 0;
        for (int i = 0; i < listaEventi.size(); i++) {
            if (listaEventi.get(i).getData().equals(data)) {
                eventiByData.add(listaEventi.get(i));
                c++;
            }
        }
        if (c==0){
            System.out.println("Nessun evento trovato!");
        }
        System.out.println(eventiByData);

    }

    public int numerEventi(){
        return listaEventi.size();
    }

    public void destroyListaEventi(){
        listaEventi.clear();
    }

    public void getProgrammaList(){
        String str;
        System.out.println("Titolo programma: " + getTitolo());
        for (int i = 0; i < listaEventi.size(); i++) {
            str = "Data: " + listaEventi.get(i).getData() + " " +  "Titolo: "+ listaEventi.get(i).getTitolo();
            System.out.println(str);
        }
    }
}
