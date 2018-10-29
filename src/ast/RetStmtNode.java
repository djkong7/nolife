package ast;

import visitor.Visitor;

public class RetStmtNode extends ASTNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
