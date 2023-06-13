package org.learning.java.eventi;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Test {

    public static void main(String[] args) {

        BigDecimal price = new BigDecimal("10.45");
        Concerto con = new Concerto("prova",200, LocalDate.parse("2020-05-21"), LocalTime.parse("20:12"), price);


        System.out.println(con.toString());
    }
}
