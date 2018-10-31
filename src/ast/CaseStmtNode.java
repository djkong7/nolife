package ast;

import visitor.Visitor;

public class CaseStmtNode extends ASTNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
