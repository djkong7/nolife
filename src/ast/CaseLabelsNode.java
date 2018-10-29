package ast;

import visitor.Visitor;

public class CaseLabelsNode extends ASTNode {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
