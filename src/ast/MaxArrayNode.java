package ast;

import visitor.Visitor;

public class MaxArrayNode extends ASTNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
