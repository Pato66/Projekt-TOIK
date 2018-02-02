package hurtowniatowarow;

import java.util.ArrayList;
import java.util.List;
/**
 * Klasa pozwalająca przechowywać podstawowe dane o towarach z hurtownii
 * @author Patryk
 */
public class Towar {
    String nazwa;
    String ilosc;
    String cena;
    /**
     * Konstruktor trójargumentowy ustawiający podstawowe dane o towarze
     * @param a nazwa towaru
     * @param b ilośc towaru
     * @param c cena towaru
     */
    Towar(String a,String b,String c){
        nazwa=a;
        ilosc=b;
        cena=c;
    }
    /**
     * getter zwracający aktualny obiekt
     * @return 
     */
    Towar getTowar(){
        return this;
    }
//------------------------------------------------------------------------------
    /**
     * Pomocnicza metoda pozwalająca na zaokrąglanie liczby do podanej ilości miejsc po przecinku
     * @param n liczba do zaokrąglenia
     * @param k ilość miejsc po przecinku
     * @return 
     */
    public static double Round(double n,int k)
{
    double factor = Math.pow(10, k+1);
    n = Math.round(Math.round(n*factor)/10);
    return n/(factor/10);
}
//------------------------------------------------------------------------------
    /**
     * Metoda oblczająca całkowitą cenę towarów w koszyku klienta 
     * @param wyniki lista towarów w koszyku klienta
     * @return 
     */
public static double oblicz_sume(ArrayList<Towar> wyniki){   
    double suma=0.0;
    for(int j=0;j<wyniki.size();j++){
            suma+=(Double.parseDouble(wyniki.get(j).ilosc) * Double.parseDouble(wyniki.get(j).cena));
        }
        System.out.println("Przed: "+suma);
        suma=Towar.Round(suma,2);
        System.out.println(suma); 
        return suma;
    }
//------------------------------------------------------------------------------
/**
 * Metoda szukająca towaru o podanej nazwie wna liście towarów w koszyku
 * @param wyniki lista towarów w koszyku klienta
 * @param nazwa nazwa towaru, który jest poszukiwany
 * @param ilosc ilość towaru , który jest poszukiwany
 * @return 
 */
public static int seek(ArrayList<Towar> wyniki,String nazwa,String ilosc){
    int ktory=0;
    for(;ktory<wyniki.size()-1;ktory++){
        if(wyniki.get(ktory).nazwa == nazwa && wyniki.get(ktory).ilosc == ilosc){
            break;
        }
    }
    return ktory;        
    }

//------------------------------------------------------------------------------
/**
 * Metoda usuwająca wszystkie elementy z listy
 * @param wyniki 
 */
public static void removeAll(ArrayList<Towar> wyniki){
    int ktory=0;
    for(;ktory<wyniki.size()-1;ktory++){
       wyniki.remove(ktory);
    }       
}
}