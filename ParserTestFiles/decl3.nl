{*This file tests the following error that can occur in
declarations.

[1] Variable declared but not referenced.

Note: There are multiple ways in which each of the 
above errors is tested in this file *}


 PROGRAM cow;
VAR 
    c:CHARACTER; {* error-variable declared but never referenced *}
    bd:INTEGER;

	FUNCTION C(a:INTEGER):CHARACTER;
        VAR  ba : CHARACTER;
	BEGIN
	RETURN ba {*error-parameter a declared but not used *}
	END; {*I'm not sure the above constitutes an error -- jr*}

	PROCEDURE E;
	VAR a,b1,c,d,e :ARRAY[1..2] OF INTEGER; {*only e referenced*}
	    f,g,h,i : INTEGER; {*all of these are referenced*}
	BEGIN
	WHILE h<100 DO i:=i+1;
	CASE f OF 1: b:=e[g] END
	END;

	FUNCTION D(a:INTEGER):CHARACTER;
        VAR  bc : CHARACTER;
	BEGIN
	a:=bc {*error no return statement *}
	END;
BEGIN
bd:=100 
END
