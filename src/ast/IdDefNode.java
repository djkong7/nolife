package ast;

import visitor.Visitor;

public class IdDefNode extends ASTNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
