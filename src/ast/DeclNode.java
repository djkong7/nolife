package ast;

import visitor.Visitor;

public class DeclNode extends ASTNode{

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
