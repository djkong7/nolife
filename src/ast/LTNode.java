package ast;

import visitor.Visitor;

public class LTNode extends BinaryNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
