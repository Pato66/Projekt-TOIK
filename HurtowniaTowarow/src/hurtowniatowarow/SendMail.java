/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hurtowniatowarow;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Klasa umożliwiająca wysyłanie emaili z powiadomieniami dla uzytkowników
 * @author Patryk
 */
public class SendMail {
     private static final String HOST = "smtp.gmail.com";
 private static final int PORT = 465;
 // Adres email osby która wysyła maila
 private  String FROM = "hurtowniatowarow@gmail.com";
 // Hasło do konta osoby która wysyła maila
 private  String PASSWORD = "$gothic66#.";
 // Adres email osoby do której wysyłany jest mail
 private  String TO = "jankow1990@o2.pl";
 // Temat wiadomości
 private  String SUBJECT = "Powiadomienie232";
 // Treść wiadomości
 private  String CONTENT = "To mój drugi mail wysłany za pomocą JavaMailAPI.";

 /**
  * Konstruktor bezargumentowy na potrzeby testów
  */
 public SendMail(){    
 }
 /**
  * Konstruktor trójargumentowy pozwalający przesłać na podany adres mail o podanym tytule i treści
  * @param adresOdbiorcy adres email odbiorcy wiadomości
  * @param tytul tytuł przesyłanej wiadomości
  * @param tresc tyreść w przesyłanej widomości
  */
 public SendMail(String adresOdbiorcy,String tytul, String tresc){
     TO=adresOdbiorcy;
     SUBJECT=tytul;
     CONTENT=tresc;
 }
 
 public static void main(String[] args) {
  try {
   new SendMail().send();
  } catch (MessagingException e) {
   e.printStackTrace();
  }
 }
/**
 * Metoda pozwalająca na wysłanie wiadomości do użytkownika
 * @throws MessagingException 
 */
 public void send() throws MessagingException {

  Properties props = new Properties();
  props.put("mail.transport.protocol", "smtps");
  props.put("mail.smtps.auth", "true");

  // Inicjalizacja sesji
  Session mailSession = Session.getDefaultInstance(props);

  // ustawienie debagowania, jeśli nie chcesz oglądać logów to usuń
  // linijkę poniżej lub zmień wartość na false
  mailSession.setDebug(true);

  // Tworzenie wiadomości email
  MimeMessage message = new MimeMessage(mailSession);
  message.setSubject(SUBJECT);
  message.setContent(CONTENT, "text/plain; charset=ISO-8859-2");
  message.addRecipient(Message.RecipientType.TO, new InternetAddress(TO));

  Transport transport = mailSession.getTransport();
  transport.connect(HOST, PORT, FROM, PASSWORD);

  // wysłanie wiadomości
  transport.sendMessage(message, message
    .getRecipients(Message.RecipientType.TO));
  transport.close();
 }
   
}
