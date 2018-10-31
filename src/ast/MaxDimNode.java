package ast;

import visitor.Visitor;

public class MaxDimNode extends ASTNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
