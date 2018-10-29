package ast;

import visitor.Visitor;

public class WhileStmtNode extends ASTNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
