package org.learning.java.eventi;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Evento cinema = new Evento("Fast X", 500, LocalDate.parse("2016-06-12"));

        cinema.prenota(LocalDate.parse("2016-06-11"));

        cinema.disdici(LocalDate.parse("2016-06-11"));

        System.out.println(cinema.toString());



    }

}
