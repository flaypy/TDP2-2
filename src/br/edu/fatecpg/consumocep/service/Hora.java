package br.edu.fatecpg.consumocep.service;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Hora {
    public static String obterHoraZona() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        ZonedDateTime hora = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        return dtf.format(hora);
    }
}
