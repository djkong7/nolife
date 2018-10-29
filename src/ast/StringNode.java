package ast;

import visitor.Visitor;

public class StringNode extends ASTNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
