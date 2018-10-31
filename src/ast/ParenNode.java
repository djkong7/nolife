package ast;

import visitor.Visitor;

public class ParenNode extends ASTNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
