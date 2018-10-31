package ast;

import visitor.Visitor;

public class ExpListNode extends ASTNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
