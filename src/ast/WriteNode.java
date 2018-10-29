package ast;

import visitor.Visitor;

public class WriteNode extends ASTNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
