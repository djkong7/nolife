package ast;

import visitor.Visitor;

public class DimNode extends ASTNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
