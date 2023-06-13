package org.learning.java.eventi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //TEST

/*      Evento cinema = new Evento("Fast X", 500, LocalDate.parse("2016-06-12"));

        cinema.prenota(LocalDate.parse("2016-06-11"));

        cinema.disdici(LocalDate.parse("2016-06-11"));

        System.out.println(cinema.toString());*/

        String nomeE;
        int pren;
        int postiT;
        String dataE;
        String dataP;

        Scanner scan = new Scanner(System.in);
        System.out.println("Ciao! Crea un evento!");
        System.out.print("Inserisci il titolo dell'evento: ");
        nomeE = scan.nextLine();
        System.out.print("Inserisci il numero di posti totali dell'evento: ");
        postiT = Integer.parseInt(scan.nextLine());
        System.out.print("Inserisci la data dell'evento: ");
        dataE = scan.nextLine();

        Evento event = new Evento(nomeE, postiT, LocalDate.parse(dataE));

        System.out.println("Ora è il momento di prenotare");
        System.out.print("Quanti prenotazioni vuoi effettuare: ");
        pren = Integer.parseInt(scan.nextLine());
        System.out.print("Quale giorno vuoi prenotare: ");
        dataP = scan.nextLine();

        event.prenota(LocalDate.parse(dataP), pren);


        String scelta;
        System.out.print("Vuoi disdire qualche prenotazione: s/n ");
        scelta = scan.nextLine();

        switch (scelta) {
            case "s":
                System.out.println("quante prenotazioni vuoi disdire: ");
                int prenD = Integer.parseInt(scan.nextLine());
                System.out.println("Che giorno hai prenotato");
                String dataD = scan.nextLine();

                event.disdici(LocalDate.parse(dataD), prenD);

                break;
            default:
                System.out.println("arrivederci!!");
                break;
        }


        System.out.println(event.toString());

    }

}
