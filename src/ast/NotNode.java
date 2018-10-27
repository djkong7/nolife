package ast;

import visitor.Visitor;

public class NotNode extends ASTNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
