package org.learning.java.eventi;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;

public class Gestionale {

    public static void run() throws IOException {
        input();
    }

    public static void input() throws IOException {

        Scanner scan = new Scanner(System.in);
        System.out.println("CIAO!");
        System.out.println("Che tipo di utente sei?: organizzatore / compratore ");
        String tipo = scan.nextLine();

        if (tipo.equals("organizzatore")) {
            organizzatoreIn();
        } else if (tipo.equals("compratore")) {
            compratoreIn();
        } else {
            System.out.println("Tipo di utente non valido");
        }

    }


    public static void organizzatoreIn() {
        String dataE;
        Scanner scan = new Scanner(System.in);
        System.out.print("Inserisci il titolo del programma: ");
        String nomeP = scan.nextLine();
        System.out.println("Quanti eventi deve avere: " + nomeP);
        int numerEv = Integer.parseInt(scan.nextLine());

        ProgramEventi p = new ProgramEventi(nomeP);

        for (int i = 0; i < numerEv; i++) {
            System.out.print("Inserisci il titolo dell'evento: ");
            String nomeE = scan.nextLine();
            System.out.print("Inserisci il numero di posti totali dell'evento: ");
            int postiT = Integer.parseInt(scan.nextLine());
            System.out.print("Inserisci la data dell'evento: ");
            dataE = scan.nextLine();
            Evento event = new Evento(nomeE, postiT, LocalDate.parse(dataE));

            p.addEvent(event);
        }
        Helper.scritturaSuFile(p.getListaEventi());
    }


    public static void compratoreIn() {
        int pren;
        String dataP;
        Scanner scan = new Scanner(System.in);
        System.out.println("Quale evento vuoi prenotare dalla lista: ");
        ArrayList<Evento> listaEventi = Helper.readFile("eventi.json");
        System.out.println(listaEventi);
        String sceltaE = scan.nextLine();

        for (int i = 0; i < listaEventi.size(); i++) {
            if (listaEventi.get(i).getTitolo().equals(sceltaE)) {
                System.out.println("EVENTO TROVATO!");
                System.out.println("Ora è il momento di prenotare");
                System.out.print("Quante prenotazioni vuoi effettuare: ");
                pren = Integer.parseInt(scan.nextLine());
                for (int j = 0; j < pren; j++) {
                    System.out.print("Quale giorno vuoi prenotare: ");
                    dataP = scan.nextLine();
                    if (listaEventi.get(i).getData().isAfter(LocalDate.parse(dataP))) {
                        System.out.println("Data disponibile");
                        listaEventi.get(i).prenota(LocalDate.parse(dataP));
                        System.out.println(listaEventi.get(i).toString());
                    } else {
                        System.out.println("Data non disponibile");
                    }
                }
            }
        }

        System.out.print("Vuoi disdire qualche prenotazione: s/n ");
        String scelta = scan.nextLine();

        switch (scelta) {
            case "s":
                System.out.println("quante prenotazioni vuoi disdire: ");
                int prenD = Integer.parseInt(scan.nextLine());
                System.out.println("Che giorno hai prenotato");
                String dataD = scan.nextLine();
                for (int i = 0; i < prenD; i++) {
                    listaEventi.get(i).disdici(LocalDate.parse(dataD));
                    System.out.println(listaEventi.get(i).toString());
                }
                break;
            default:
                System.out.println("RIEPILOGO: ");
                for (int i = 0; i < listaEventi.size(); i++) {
                    System.out.println("Titolo evento: " + listaEventi.get(i).getTitolo());
                    System.out.println("Hai prenotato: " + listaEventi.get(i).getPostiPrenotati());
                }

                System.out.println("arrivederci!!");
                break;
        }
    }
}
