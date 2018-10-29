PROGRAM cow;
VAR b : ARRAY [ 1 .. 2 ] OF CHARACTER;
PROCEDURE A ( a : INTEGER );
	BEGIN
		 A ( B ( 100 ) )
	END;
FUNCTION B ( a : INTEGER ) : CHARACTER;
	VAR d : INTEGER;
	BEGIN
		 C ( 1, 1, 1, 1, 1, 1, 1 );
		RETURN B ( B ( d ) )
	END;
PROCEDURE C ( a, b, c, d : INTEGER ; e, f, g : FLOAT );
	BEGIN
		a := b + c + d;
		e := f + g;
		 C ( 1, 1, 1, 1, 1.1, 1.1, 1.1 )
	END;
BEGIN
	 C ( 1, 2, 3, 4.0, 5.0, 6.0 );
	 C ( 1, 2, 3, 4, 5.0, 6.0, 7.0, 'a' );
	 C ( 1, 2, 3, 4, 5, 6, 7 );
	 C ( 1, 2, 3, 4, 5.0, 6.0, b [ 1 ] );
	b [ 1 ] := B ( b [ 2 ] )
END
