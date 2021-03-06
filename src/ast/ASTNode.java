package ast;

import java.util.ArrayList;
import java.util.List;

import visitor.Visitor;

public abstract class ASTNode {
	protected List<ASTNode> children = new ArrayList<ASTNode>();
	protected String label;
	protected int lineNumber;
	
	public ASTNode() {
		label = "";
		lineNumber = -1;
	}
	
	public abstract void accept(Visitor v);
	
	public ASTNode addChild(ASTNode c) {
		children.add(c);
		return this;
	}
	
	public ASTNode addLabel(String label) {
		this.label = label;
		return this;
	}
	
	public List<ASTNode> getChildren() {
		return children;
	}
	
	public ASTNode getChild(int index) {
		return children.get(index);
	}
	
	public String getLabel() {
		return label;
	}
	
	//@Override
	//public String toString() {
	//	return "Test of null pointer";
	//}
	
	public ASTNode addLineNumber(int num) {
		lineNumber = num;
		return this;
	}
	
	public int getLineNumber() {
		return lineNumber;
	}

}
