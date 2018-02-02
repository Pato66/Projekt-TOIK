CREATE TABLE Adresy(
 "id_adresu" Bigint NOT NULL,
 "kraj" Character varying(20) NOT NULL,
 "wojewodztwo" Character varying(20),
 "miejscowosc" Character varying(30) NOT NULL,
 "ulica" Character varying(30) NOT NULL,
 "nr_domu" Character varying(10) NOT NULL
);

ALTER TABLE Adresy ADD CONSTRAINT "Key2" PRIMARY KEY (id_adresu);


CREATE TABLE Klienci(
 "id_klienta" Bigint NOT NULL,
 "login" Character varying(20) NOT NULL,
 "haslo" Character varying(20) NOT NULL,
 "imie" Character varying(20) NOT NULL,
 "nazwisko" Character varying(30) NOT NULL,
 "email" Character varying(20) NOT NULL,
 "id_adresu" Bigint NOT NULL
);

ALTER TABLE Klienci ADD CONSTRAINT "Key1" PRIMARY KEY (id_klienta);
ALTER TABLE Klienci ADD CONSTRAINT "fk1"  FOREIGN KEY(id_adresu) REFERENCES Adresy(id_adresu);

CREATE TABLE Towary(
 "id_towaru" Bigint NOT NULL,
 "nazwa_towaru" Character varying(30) NOT NULL,
 "ilosc" Bigint NOT NULL,
 "cena" Numeric(6,2) NOT NULL
);

ALTER TABLE Towary ADD CONSTRAINT "Key6" PRIMARY KEY (id_towaru);

CREATE TABLE Zamowienia(
 "id_zamowienia" Bigint NOT NULL,
 "id_klienta" Bigint NOT NULL,
 "data_zamowienia" Date NOT NULL,
 "statusy" Character varying(20) NOT NULL
);

ALTER TABLE Zamowienia ADD CONSTRAINT "Key8" PRIMARY KEY (id_zamowienia,id_klienta);

CREATE TABLE Szczegoly_zamowienia(
 "id_zamowienia" Bigint NOT NULL,
 "id_towaru" Bigint NOT NULL,
 "id_klienta" Bigint NOT NULL,
 "ilosc" Bigint NOT NULL,
 "cena" Numeric(6,2) NOT NULL
);

ALTER TABLE Szczegoly_zamowienia ADD CONSTRAINT "Key11" PRIMARY KEY (id_zamowienia,id_towaru,id_klienta);
