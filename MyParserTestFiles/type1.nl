PROGRAM cow;
VAR b : ARRAY [ 1 .. 2 ] OF CHARACTER;
FUNCTION B ( a : INTEGER ; e : CHARACTER ) : CHARACTER;
	VAR c : INTEGER;
 d : FLOAT;
	BEGIN
		a := a + ( c * d ) * e;
		B := c + c * d;
		e := c < d;
		c := NOT d;
		c := NOT e;
		c := a AND d;
		c := e AND e;
		c := e < B ( a, e );
		c := c <> d;
		c := c >= e;
		c := B ( a, e ) = d;
		e := NOT c;
		e := a OR a;
		RETURN e
	END;
PROCEDURE complex;
	VAR a, b, c, d, e, f, g : FLOAT;
 i, j, k, l, m, n : INTEGER;
 w, x, y, z : ARRAY [ 1 .. 5 ] OF FLOAT;
 C1, C2, C3 : CHARACTER;
	BEGIN
		a := a + b + c + d + e;
		i := i * j * k + l * m;
		C1 := B ( i, C2 );
		a := a * i + b * j + c * k;
		i := a * b * c * i * j * k * e * f * l + m * a + d * n;
		a := B ( i + j + k * l, C2 ) <> C3;
		a := w [ B ( i, C1 ) > C2 ];
		a := 1;
		i := 1.2e5;
		C1 := 'Q';
		C2 := B ( i, B ( j, B ( k, C1 ) ) )
	END;
PROCEDURE complex2;
	VAR a, b, c, d, e, f, g : FLOAT;
 i, j, k, l, m, n : INTEGER;
 w, x, y, z : ARRAY [ 1 .. 5 ] OF FLOAT;
 C1, C2, C3 : CHARACTER;
	BEGIN
		C1 := B ( i + j + k * l, C2 ) + C3;
		a := b * c + d * C1 + e + f;
		C2 := a * b * c + j + i + k;
		i := ( B ( i, C2 ) > B ( j, C2 ) ) + ( B ( l, C3 ) > j )
	END;
BEGIN
	 complex ( );
	 complex2 ( );
	b [ 1 ] := 100
END
