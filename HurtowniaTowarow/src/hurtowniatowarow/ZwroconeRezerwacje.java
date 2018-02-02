/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hurtowniatowarow;

/**
 * Klasa pozwalająca na utworzenie obiektów wykorzystywanych na liscie w HisatoryOfReservation
 * @author student
 */
public class ZwroconeRezerwacje {
    String id_zamowienia;
    String towar;
    String ilosc;
    String cena;
    String data;
    /**
     * Konstruktor klasy pozwalający zainicjować wartosci pól obiektu klasy
     * @param id_zamowienia id zamowienia z bazy danych
     * @param towar nazwa zamóweionego towaru z bazy danych
     * @param ilosc ilość zamowieonego towaru z bazy danych
     * @param cena cena zamowieonego towaru z bazy danych
     * @param data data zamowienia towaru z bazy danych
     */
    public ZwroconeRezerwacje(String id_zamowienia,String towar,String ilosc,String cena,String data){
        this.id_zamowienia=id_zamowienia;
        this.towar=towar;
        this.ilosc=ilosc;
        this.cena=cena;
        this.data=data;
     }
    /**
     * getter zwracający id zamowienia
     * @return 
     */
    public String getId_zamowienia(){
        return this.id_zamowienia;
    }
    /**
     * getter zwracający nazwę towaru
     * @return 
     */
    public String getTowar(){
        return this.towar;
    }
    /**
     * getter zwracający ilość towaru
     * @return 
     */
    public String getIlosc(){
        return this.ilosc;
    }
    /**
     * getter zwracający cenę towaru
     * @return 
     */
    public String getCena(){
        return this.cena;
    }
    
}

