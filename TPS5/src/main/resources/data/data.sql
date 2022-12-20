insert into admins 
values (1, 'admin@gmail.com', 'admin', '', 'admin');

INSERT INTO Categorie(nom)
VALUES ('Ultra legers'),
    ('Avion legers'),
    ('Avion d affaire'),
    ('Avion de ligne');


insert into avion
values (
        default,
        'MA-1230',
        '600',
        '2019-05-12',
        '1.jpg',
        1
    );
insert into avion
values (
        default,
        'MA-4560',
        '750',
        '2022-10-20',
        '2.jpg',
        2
    );
insert into avion
values (
        default,
        'MA-7890',
        '800',
        '2022-04-02',
        '3.jpg',
        3
    );
insert into avion
values (
        default,
        'MA-0010',
        '1000',
        '2022-04-02',
        '4.jpg',
        4
    );
insert into Pilote(nom)
values ('Jean'),
    ('Paul');
Insert into degreetat
values (default, 'Bonne Condition'),
    (default, 'Haute Condition'),
    (default, 'Moyenne Condition'),
    (default, 'Mauvaise Condition'),
    (default, 'Mediocre');
insert into avionentravail
values (
        default,
        1,
        1,
        '2022-11-19 08:00:00',
        '2022-11-19 18:00:00',
        12
    );
--INSERT INTO AvionEnTravail VALUES (default,2,1,'2022-11-05 10:00:00','2022-11-05 23:00:00',1000);
INSERT INTO AvionEnTravail
VALUES (
        default,
        1,
        1,
        '2022-11-05 10:00:00',
        '2022-11-05 23:00:00',
        1500
    );
INSERT INTO AvionEnTravail
VALUES (
        default,
        2,
        2,
        '2022-11-05 10:00:00',
        '2022-11-05 23:00:00',
        1800
    );
INSERT INTO AvionEnTravail
VALUES (
        default,
        3,
        1,
        '2022-11-06 10:00:00',
        '2022-11-06 23:00:00',
        1400
    );
INSERT INTO AvionEnTravail
VALUES (
        default,
        4,
        2,
        '2022-11-06 10:00:00',
        '2022-11-06 23:00:00',
        1200
    );
Insert into etatphysique
values (1, 'Changement Moteur', 1);
Insert into etatphysique
values (2, 'Changement Pneu', 2);
Insert into etatphysique
values (3, 'Changement Liquide ref', 3);
Insert into etatphysique
values (4, 'Changement Huile', 4);
INSERT into kilometrageAvion
VALUES (
        default,
        2,
        '2022-11-05 10:00:00',
        15.5,
        255.5,
        1200
    );
INSERT into kilometrageAvion
VALUES (
        default,
        1,
        '2022-11-06 10:00:00',
        10.5,
        300.5,
        1200
    );
INSERT into kilometrageAvion
VALUES (
        default,
        3,
        '2022-11-06 10:00:00',
        5.5,
        225.5,
        1250
    );
INSERT into kilometrageAvion
VALUES (
        default,
        4,
        '2022-11-07 10:00:00',
        20.5,
        400.5,
        1000
    );
Insert into assuranceavion
values (
        1,
        '2022-10-19 08:00:00',
        '2023-10-19 08:00:00',
        100000
    );
Insert into assuranceavion
values (
        2,
        '2022-10-10 10:00:00',
        '2023-10-10 10:00:00',
        150000
    );
Insert into assuranceavion
values (
        3,
        '2022-10-20 06:00:00',
        '2023-10-20 06:00:00',
        200000
    );
Insert into assuranceavion
values (
        4,
        '2022-10-21 15:00:00',
        '2023-10-21 15:00:00',
        1000000
    );
Insert into EntretienAvion
values(1, 1, '2022-12-20');
Insert into EntretienAvion
values(2, 1, '2022-12-25');
Insert into EntretienAvion
values(3, 1, '2022-12-27');
Insert into EntretienAvion
values(4, 1, '2022-12-28');