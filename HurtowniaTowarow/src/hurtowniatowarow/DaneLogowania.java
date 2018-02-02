/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hurtowniatowarow;

/**
 * Klasa mogąca zawierać dane logowania klienta do bazy
 * @author Patryk
 */
public class DaneLogowania {
    String login;
    String haslo;
    /**
     * Konstruktor dwuargumentowy pobierający login i hasło klienta
     * @param login
     * @param haslo 
     */
    public DaneLogowania(String login, String haslo){
        this.login=login;
        this.haslo=haslo;
    }
    /**
     * getter umożliwiający pobranie loginu
     * @return 
     */
    public String getLogin(){
        return this.login;
    }
    /**
     * getter umożliwiający pobranie hasła
     * @return 
     */
     public String getPassword(){
        return this.haslo;
    }
}
