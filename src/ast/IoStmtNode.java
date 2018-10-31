package ast;

import visitor.Visitor;

public class IoStmtNode extends ASTNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
