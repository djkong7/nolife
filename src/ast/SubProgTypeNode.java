package ast;

import visitor.Visitor;

public class SubProgTypeNode extends ASTNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
