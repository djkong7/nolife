package ast;

import visitor.Visitor;

public class BracketNode extends ASTNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
