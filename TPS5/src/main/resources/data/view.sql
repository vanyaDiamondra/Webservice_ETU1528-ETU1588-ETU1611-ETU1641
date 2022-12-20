create or replace view v_AdminToken as
    select admins.*, token, EXPIRATION_DATE
    from tokenAdmin
    join admins on admins.id = tokenAdmin.idAdmin;

-- A Rectifier

CREATE OR REPLACE VIEW v_Etatavion as
Select v.*,etp.*,de.intitule as etatphysique,calculassuranceavion(v.id) as etatassurance
from avion v, EtatPhysique etp
join avionenTravail vet
     on vet.id = etp.avionentravailid
join Degreetat de
     on de.id = etp.degreetatid;

create or replace view v_dernierekilometrage as
        select (kilometrageavion.finkm - kilometrageavion.debutkm) as distance_parcourue ,kilometrageavion.carburantdepense,
               v_Etatavion.*
        from kilometrageavion join avionentravail 
        on kilometrageavion.avionEnTravailid =  avionentravail.id 
        join v_Etatavion on avionentravail.Avionid = v_Etatavion.id join
        Categorie on v_Etatavion.Categorieid = Categorie.id
        ORDER BY horaire DESC ;


     CREATE OR REPLACE VIEW v_ExpiredInOneMonth as
    select * from v_Etatavion 
    join assuranceavion on v_Etatavion.id = assuranceavion.avionid
    where 
    (dateexpiration - current_date) >= 28 and (dateexpiration - current_date) <= 31;


CREATE OR REPLACE VIEW v_ExpiredInThreeMonth as
    select * from v_Etatavion 
    join assuranceavion on v_Etatavion.id = assuranceavion.avionid
    where 
    (dateexpiration - current_date) >= 88 and (dateexpiration - current_date) <= 91;


