PROGRAM foo;
VAR a : INTEGER;
PROCEDURE decls ( a : INTEGER );
	BEGIN
		WRITE ( a );
		IF ( a > 0 ) THEN
			 decls ( a - 1 )
		ELSE
			a := 0
	END;
PROCEDURE foo ( a, b : INTEGER );
	BEGIN
		WRITE ( a );
		WRITE ( b )
	END;
BEGIN
	READ (a );
	 decls ( a );
	 foo ( a, 10 )
END
