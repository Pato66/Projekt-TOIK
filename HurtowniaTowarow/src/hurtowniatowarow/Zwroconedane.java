/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hurtowniatowarow;

/**
 * Klasa umożliwaijąca tworzenie obiektow przechowujących podstawowe dane o kliencie
 * @author Mati
 */
public class Zwroconedane {
    String login;
    String haslo;
    String imie;
    String nazwisko;
    String email;
    String nrdomu;
    String ulica;
    String miejscowosc;
    String wojewodztwo;
    String kraj;
    /**
     * Konstruktor pozwalający zainicjalizować pola obiektu danymi klienta
     * @param login 
     * @param haslo
     * @param imie
     * @param nazwisko
     * @param email
     * @param nrdomu
     * @param ulica
     * @param miejscowosc
     * @param wojewodztwo
     * @param kraj 
     */
    public Zwroconedane(String login,String haslo,String imie,String nazwisko,String email,String nrdomu,String ulica,String miejscowosc,String wojewodztwo,String kraj){
        this.login=login;
        this.haslo=haslo;
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.email=email;
        this.nrdomu=nrdomu;
        this.ulica=ulica;
        this.miejscowosc=miejscowosc;
        this.wojewodztwo=wojewodztwo;
        this.kraj=kraj;
        
    }
    public String getLogin(){
        return this.login;
    }
     public String getHaslo(){
        return this.haslo;
    }
     public String getImie(){
        return this.imie;
    }
     public String getNazwisko(){
        return this.nazwisko;
    }
     public String getEmail(){
        return this.email;
    }
     public String getNrdomu(){
        return this.nrdomu;
    }
     public String getMiejscowosc(){
        return this.miejscowosc;
    }
     public String getWojewodztwo(){
        return this.wojewodztwo;
    }
     public String getKraj(){
        return this.kraj;
    }
    
}
