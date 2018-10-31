package ast;

import visitor.Visitor;

public class ExpNode extends ASTNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
