package ast;

import visitor.Visitor;

public class SubNode extends BinaryNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
