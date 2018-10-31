package ast;

import visitor.Visitor;

public class IdRefNode extends ASTNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
