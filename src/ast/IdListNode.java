package ast;

import visitor.Visitor;

public class IdListNode extends ASTNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
