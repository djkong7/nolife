package ast;

import visitor.Visitor;

public class MinDimNode extends ASTNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
