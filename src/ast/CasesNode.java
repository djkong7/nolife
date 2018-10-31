package ast;

import visitor.Visitor;

public class CasesNode extends ASTNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
