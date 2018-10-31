package ast;

import visitor.Visitor;

public class StmtListNode extends ASTNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
