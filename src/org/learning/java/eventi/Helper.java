package org.learning.java.eventi;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Helper {


    public static void scritturaSuFile(ArrayList<Evento> listaEventi) {
        try {
            JSONArray jsonArray = new JSONArray();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            for (Evento evento : listaEventi) {
                JSONObject eventoJSON = new JSONObject();
                eventoJSON.put("titolo", evento.getTitolo());
                eventoJSON.put("postiDisponibili", evento.getPostiTotali());
                eventoJSON.put("data", evento.getData().format(formatter));
                jsonArray.add(eventoJSON);
            }

            JSONObject programmaJSON = new JSONObject();
            programmaJSON.put("programma", jsonArray);

            FileWriter fileWriter = new FileWriter("eventi.json");
            fileWriter.write(programmaJSON.toJSONString());
            fileWriter.close();

            System.out.println("Scrittura completata.");
        } catch (IOException e) {
            System.out.println("Si è verificato un errore durante la scrittura del file.");
            e.printStackTrace();
        }
    }

    public static ArrayList<Evento> readFile(String nameList) {
        ArrayList<Evento> listaEventi = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(nameList);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);

            JSONArray eventoArray = (JSONArray) jsonObject.get("programma");
            for (Object obj : eventoArray) {
                JSONObject eventoJSON = (JSONObject) obj;
                String titolo = (String) eventoJSON.get("titolo");
                int postiDisponibili = Integer.parseInt(eventoJSON.get("postiDisponibili").toString());
                LocalDate data = LocalDate.parse(eventoJSON.get("data").toString());
                Evento evento = new Evento(titolo, postiDisponibili, data);
                listaEventi.add(evento);
            }

            fileReader.close();
        } catch (IOException | ParseException e) {
            System.out.println("Si è verificato un errore durante la lettura del file.");
            e.printStackTrace();
        }

        return listaEventi;
    }


}
