package ast;

import visitor.Visitor;

public class ProgramNode extends ASTNode{

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	

}
