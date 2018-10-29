package ast;

import visitor.Visitor;

public class ParamListNode extends ASTNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
