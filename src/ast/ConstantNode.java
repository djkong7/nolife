package ast;

import visitor.Visitor;

public class ConstantNode extends ASTNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
