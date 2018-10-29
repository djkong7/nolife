package ast;

import visitor.Visitor;

public class EQNode extends BinaryNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
