package ast;

import visitor.Visitor;

public class IfStmtNode extends ASTNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
