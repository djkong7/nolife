package ast;

import visitor.Visitor;

public class ArrayTypeNode extends ASTNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
