DELIMITER //

CREATE TRIGGER set_single
BEFORE INSERT ON songs FOR EACH ROW
BEGIN

IF NEW.album_id is NULL 
	THEN
        SET NEW.is_single=1;
    ELSE
    	SET NEW.is_single=0;
END IF;

END; //

DELIMITER ;