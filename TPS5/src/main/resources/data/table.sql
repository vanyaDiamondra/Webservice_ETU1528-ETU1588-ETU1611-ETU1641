create database avion;
GRANT ALL PRIVILEGES ON DATABASE avion to flotte;
ALTER DATABASE avion OWNER TO flotte;
\c avion flotte;

CREATE TABLE Pilote (
   id  SERIAL NOT NULL,
   nom varchar(255),
   PRIMARY KEY (id)
);

CREATE TABLE Admins (
    id        SERIAL NOT NULL,
    email varchar(45) not null,
    first_name varchar(20) not null,
    last_name varchar(20) not null,
    password varchar(64) not null,
    PRIMARY KEY(id)
);

CREATE TABLE Categorie (
   id  SERIAL NOT NULL,
   nom varchar(255),
   PRIMARY KEY (id)
);

CREATE TABLE Avion (
  id              SERIAL NOT NULL,
  immatriculation varchar(50),
  puissance       int4,
  dateObtention   date,
   photo varchar(50) not null,
  Categorieid     int4 NOT NULL,
  PRIMARY KEY (id)
);


CREATE TABLE AvionEnTravail (
   id              SERIAL NOT NULL,
   Avionid      int4 NOT NULL,
   Piloteid     int4 NOT NULL,
   debutHoraire    timestamp,
   finHoraire      timestamp,
   carburantDepart int4,
   PRIMARY KEY (id)
);

CREATE TABLE kilometrageAvion (
     id SERIAL not null,
     AvionEnTravailid int4 NOT NULL,
     horaire             timestamp,
     debutKM             float4,
     finKM               float4,
     carburantDepense    float4
);

CREATE TABLE AssuranceAvion (
   Avionid     int4 NOT NULL,
   dateAssurance  date,
   dateExpiration date,
   montant        float4
);

CREATE TABLE EntretienAvion (
   Avionid    int4 NOT NULL,
   Adminsid      int4 NOT NULL,
   dateEntretien date
);

CREATE TABLE EtatPhysique (
  AvionEnTravailid int4 NOT NULL,
  designation         varchar(255),
  DegreEtatid         int4 NOT NULL
);

CREATE TABLE DegreEtat (
   id       SERIAL NOT NULL,
   intitule varchar(255),
   PRIMARY KEY (id)
);

create table tokenAdmin(
    id serial not null,
    idAdmin int,
    token varchar(255),
    EXPIRATION_DATE timestamp
);

ALTER TABLE Avion ADD CONSTRAINT FKAvion917862 FOREIGN KEY (Categorieid) REFERENCES Categorie (id);
ALTER TABLE AvionEnTravail ADD CONSTRAINT FKAvionEn520593 FOREIGN KEY (Avionid) REFERENCES Avion (id);
ALTER TABLE AvionEnTravail ADD CONSTRAINT FKAvionEn865176 FOREIGN KEY (Piloteid) REFERENCES Pilote (id);
ALTER TABLE kilometrageAvion ADD CONSTRAINT FKkilometrag685613 FOREIGN KEY (AvionEnTravailid) REFERENCES AvionEnTravail (id);
ALTER TABLE AssuranceAvion ADD CONSTRAINT FKAssuranceV505391 FOREIGN KEY (Avionid) REFERENCES Avion (id);
ALTER TABLE EntretienAvion ADD CONSTRAINT FKEntretienV851264 FOREIGN KEY (Avionid) REFERENCES Avion (id);
ALTER TABLE EntretienAvion ADD CONSTRAINT FKEntretienV62758 FOREIGN KEY (Adminsid) REFERENCES Admins (id);
ALTER TABLE EtatPhysique ADD CONSTRAINT FKEtatPhysiq503557 FOREIGN KEY (AvionEnTravailid) REFERENCES AvionEnTravail (id);
ALTER TABLE EtatPhysique ADD CONSTRAINT FKEtatPhysiq598054 FOREIGN KEY (DegreEtatid) REFERENCES DegreEtat (id);


