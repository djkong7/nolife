PROGRAM func;

VAR c :INTEGER;

FUNCTION b(x,y:INTEGER;z:FLOAT) : INTEGER;

  BEGIN
    RETURN x+y
  END;

BEGIN
  c := b(1,1,2.0)
END
