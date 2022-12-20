Create or replace FUNCTION calculassuranceavion(id int)
    RETURNS VARCHAR
    LANGUAGE PLPGSQL AS $$
DECLARE
    datetocheck date;
        BEGIN
            Select dateexpiration
            from assuranceavion
            where avionid = id
            order by dateassurance desc
            INTO datetocheck;
            IF datetocheck < Now() THEN
                RETURN 'estExpire';
            ELSE
                RETURN 'estValide';
            END IF;
        END;
$$;


-- Ajouter Jointure EtatPhysique
