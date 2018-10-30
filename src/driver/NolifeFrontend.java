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
			//SourceVisitor v = new SourceVisitor();
			
			//For print visitor.
			PrintVisitor v = new PrintVisitor();
			node.accept(v);
			
			
			//System.out.println("Program is:\n\n" + v.getSrc());
			System.out.println(v.getSrc());
		} catch (ParseException e) {
			System.err.println("Syntax Error in " + fileName + ": " + e);
			System.exit(-1);
		}
		System.out.println(fileName + " parsed successfully!");
	}

}
