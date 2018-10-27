package ast;

import visitor.Visitor;

public class AddNode extends BinaryNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
