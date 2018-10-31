package ast;

import visitor.Visitor;

public class CmpStmtNode extends ASTNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
