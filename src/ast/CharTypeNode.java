package ast;

import visitor.Visitor;

public class CharTypeNode extends ASTNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
