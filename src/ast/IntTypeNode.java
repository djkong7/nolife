package ast;

import visitor.Visitor;

public class IntTypeNode extends ASTNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
