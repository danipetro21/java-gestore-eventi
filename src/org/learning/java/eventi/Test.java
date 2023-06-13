package org.learning.java.eventi;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Test {

    public static void main(String[] args) {
/*
        BigDecimal price = new BigDecimal("10.45");
        Concerto con = new Concerto("prova", 200, LocalDate.parse("2020-05-21"), LocalTime.parse("20:12"), price);


        System.out.println(con.toString());*/

        //test array list programma 1

        ProgramEventi p1 = new ProgramEventi("Programma 1");
        Evento evento1 = new Evento("evento1", 200, LocalDate.parse("2020-05-21"));
        Evento evento2 = new Evento("evento2", 100, LocalDate.parse("2020-05-21"));
        Evento evento3 = new Evento("evento3", 500, LocalDate.parse("2018-06-23"));
        Evento evento4 = new Evento("evento4", 50, LocalDate.parse("2022-02-27"));


        p1.addEvent(evento1);
        p1.addEvent(evento2);
        p1.addEvent(evento3);
        p1.addEvent(evento4);
        p1.getProgrammaList();


        //test programma 2

        ProgramEventi p2 = new ProgramEventi("Programma 2");
        Evento evento5 = new Evento("evento5", 100, LocalDate.parse("2022-05-22"));
        Evento evento6 = new Evento("evento6", 500, LocalDate.parse("2022-05-22"));
        Evento evento7 = new Evento("evento7", 10, LocalDate.parse("2015-06-10"));
        Evento evento8 = new Evento("evento8", 20, LocalDate.parse("2016-02-05"));


        p2.addEvent(evento5);
        p2.addEvent(evento6);
        p2.addEvent(evento7);
        p2.addEvent(evento8);
        p2.getProgrammaList();







/*        System.out.println(p.getListaEventi());

*//*        p.getListaEventiByData(LocalDate.parse("2020-05-21"));*//*

        System.out.println("Numero di eventi in lista: " + p.numerEventi());

        p.destroyListaEventi();

        System.out.println("Lista aggiornata " + p.getListaEventi());*/





    }
}
