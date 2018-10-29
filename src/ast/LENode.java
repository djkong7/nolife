package ast;

import visitor.Visitor;

public class LENode extends BinaryNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
