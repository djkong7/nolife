package ast;

import visitor.Visitor;

public class ReadNode extends ASTNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
