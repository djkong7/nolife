package ast;

import visitor.Visitor;

public class IdDeclNode extends ASTNode{

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
