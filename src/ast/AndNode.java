package ast;

import visitor.Visitor;

public class AndNode extends BinaryNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
