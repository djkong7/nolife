package ast;

import visitor.Visitor;

public class SubProgDeclNode extends ASTNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
