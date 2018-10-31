package ast;

import visitor.Visitor;

public class FloatTypeNode extends ASTNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
