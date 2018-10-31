package ast;

import visitor.Visitor;

public class ArgsNode extends ASTNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
