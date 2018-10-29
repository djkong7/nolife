package ast;

import visitor.Visitor;

public class NENode extends BinaryNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
