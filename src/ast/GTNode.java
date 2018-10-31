package ast;

import visitor.Visitor;

public class GTNode extends BinaryNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
