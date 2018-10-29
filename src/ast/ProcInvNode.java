package ast;

import visitor.Visitor;

public class ProcInvNode extends ASTNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
