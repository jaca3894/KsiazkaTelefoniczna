/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Scanner;


/**
 *
 * @author jaceknawrat
 */
public class KsiazkaTelefoniczna extends Metody
{
    public static Scanner sc = new Scanner(System.in);
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";


    public void dodajSluzbowy() throws IOException
    {
        super.dodajSluzbowy();
    }
    public static void main(String[] args) throws IOException {
        SwingUtilities.invokeLater(Okno.MyFrame::new);
        KsiazkaTelefoniczna ksiazka = new KsiazkaTelefoniczna();
        ksiazka.wybierzKsiazke();
        System.out.println( ANSI_CYAN + "KSIAZKA TELEFONICZNA"
                + ANSI_GREEN + " " +
                "\n" + ANSI_GREEN + "Aby dodac kontakt, wpisz" + ANSI_YELLOW + " dodaj. " + ANSI_RESET + " " +
                "\n" + ANSI_GREEN + "Aby dodaj kontakt z numerem sluzbowym, wpisz " + ANSI_YELLOW + "dodajSluzbowy. " + ANSI_RESET + " " +
                "\n" + ANSI_GREEN + "Aby usunac kontakt, wpisz " + ANSI_YELLOW + "usun. " + ANSI_RESET + " " +
                "\n" + ANSI_GREEN + "Aby edytowac kontakt, wpisz " + ANSI_YELLOW + "edytuj. "  + ANSI_RESET + " " +
                "\n" + ANSI_GREEN + "Aby wyswietlic cala ksiazke telefoniczna, wpisz " + ANSI_YELLOW + "ksiazka. " +  ANSI_RESET + " " +
                "\n" + ANSI_GREEN + "Aby wyszukac kontakt, wpisz " + ANSI_YELLOW + "wyszukaj. " +
                "\n" + ANSI_GREEN + "Aby wyswietlic kontakt, wpisz " + ANSI_YELLOW + "wyswietlWpis. " +  ANSI_GREEN +
                "\n" + ANSI_GREEN + "Aby zakonczyc dzialanie programu, wpisz " + ANSI_YELLOW + "wyjdz." + ANSI_RESET + "\n");
        String input;
        do
        {

            input = wpiszTekst();
            switch (input)
            {
                case "dodaj": dodaj(false, new JSONObject());   break;
                case "dodajSluzbowy": ksiazka.dodajSluzbowy(); break;
                case "ksiazka": ksiazka();     break;
                case "edytuj": edytuj();   break;
                case "usun":     usun(); break;
                case "wyszukaj": wyszukaj(); System.out.println(ANSI_RED + "Zakonczono operacje. Mozesz wpisywac funkcje ponownie." + ANSI_RESET);    break;
                case "wyswietlWpis": wyswietlwpis(); break;
                case "wyjdz": System.out.println(ANSI_RED + "Zakanczam dzialanie programu..." + ANSI_RESET); System.exit(0); break;
                default: System.out.println(ANSI_RED + "Wpisales niepoprawna funkcje." + ANSI_RESET); break;
            }
        }
        while (input != "wyjdz");
    }
}

