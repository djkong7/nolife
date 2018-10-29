package ast;

import visitor.Visitor;

public class SubProgNode extends ASTNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
