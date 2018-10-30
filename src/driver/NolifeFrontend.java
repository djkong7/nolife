package driver;
/**
 * 
 */


import java.io.FileNotFoundException;
import java.io.FileReader;

import parser.NolifeParser;
import parser.ParseException;

import ast.ASTNode;
import visitor.*;

/**
 * @author carr
 * 
 */
public class NolifeFrontend extends Frontend {

	@Override
	public void parseFile(String fileName) throws FileNotFoundException {
		
	    FileReader nolifeFile = new FileReader(fileName);
	    NolifeParser parser = new NolifeParser(nolifeFile);
		try {
			ASTNode node = NolifeParser.program();
			//For source visitor.
			SourceVisitor sv = new SourceVisitor();
			//node.accept(sv);
			//System.out.println("Program is:\n\n" + sv.getSrc());
			
			//For print visitor.
			PrintVisitor pv = new PrintVisitor();
			node.accept(pv);
			System.out.println("AST is:\n\n" + pv.getSrc());
			
			//For type checker visitor.
			TypeCheckerVisitor tv = new TypeCheckerVisitor();
			node.accept(tv);
			//System.out.println("Errors are:\n\n:" + tv.getSrc());
			
		} catch (ParseException e) {
			System.err.println("Syntax Error in " + fileName + ": " + e);
			System.exit(-1);
		}
		System.out.println(fileName + " parsed successfully!");
	}

}
