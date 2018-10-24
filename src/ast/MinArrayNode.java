package ast;

import visitor.Visitor;

public class MinArrayNode extends ASTNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
