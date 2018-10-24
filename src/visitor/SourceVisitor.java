package visitor;

import java.util.ArrayList;
import java.util.List;

import ast.*;

public class SourceVisitor implements Visitor{
	
	private String src;
	
	public SourceVisitor() {
		super();
		src = "";
	}
	
	public String getSrc() {
		return src;
	}
	
	//Here to remove errors from unvisited node types
	//Just here during development
	@Override
	public void visit(ASTNode astNode) {
		
	}

	@Override
	public void visit(ProgramNode programNode){
		for(ASTNode node: programNode.getChildren()) {
			node.accept(this);
		}
	}
	
	@Override
	public void visit(DeclNode declNode) {
		for(ASTNode node: declNode.getChildren()) {
			node.accept(this);
		}
	}
	
	@Override
	public void visit(VarDeclNode varDeclNode) {
		src += "VAR ";
		
		List<ASTNode> children = varDeclNode.getChildren();
		int length = children.size();
		for(int i = 0; i < length; i++) {
			children.get(i).accept(this);
			//Remove comma after last var id
			if(i==length-2) {
				src = src.substring(0, src.length() - 1);
				src += " ";
			}
			
		}
	}
	
	@Override
	public void visit(IdDeclNode idDeclNode) {
		src += idDeclNode.getLabel() + ",";
	}
	
	@Override
	public void visit(IntTypeNode intTypeNode) {
		src += ": "+intTypeNode.getLabel() + " \n";
	}
	
	

}
