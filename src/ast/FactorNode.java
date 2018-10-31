package ast;

import visitor.Visitor;

public class FactorNode extends ASTNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
