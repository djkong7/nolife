package ast;

import visitor.Visitor;

public class OrNode extends BinaryNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
