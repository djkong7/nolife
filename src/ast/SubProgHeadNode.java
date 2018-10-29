package ast;

import visitor.Visitor;

public class SubProgHeadNode extends ASTNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
