package ast;

import visitor.Visitor;

public class AssignmentNode extends BinaryNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
