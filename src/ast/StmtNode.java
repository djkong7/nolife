package ast;

import visitor.Visitor;

public class StmtNode extends ASTNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
