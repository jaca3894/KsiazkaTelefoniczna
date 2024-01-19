import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;


public class Metody {
    public static Scanner sc = new Scanner(System.in);
    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    static String book;
    public void wybierzKsiazke()
    {
        System.out.println("Wybierz ksiazke ktora chcesz zaladowac (wpisz nazwe pliku json):");
        book = sc.next();

    }




//    public static void importujDane() throws IOException
//    {
//        // -------------------------------------------
//        int amount = imie.size();
//        int error_amount = 0;
//        System.out.println(amount);
//        try {
//            JSONParser parser = new JSONParser();
//            Object obj = parser.parse(new FileReader("ksiazka3.json"));
//            JSONArray array =  (JSONArray) obj;
//            int i = 0;
//            for (Object o: array)
//            {
//                JSONObject person = (JSONObject) array.get(i);
//                i++;
//
//                if ((String) person.get("imie") == null || (String) person.get("nazwisko") == null || (String) person.get("numerPierwszy") == null || (String) person.get("numerDrugi") == null || (String) person.get("numerTrzeci") == null || (String) person.get("miejscowosc") == null || (String) person.get("numerSluzbowy") == null)
//                {
//                    error_amount++;
//                    continue;
//                }
//                else
//                {
//                    imie.add((String) person.get("imie"));
//                    nazwisko.add((String) person.get("nazwisko"));
//                    numerTelefonu1.add((String) person.get("numerPierwszy"));
//                    numerTelefonu2.add((String) person.get("numerDrugi"));
//                    numerTelefonu3.add((String) person.get("numerTrzeci"));
//                    miejscowosc.add((String) person.get("miejscowosc"));
//                    sluzbowy.add((String) person.get("numerSluzbowy"));
//                }


//                System.out.println(amount);
//
//                System.out.println(imie.get(imie.size() - 1));
//                System.out.println(nazwisko.get(imie.size() - 1));
//                System.out.println(numerTelefonu1.get(imie.size() - 1));
//                System.out.println(numerTelefonu2.get(imie.size() - 1));
//                System.out.println(numerTelefonu3.get(imie.size() - 1));
//                System.out.println(sluzbowy.get(imie.size() - 1));
//                System.out.println(miejscowosc.get(imie.size() - 1));
//                kontakty.add("IMIE I NAZWISKO: " + imie.get(imie.size() - 1) + " " + nazwisko.get(imie.size() - 1) + ", MIEJSCOWOSC: " + miejscowosc.get(imie.size() - 1) + ", NUMERY TELEFONU:" + numerTelefonu1.get(imie.size() - 1)  + ", " + numerTelefonu2.get(imie.size() - 1) +  ", " + numerTelefonu3.get(imie.size() - 1) + ", SLUZBOWY: " + sluzbowy.get(imie.size() - 1) + ".");


//            }
//        } catch (IOException | ParseException | JSONException e) {
//            System.out.println(ANSI_RED +  "\nWystąpił błąd z plikiem JSON. Sprawdź ponownie dane i składnię pliku.\n" + ANSI_RESET);
//        }
//        zaktualizujWpis();
//        if (error_amount != 0) System.out.println(ANSI_RED + "Ilość pominiętych kontaktów spowodowanych pustym rekordem: " + error_amount + "." + ANSI_RESET);
//        System.out.println(ANSI_RED + "Zakonczono operacje. Mozesz wpisywac funkcje ponownie." + ANSI_RESET);
//    }
    public static void zapiszZmiany(JSONArray array)
    {
        try
        {
            BufferedWriter file = new BufferedWriter(new FileWriter("pomocniczy.json"));
            for (Object o: array)
            {
                file.write(array.toJSONString());
                file.close();
            }
        }
        catch (IOException e)
        {

        }
    }
    public static void zaktualizujWpis() throws IOException {
        try {
            // ------------------   JSON  --------------------

            JSONArray array;

            try {
                java.io.File plik = new java.io.File("pomocniczy.json");
                long len = 0;
                if (plik.length() == len)
                {
                    BufferedWriter file = new BufferedWriter(new FileWriter(book));
                    file.close();
                    return;
                }
                JSONParser parser = new JSONParser();

                Object obj = parser.parse(new FileReader("pomocniczy.json"));
                array = (JSONArray) obj;


                BufferedWriter file = new BufferedWriter(new FileWriter(book));
                file.write("[\n");
                int i = 0;
                for (Object o: array)
                {
                    JSONObject obiekt = (JSONObject) array.get(i);
                    file.write("\t{\n");
                    file.write("\t\t\"imie\":" + "\"" + obiekt.get("imie") + "\",\n");
                    file.write("\t\t\"nazwisko\":" + "\"" + obiekt.get("nazwisko") + "\",\n");
                    file.write("\t\t\"miejscowosc\":" + "\"" + obiekt.get("miejscowosc") + "\",\n");
                    file.write("\t\t\"numerPierwszy\":" + "\"" + obiekt.get("numerPierwszy") + "\",\n");
                    file.write("\t\t\"numerDrugi\":" + "\"" + obiekt.get("numerDrugi") + "\",\n");
                    file.write("\t\t\"numerTrzeci\":" + "\"" + obiekt.get("numerTrzeci") + "\",\n");
                    file.write("\t\t\"numerSluzbowy\":" + "\"" + obiekt.get("numerSluzbowy") + "\"\n");

                    if (i != (array.size() -1))
                    {
                        file.write("\t},\n");
                    }
                    else
                    {
                        file.write("\t}\n");
                    }
                    i++;
                }
                file.write("]\n");
                file.close();
            }
            catch(ParseException | IOException e)
            {

                System.out.println(ANSI_RED + "Wystąpił błąd z plikiem JSON. Sprawdź ponownie składnię pliku." + ANSI_RESET);

            }
        } catch (Exception e) {

        }
    }

    public static String wpiszTekst() {
        return sc.next();
    }

    public static int wpiszLiczbe() {
        while (true) {
            String input = sc.next();

            try {
                int number = Integer.parseInt(input);
                return number;
            } catch (NumberFormatException e) {
                System.out.println(ANSI_RED + "Niepoprawny format liczby. Spróbuj ponownie." + ANSI_RESET);
            }
        }
    }

    public static String wpiszNumerTelefonu() {
        while (true) {
            String input = sc.next();

            try {
                int number = Integer.parseInt(input);
                return input;
            } catch (NumberFormatException e) {
                System.out.println(ANSI_RED + "Niepoprawny format numeru telefonu. Spróbuj ponownie." + ANSI_RESET);
            }
        }
    }


    public void dodajSluzbowy() throws IOException {
        System.out.println(ANSI_YELLOW + "Wpisz sluzbowy numer:" + ANSI_RESET);
        JSONObject kontakt = new JSONObject();
        kontakt.put("numerSluzbowy", wpiszNumerTelefonu());
        dodaj(true, kontakt);
    }
    public static void dodaj(boolean check, JSONObject sluzbowy) throws IOException {
        try
        {
            FileWriter file = new FileWriter("pomocniczy.json");
            JSONArray array1;
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(book));
            array1 = (JSONArray) obj;
            JSONObject nowyKontakt = new JSONObject();
            if (check == false)
            {

                nowyKontakt.put("numerSluzbowy", "brak");
                System.out.println(ANSI_YELLOW + "Wpisz imie:" + ANSI_RESET);
                nowyKontakt.put("imie", wpiszTekst());
                System.out.println(ANSI_YELLOW +"Wpisz nazwisko:" + ANSI_RESET);
                nowyKontakt.put("nazwisko", wpiszTekst());
                System.out.println(ANSI_YELLOW +"Wpisz miejscowosc:" + ANSI_RESET);
                nowyKontakt.put("miejscowosc", wpiszTekst());
                System.out.println(ANSI_YELLOW +"Wpisz pierwszy numer telefonu:" + ANSI_RESET);
                nowyKontakt.put("numerPierwszy", wpiszNumerTelefonu());
                System.out.println(ANSI_YELLOW +"Wpisz drugi numer telefonu:" + ANSI_RESET);
                nowyKontakt.put("numerDrugi", wpiszNumerTelefonu());
                System.out.println(ANSI_YELLOW +"Wpisz trzeci numer telefonu:" + ANSI_RESET);
                nowyKontakt.put("numerTrzeci", wpiszNumerTelefonu());
                System.out.println(ANSI_RED + "Zakonczono operacje. Mozesz wpisywac funkcje ponownie." + ANSI_RESET);
                array1.add(nowyKontakt);
                file.write(nowyKontakt.toJSONString());
            }
            else
            {
                System.out.println(ANSI_YELLOW + "Wpisz imie:" + ANSI_RESET);
                sluzbowy.put("imie", wpiszTekst());
                System.out.println(ANSI_YELLOW +"Wpisz nazwisko:" + ANSI_RESET);
                sluzbowy.put("nazwisko", wpiszTekst());
                System.out.println(ANSI_YELLOW +"Wpisz miejscowosc:" + ANSI_RESET);
                sluzbowy.put("miejscowosc", wpiszTekst());
                System.out.println(ANSI_YELLOW +"Wpisz pierwszy numer telefonu:" + ANSI_RESET);
                sluzbowy.put("numerPierwszy", wpiszNumerTelefonu());
                System.out.println(ANSI_YELLOW +"Wpisz drugi numer telefonu:" + ANSI_RESET);
                sluzbowy.put("numerDrugi", wpiszNumerTelefonu());
                System.out.println(ANSI_YELLOW +"Wpisz trzeci numer telefonu:" + ANSI_RESET);
                sluzbowy.put("numerTrzeci", wpiszNumerTelefonu());
                System.out.println(ANSI_RED + "Zakonczono operacje. Mozesz wpisywac funkcje ponownie." + ANSI_RESET);
                array1.add(sluzbowy);
                file.write(array1.toJSONString());
            }

            zapiszZmiany(array1);
            zaktualizujWpis();

        }
        catch (IOException e)
        {
//            e.printStackTrace();
            System.out.println(ANSI_RED + "Wystąpił błąd z plikiem JSON. Sprawdź ponownie składnię pliku.");
            System.out.println(ANSI_RED + "Zakonczono operacje. Mozesz wpisywac funkcje ponownie." + ANSI_RESET);
        }
        catch (ParseException e)
        {
            FileWriter file = new FileWriter("pomocniczy.json");
            JSONArray array1 = new JSONArray();
            JSONObject nowyKontakt = new JSONObject();
            if (check == false)
            {

                nowyKontakt.put("numerSluzbowy", "brak");
                System.out.println(ANSI_YELLOW + "Wpisz imie:" + ANSI_RESET);
                nowyKontakt.put("imie", wpiszTekst());
                System.out.println(ANSI_YELLOW +"Wpisz nazwisko:" + ANSI_RESET);
                nowyKontakt.put("nazwisko", wpiszTekst());
                System.out.println(ANSI_YELLOW +"Wpisz miejscowosc:" + ANSI_RESET);
                nowyKontakt.put("miejscowosc", wpiszTekst());
                System.out.println(ANSI_YELLOW +"Wpisz pierwszy numer telefonu:" + ANSI_RESET);
                nowyKontakt.put("numerPierwszy", wpiszNumerTelefonu());
                System.out.println(ANSI_YELLOW +"Wpisz drugi numer telefonu:" + ANSI_RESET);
                nowyKontakt.put("numerDrugi", wpiszNumerTelefonu());
                System.out.println(ANSI_YELLOW +"Wpisz trzeci numer telefonu:" + ANSI_RESET);
                nowyKontakt.put("numerTrzeci", wpiszNumerTelefonu());
                System.out.println(ANSI_RED + "Zakonczono operacje. Mozesz wpisywac funkcje ponownie." + ANSI_RESET);
                array1.add(nowyKontakt);
                file.write(nowyKontakt.toJSONString());
            }
            else
            {
                System.out.println(ANSI_YELLOW + "Wpisz imie:" + ANSI_RESET);
                sluzbowy.put("imie", wpiszTekst());
                System.out.println(ANSI_YELLOW +"Wpisz nazwisko:" + ANSI_RESET);
                sluzbowy.put("nazwisko", wpiszTekst());
                System.out.println(ANSI_YELLOW +"Wpisz miejscowosc:" + ANSI_RESET);
                sluzbowy.put("miejscowosc", wpiszTekst());
                System.out.println(ANSI_YELLOW +"Wpisz pierwszy numer telefonu:" + ANSI_RESET);
                sluzbowy.put("numerPierwszy", wpiszNumerTelefonu());
                System.out.println(ANSI_YELLOW +"Wpisz drugi numer telefonu:" + ANSI_RESET);
                sluzbowy.put("numerDrugi", wpiszNumerTelefonu());
                System.out.println(ANSI_YELLOW +"Wpisz trzeci numer telefonu:" + ANSI_RESET);
                sluzbowy.put("numerTrzeci", wpiszNumerTelefonu());
                System.out.println(ANSI_RED + "Zakonczono operacje. Mozesz wpisywac funkcje ponownie." + ANSI_RESET);
                array1.add(sluzbowy);
                file.write(array1.toJSONString());
            }

            zapiszZmiany(array1);
            zaktualizujWpis();
        }
    }



    public static void ksiazka() {
        // POPRAWNA WERSJA Z OBSLUZONYMI BLEDAMI SKLADNI PLIKU


        java.io.File plik = new java.io.File(book);
        long len = 0;
        if (plik.length() == len)
        {
            System.out.println(ANSI_RED + "Nie ma czego wyswietlac. Ksiazka jest pusta/składnia pliku jest niepoprawna."+ ANSI_RESET);
            System.out.println(ANSI_RED + "Zakonczono operacje. Mozesz wpisywac funkcje ponownie." + ANSI_RESET);
            return;
        }


        int i = 0;
        JSONArray array = new JSONArray();
        try
        {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(book));
            array = (JSONArray) obj;

            if (array.size() == 0) {
                System.out.println(ANSI_RED + "Nie ma czego wyswietlic. Ksiazka jest pusta/składnia pliku jest niepoprawna."+ ANSI_RESET);
                System.out.println(ANSI_RED + "Zakonczono operacje. Mozesz wpisywac funkcje ponownie." + ANSI_RESET);
            }
            else
            {
                System.out.println(ANSI_YELLOW + "Lista wszystkich kontaktow:" + ANSI_RESET);
                for (Object o : array)
                {
                    JSONObject rekord = (JSONObject) array.get(i);
                    String kontakt = "IMIE I NAZWISKO: " + rekord.get("imie") + " " + rekord.get("nazwisko") + ", MIEJSCOWOSC: " + rekord.get("miejscowosc") + ", NUMERY TELEFONU: " + rekord.get("numerPierwszy")  + ", " + rekord.get("numerDrugi") +  ", " + rekord.get("numerTrzeci") + ", SLUZBOWY: " + rekord.get("numerSluzbowy") + ".";
                    System.out.println(kontakt);
                    i++;
                }
                System.out.println(ANSI_RED + "Zakonczono operacje. Mozesz wpisywac funkcje ponownie." + ANSI_RESET);

            }
        }
        catch (ParseException | IOException e)
        {
            System.out.println(ANSI_RED + "Wystąpił błąd z plikiem JSON. Sprawdź ponownie składnię pliku.");
            System.out.println(ANSI_RED + "Zakonczono operacje. Mozesz wpisywac funkcje ponownie." + ANSI_RESET);
        }
    }

//
    public static void edytuj()
    {
        java.io.File plik = new java.io.File(book);
        long len = 0;
        if (plik.length() == len)
        {
            System.out.println(ANSI_RED + "Nie ma czego edytowac. Ksiazka jest pusta/składnia pliku jest niepoprawna."+ ANSI_RESET);
            System.out.println(ANSI_RED + "Zakonczono operacje. Mozesz wpisywac funkcje ponownie." + ANSI_RESET);
        }
        else
        {
            boolean wykonajDalszeInstrukcje = true;JSONArray array;
            JSONParser parser = new JSONParser();
            Object obj = new Object();
            try {
                obj = parser.parse(new FileReader(book));
            } catch (IOException | ParseException e) {

            }

            array = (JSONArray) obj;

                System.out.println(ANSI_YELLOW + "Lista wszystkich kontaktow:" + ANSI_RESET);
                int i = 0;
                for (Object o : array)
                {
                    JSONObject rekord = (JSONObject) array.get(i);
                    String kontakt = "IMIE I NAZWISKO: " + rekord.get("imie") + " " + rekord.get("nazwisko") + ", MIEJSCOWOSC: " + rekord.get("miejscowosc") + ", NUMERY TELEFONU: " + rekord.get("numerPierwszy")  + ", " + rekord.get("numerDrugi") +  ", " + rekord.get("numerTrzeci") + ", SLUZBOWY: " + rekord.get("numerSluzbowy") + ".";
                    System.out.println(kontakt);
                    i++;
                }
                System.out.println(ANSI_YELLOW+ "Który z kontaktow chcesz edytowac? Wpisz jego numer. W przypadku wpisania tekstu wpisz ponownie." + ANSI_RESET);
                int wskaznik_edycji = 0;
                int retries = 0;
                boolean czyPoprawne = false;
                while(!czyPoprawne)
                {
                    try
                    {
                        wskaznik_edycji = Integer.parseInt(sc.nextLine());
                        wskaznik_edycji--;
                        czyPoprawne = true;
                        if (wskaznik_edycji >= array.size() || wskaznik_edycji < 0)
                        {
                            System.out.println(ANSI_RED + "Wpisales zbyt duza/zbyt mala  liczbe. Procedura rozpoczyna się od nowa."+ ANSI_RESET);
                            edytuj();
                            wykonajDalszeInstrukcje = false;
                        }
                        break;
                    }
                    catch (NumberFormatException n)
                    {
                       if (retries != 0)System.out.println(ANSI_RED + "Błąd odczytu danych"+ ANSI_RESET);
                       retries++;
                    }



                }
                if (wykonajDalszeInstrukcje)
                {
                    JSONObject kontaktDoEdycji = (JSONObject) array.get(wskaznik_edycji);
                    System.out.println(ANSI_YELLOW  + "Wpisz imie: \n Jesli nie chcesz nic zmieniac, wpisz 0" + ANSI_RESET);
                    String wpisanie;
                    wpisanie = wpiszTekst();
                    String a = "0";
                    if (!(Objects.equals(wpisanie, a)))
                    {
                        kontaktDoEdycji.replace("imie", wpisanie);
                    }
                    System.out.println(ANSI_YELLOW + "Wpisz nazwisko: \n Jesli nie chcesz nic zmieniac, wpisz 0" + ANSI_RESET);
                    wpisanie = wpiszTekst();
                    if (!(Objects.equals(wpisanie, a)))
                    {
                        kontaktDoEdycji.replace("nazwisko", wpisanie);
                    }

                    System.out.println(ANSI_YELLOW + "Wpisz miejscowosc: \n Jesli nie chcesz nic zmieniac, wpisz 0"+ ANSI_RESET);
                    wpisanie = wpiszTekst();
                    if (!(Objects.equals(wpisanie, a)))
                    {
                        kontaktDoEdycji.replace("miejscowosc", wpisanie);
                    }

                    System.out.println(ANSI_YELLOW + "Wpisz pierwszy numer telefonu: \n Jesli nie chcesz nic zmieniac, wpisz 0" + ANSI_RESET);
                    wpisanie = wpiszNumerTelefonu();
                    if (!(Objects.equals(wpisanie, a)))
                    {
                        kontaktDoEdycji.replace("numerPierwszy", wpisanie);
                    }

                    System.out.println(ANSI_YELLOW + "Wpisz drugi numer telefonu: \n Jesli nie chcesz nic zmieniac, wpisz 0"+ ANSI_RESET);
                    wpisanie = wpiszNumerTelefonu();
                    if (!(Objects.equals(wpisanie, a)))
                    {
                        kontaktDoEdycji.replace("numerDrugi", wpisanie);
                    }

                    System.out.println(ANSI_YELLOW + "Wpisz trzeci numer telefonu: \n Jesli nie chcesz nic zmieniac, wpisz 0" + ANSI_RESET);
                    wpisanie = wpiszNumerTelefonu();
                    if (!(Objects.equals(wpisanie, a)))
                    {
                        kontaktDoEdycji.replace("numerTrzeci", wpisanie);
                    }

                    System.out.println(ANSI_YELLOW + "Wpisz sluzbowy numer: \n Jesli nie chcesz nic zmieniac, wpisz 0" + ANSI_RESET);
                    wpisanie = wpiszNumerTelefonu();
                    if (!(Objects.equals(wpisanie, a)))
                    {
                        kontaktDoEdycji.replace("numerSluzbowy", wpisanie);
                    }
                    String kontakt = "IMIE I NAZWISKO: " + kontaktDoEdycji.get("imie") + " " + kontaktDoEdycji.get("nazwisko") + ", MIEJSCOWOSC: " + kontaktDoEdycji.get("miejscowosc") + ", NUMERY TELEFONU: " + kontaktDoEdycji.get("numerPierwszy")  + ", " + kontaktDoEdycji.get("numerDrugi") +  ", " + kontaktDoEdycji.get("numerTrzeci") + ", SLUZBOWY: " + kontaktDoEdycji.get("numerSluzbowy") + ".";
                    try{
                        zapiszZmiany(array);
                        zaktualizujWpis();
                    }
                    catch (IOException ioException)
                    {
                        System.out.println(ANSI_RED + "Błąd zapisywania do pliku!" + ANSI_RESET);
                    }
                    System.out.println(ANSI_YELLOW + "Zedytowano kontakt: " + kontakt + ANSI_RESET);
                    System.out.println(ANSI_RED + "Zakonczono operacje. Mozesz wpisywac funkcje ponownie."+ ANSI_RESET);
                }
            }

        }


    public static void wyszukaj()
    {
        java.io.File plik = new java.io.File(book);
        long len = 0;
        if (plik.length() == len)
        {
            System.out.println(ANSI_RED + "Nie ma czego usuwac. Ksiazka jest pusta/składnia pliku jest niepoprawna."+ ANSI_RESET);
            System.out.println(ANSI_RED + "Zakonczono operacje. Mozesz wpisywac funkcje ponownie." + ANSI_RESET);
            return;
        }
        else
        {
            JSONArray array;
            JSONParser parser = new JSONParser();
            Object obj = new Object();
            try {
                obj = parser.parse(new FileReader(book));
            } catch (IOException | ParseException e) {

            }

            array = (JSONArray) obj;
            System.out.println(ANSI_YELLOW + "Po czym chcesz wyszukac? \n po numerze telefonu - wpisz" + ANSI_GREEN + " numer, " +  ANSI_YELLOW +
                    "\n po miejscowosci - wpisz" + ANSI_GREEN +  " miejscowosc, " + ANSI_YELLOW+
                    "\n po imieniu - wpisz" + ANSI_GREEN +  " imie, " + ANSI_YELLOW +
                    "\n po nazwisku - wpisz" + ANSI_GREEN +  " nazwisko."+ ANSI_RESET);
            String imieString = "imie";
            String miejscowoscString = "miejscowosc";
            String nazwiskoString = "nazwisko";
            String numerString = "numer";


            String filtr = wpiszTekst();
            if (!(Objects.equals(filtr, imieString) || Objects.equals(filtr, nazwiskoString) || Objects.equals(filtr, miejscowoscString) || Objects.equals(filtr, numerString)))
            {
                System.out.println(ANSI_RED + "Wpisales niepoprawny parametr." + ANSI_RESET);
                wyszukaj();
            }
            else {
                System.out.println(ANSI_YELLOW + "Wpisz czego szukasz:" + ANSI_RESET);
                String szukanie = wpiszTekst();
                int ilosc_wynikow = 0;
                System.out.println(ANSI_YELLOW + "Wyniki:" + ANSI_RESET);
                JSONObject kontakt;
                switch (filtr) {
                    case "numer": {
                        for (int i = 0; i < array.size(); i++)
                        {
                            kontakt = (JSONObject) array.get(i);
                            String numer1 = (String) kontakt.get("numerPierwszy");
                            String numer2 = (String) kontakt.get("numerDrugi");
                            String numer3 = (String) kontakt.get("numerTrzeci");
                            String sluzbowyNumer = (String) kontakt.get("numerSluzbowy");


                            if (Objects.equals(szukanie, numer1) || Objects.equals(szukanie, numer2) || Objects.equals(szukanie, numer3) || Objects.equals(szukanie, sluzbowyNumer))
                            {

                                System.out.println("IMIE I NAZWISKO: " + kontakt.get("imie") + " " + kontakt.get("nazwisko") + ", MIEJSCOWOSC: " + kontakt.get("miejscowosc") + ", NUMERY TELEFONU: " + kontakt.get("numerPierwszy")  + ", " + kontakt.get("numerDrugi") +  ", " + kontakt.get("numerTrzeci") + ", SLUZBOWY: " + kontakt.get("numerSluzbowy") + ".");
                                ilosc_wynikow++;
                            }

                        }
                    } break;
                    case "miejscowosc":
                    {
                        for (int i = 0; i < array.size(); i++)
                        {
                            kontakt = (JSONObject) array.get(i);
                            if (Objects.equals(szukanie, kontakt.get("miejscowosc")))
                            {
                                System.out.println("IMIE I NAZWISKO: " + kontakt.get("imie") + " " + kontakt.get("nazwisko") + ", MIEJSCOWOSC: " + kontakt.get("miejscowosc") + ", NUMERY TELEFONU: " + kontakt.get("numerPierwszy")  + ", " + kontakt.get("numerDrugi") +  ", " + kontakt.get("numerTrzeci") + ", SLUZBOWY: " + kontakt.get("numerSluzbowy") + ".");
                                ilosc_wynikow++;
                            }
                        }
                    } break;
                    case "imie": {
                        for (int i = 0; i < array.size(); i++)
                        {
                            kontakt = (JSONObject) array.get(i);
                            if (Objects.equals(kontakt.get("imie"), szukanie))
                            {

                                System.out.println("IMIE I NAZWISKO: " + kontakt.get("imie") + " " + kontakt.get("nazwisko") + ", MIEJSCOWOSC: " + kontakt.get("miejscowosc") + ", NUMERY TELEFONU: " + kontakt.get("numerPierwszy")  + ", " + kontakt.get("numerDrugi") +  ", " + kontakt.get("numerTrzeci") + ", SLUZBOWY: " + kontakt.get("numerSluzbowy") + ".");
                                ilosc_wynikow++;

                            }
                        }
                    } break;
                    case "nazwisko":
                    {
                        for (int i = 0; i < array.size(); i++)
                        {
                            kontakt = (JSONObject) array.get(i);
                            if (Objects.equals(szukanie, kontakt.get("nazwisko")))
                            {
                                System.out.println("IMIE I NAZWISKO: " + kontakt.get("imie") + " " + kontakt.get("nazwisko") + ", MIEJSCOWOSC: " + kontakt.get("miejscowosc") + ", NUMERY TELEFONU: " + kontakt.get("numerPierwszy")  + ", " + kontakt.get("numerDrugi") +  ", " + kontakt.get("numerTrzeci") + ", SLUZBOWY: " + kontakt.get("numerSluzbowy") + ".");
                                ilosc_wynikow++;
                            }

                        }
                    } break;
                default:
                {
                    System.out.println(ANSI_RED + "Wpisales niepoprawny parametr." + ANSI_RESET);
                    wyszukaj();
                } break;
                }
                if (ilosc_wynikow == 0)
                {
                    System.out.println(ANSI_RED + "Nie znaleziono wyników." + ANSI_RESET);
                }
            }

        }
    }

    public static void usun()
    {
        java.io.File plik = new java.io.File(book);
        long len = 0;
        if (plik.length() == len)
        {
            System.out.println(ANSI_RED + "Nie ma czego usuwac. Ksiazka jest pusta/składnia pliku jest niepoprawna."+ ANSI_RESET);
            System.out.println(ANSI_RED + "Zakonczono operacje. Mozesz wpisywac funkcje ponownie." + ANSI_RESET);
            return;
        }
        JSONArray array = new JSONArray();
        try
        {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(book));
            array = (JSONArray) obj;

            if (array.size() == 0) {
                System.out.println(ANSI_RED + "Nie ma czego usuwac. Ksiazka jest pusta/składnia pliku jest niepoprawna."+ ANSI_RESET);
                System.out.println(ANSI_RED + "Zakonczono operacje. Mozesz wpisywac funkcje ponownie." + ANSI_RESET);
            }
            else
            {
                int i = 0;
                for (Object o : array)
                {
                    JSONObject rekord = (JSONObject) array.get(i);
                    String kontakt = "IMIE I NAZWISKO: " + rekord.get("imie") + " " + rekord.get("nazwisko") + ", MIEJSCOWOSC: " + rekord.get("miejscowosc") + ", NUMERY TELEFONU: " + rekord.get("numerPierwszy")  + ", " + rekord.get("numerDrugi") +  ", " + rekord.get("numerTrzeci") + ", SLUZBOWY: " + rekord.get("numerSluzbowy") + ".";
                    System.out.println(kontakt);
                    i++;
                }
                System.out.println(ANSI_YELLOW + "Ktory kontakt chcesz usunac? (wpisz jego numer) \n Jesli chcesz anulowac, wpisz 0. Po wpisaniu zera mozesz kontynuowac wpisywanie komend." + ANSI_RESET);





                int input = wpiszLiczbe();
                if (input == 0)
                {
                    System.out.println(ANSI_RED + "Zakonczono operacje. Mozesz wpisywac funkcje ponownie." + ANSI_RESET);
                    return;
                }
                if (input > array.size() || input < 1)
                {
                    System.out.println(ANSI_RED + "Wpisales zbyt duza/zbyt mala liczbe. Zakonczono operacje. Mozesz wpisywac funkcje ponownie." + ANSI_RESET);
                    return;
                }

                array.remove(input -1);

                int j = 0;
                for (Object o : array)
                {
                    JSONObject rekord = (JSONObject) array.get(j);
                    String kontakt = "IMIE I NAZWISKO: " + rekord.get("imie") + " " + rekord.get("nazwisko") + ", MIEJSCOWOSC: " + rekord.get("miejscowosc") + ", NUMERY TELEFONU: " + rekord.get("numerPierwszy")  + ", " + rekord.get("numerDrugi") +  ", " + rekord.get("numerTrzeci") + ", SLUZBOWY: " + rekord.get("numerSluzbowy") + ".";
                    System.out.println(kontakt);
                    j++;
                }
                System.out.println(ANSI_RED + "Zakonczono operacje. Mozesz wpisywac funkcje ponownie." + ANSI_RESET);
                zapiszZmiany(array);
                zaktualizujWpis();



            }
        }
        catch (ParseException | IOException e)
        {
            System.out.println(ANSI_RED + "Wystąpił błąd z plikiem JSON. Sprawdź ponownie składnię pliku.");
            System.out.println(ANSI_RED + "Zakonczono operacje. Mozesz wpisywac funkcje ponownie." + ANSI_RESET);
        }
    }


    public static void wyswietlwpis()
    {
        java.io.File plik = new java.io.File(book);
        long len = 0;
        if (plik.length() == len)
        {
            System.out.println(ANSI_RED + "Nie ma czego wyswietlac. Ksiazka jest pusta/składnia pliku jest niepoprawna."+ ANSI_RESET);
            System.out.println(ANSI_RED + "Zakonczono operacje. Mozesz wpisywac funkcje ponownie." + ANSI_RESET);
            return;
        }
        JSONArray array = new JSONArray();
        try
        {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(book));
            array = (JSONArray) obj;

            if (array.size() == 0) {
                System.out.println(ANSI_RED + "Nie ma czego wyswietlic. Ksiazka jest pusta/składnia pliku jest niepoprawna."+ ANSI_RESET);
                System.out.println(ANSI_RED + "Zakonczono operacje. Mozesz wpisywac funkcje ponownie." + ANSI_RESET);
            }
            else
            {
                System.out.println(ANSI_YELLOW + "Ktory kontakt chcesz wyswietlic? (np. 1, 2):" + ANSI_RESET);
                int wyswietl = 0;
                boolean czyPoprawne = false;
                while (!czyPoprawne)
                {
                    try
                    {
                        wyswietl = wpiszLiczbe();
                        wyswietl--;
                    }
                    catch (NumberFormatException exception)
                    {
                        System.out.println(ANSI_RED + "Wpisales niepoprawne dane" + ANSI_RESET);
                    }
                    if (wyswietl >= array.size() || wyswietl < 0)
                    {
                        System.out.println(ANSI_RED + "Wpisales zbyt duza/zbyt mala  liczbe. Procedura rozpoczyna się od nowa." + ANSI_RESET);
                        System.out.println(ANSI_YELLOW + "Ktory kontakt chcesz wyswietlic? (np. 1, 2):" + ANSI_RESET);
                        continue;
                    }
                    else
                    {
                        czyPoprawne = true;
                    }

                }
                if (czyPoprawne)
                {
                    JSONObject rekord = (JSONObject) array.get(wyswietl);
                    System.out.println(ANSI_GREEN + "Kontakt nr " + (wyswietl +1) + ":"+ ANSI_RESET);
                    String kontakt = "IMIE I NAZWISKO: " + rekord.get("imie") + " " + rekord.get("nazwisko") + ", MIEJSCOWOSC: " + rekord.get("miejscowosc") + ", NUMERY TELEFONU: " + rekord.get("numerPierwszy")  + ", " + rekord.get("numerDrugi") +  ", " + rekord.get("numerTrzeci") + ", SLUZBOWY: " + rekord.get("numerSluzbowy") + ".";
                    System.out.println(kontakt);
                    System.out.println(ANSI_RED + "Zakonczono operacje. Mozesz wpisywac funkcje ponownie." + ANSI_RESET);
                }
            }
        }
        catch (ParseException | IOException e)
        {
            System.out.println(ANSI_RED + "Wystąpił błąd z plikiem JSON. Sprawdź ponownie składnię pliku.");
            System.out.println(ANSI_RED + "Zakonczono operacje. Mozesz wpisywac funkcje ponownie." + ANSI_RESET);
        }


    }

}


