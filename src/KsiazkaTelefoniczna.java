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
    public static class Okno extends JFrame
    {
        Okno()
        {
            JFrame frame = new JFrame();
            frame.setResizable(false);
            frame.setTitle("super okno");
            frame.setSize(800,600);
            frame.setLocation(100,100);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            //----------------------------------------------
            JPanel kontakt1 = new JPanel();
            kontakt1.setBounds(100,50, 600,100);
            kontakt1.setBackground(Color.yellow);
            kontakt1.setVisible(true);

            //----------------------------------------------
            JLabel label = new JLabel("kontakt nr: 1", SwingConstants.CENTER);
            label.setVisible(true);
            label.setBounds(350,350,100,10);
            JLabel label2 = new JLabel("kontakt nr: 2", SwingConstants.CENTER);
            label2.setVisible(true);
            label2.setBounds(350,100,100,10);
            frame.add(label);
            frame.add(label2);
            frame.add(kontakt1);
            // y: +150
            //----------------------------------------------
            JPanel kontakt2 = new JPanel();
            kontakt2.setBounds(100,200,600,100);
            kontakt2.setBackground(Color.red);
            kontakt2.setVisible(true);
            frame.add(kontakt2);
            //----------------------------------------------
            JPanel kontakt3 = new JPanel();
            kontakt3.setBounds(100,350,600,100);
            kontakt3.setBackground(Color.green);
            kontakt3.setVisible(true);
            frame.add(kontakt3);
            //----------------------------------------------
            JPanel tlo = new JPanel();
            tlo.setBackground(Color.gray);
            tlo.setVisible(true);
            frame.add(tlo);

        }
    }
    public static void main(String[] args) throws IOException {
        new Okno();
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

