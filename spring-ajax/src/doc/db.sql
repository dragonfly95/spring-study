CREATE TABLE TB_CHAGYEBU (
    NUM      INT NOT NULL,
    "DATE"   CHAR(10),
    TYPE     CHAR(1),
    AMOUNT   INT,
    MILEAGE  INT,
    PRICE    INT,
    REPAIR   VARCHAR(512),
    COMPLETE CHAR(1),
    NOTE     VARCHAR2(512)
);

ALTER TABLE TB_CHAGYEBU ADD CONSTRAINT PK_CHAGYEBU PRIMARY KEY(NUM);
    
DECLARE
   P_NUM INT := 1;
   P_TYPE CHAR(1);
   P_COMPLETE CHAR(1);
BEGIN
    LOOP
        IF MOD(P_NUM, 2) = 0 THEN
            P_TYPE := 'R';
        ELSE
            P_TYPE := 'O';
        END IF;
        IF MOD(P_NUM, 3) = 0 THEN
            P_COMPLETE := 'Y';
        ELSE
            P_COMPLETE := 'N';
        END IF;

        INSERT INTO TB_CHAGYEBU (NUM,"DATE",TYPE,AMOUNT,MILEAGE,PRICE,REPAIR,COMPLETE,NOTE) VALUES (P_NUM,'2017-01-01',P_TYPE,25,2345,45000,'',P_COMPLETE,P_NUM);
        
        EXIT WHEN p_num >= 500;
        p_num := p_num + 1;
    END LOOP;
END;
/

COMMIT;