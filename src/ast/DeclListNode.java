package ast;

import visitor.Visitor;

public class DeclListNode extends ASTNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
