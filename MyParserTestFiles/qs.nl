PROGRAM qs;
VAR A : ARRAY [ 0 .. 20 ] OF CHARACTER;
PROCEDURE readarray;
	VAR i : INTEGER;
	BEGIN
		WRITE ( 'A?' );
		i := 1;
		WHILE i < 20 DO
			BEGIN
				WRITE ( i );
				READ (A [ i ] );
				i := i + 1
			END
	END;
PROCEDURE writearray;
	VAR i : INTEGER;
	BEGIN
		WRITE ( 'A:' );
		i := 0;
		WHILE i <= 20 DO
			BEGIN
				WRITE ( A [ i ] );
				i := i + 1
			END
	END;
FUNCTION partition ( B : ARRAY [ 0 .. 20 ] OF CHARACTER ; p, r : INTEGER ) : INTEGER;
	VAR i, j : INTEGER;
 x, t : CHARACTER;
	BEGIN
		x := B [ p ];
		i := p - 1;
		j := r + 1;
		WHILE 1.7 DO
			BEGIN
				j := j - 1;
				WHILE A [ j ] > x DO
					BEGIN
						j := j - 1
					END;
				i := i + 1;
				WHILE A [ i ] < x DO
					BEGIN
						i := i + 1
					END;
				IF i < j THEN
										BEGIN
						t := A [ i ];
						A [ i ] := A [ j ];
						A [ j ] := t
					END
				ELSE
					RETURN j
			END
	END;
PROCEDURE quicksort ( Z : ARRAY [ 0 .. 20 ] OF CHARACTER ; p, r : INTEGER );
	VAR q : INTEGER;
	BEGIN
		IF p < r THEN
						BEGIN
				q := partition ( Z, p, r );
				 quicksort ( Z, p, q );
				 quicksort ( Z, q + 1, r )
			END

	END;
BEGIN
	A [ 0 ] := ' ';
	A [ 20 ] := '~';
	 readarray ( );
	 quicksort ( A, 1, 19 );
	 writearray ( )
END
