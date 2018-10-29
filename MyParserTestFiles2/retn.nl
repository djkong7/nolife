PROGRAM cow;
VAR b : FLOAT;
PROCEDURE A ( b : INTEGER );
	BEGIN
		RETURN 1
	END;
FUNCTION B ( a : ARRAY [ 1 .. 20 ] OF INTEGER ) : INTEGER;
	VAR c : INTEGER;
	BEGIN
		a [ A ( 1 ) ] := c;
		 B ( a )
	END;
BEGIN
	b := 200;
	 A ( 100 )
END
