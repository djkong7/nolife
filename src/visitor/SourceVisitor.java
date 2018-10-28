package visitor;

import java.util.ArrayList;
import java.util.List;

import ast.*;

public class SourceVisitor implements Visitor{
	
	private String src;
	private String tabStack;
	
	public SourceVisitor() {
		super();
		src = "";
		tabStack = "";
	}
	
	public String getSrc() {
		return src;
	}
	
	//Here to remove errors from unvisited node types
	//Just here for development
	@Override
	public void visit(ASTNode astNode) {
		
	}

	/*****************Variable Declarations*******************/
	@Override
	public void visit(ProgramNode programNode){
		src += "PROGRAM " + programNode.getLabel() + ";\n";
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
		src += tabStack + "VAR ";
		
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
		src += ": "+intTypeNode.getLabel() + ";\n";
	}
	
	/*****************Compound Statement*******************/
	
	@Override
	public void visit(CmpStmtNode compoundStatementNode) {
		src += tabStack + "BEGIN\n";
		tabStack += "\t";
		for(ASTNode node: compoundStatementNode.getChildren()) {
			node.accept(this);
		}
		//Remove the last ;
		src = src.substring(0, src.length() - 2) + "\n";
		//Remove a tab
		tabStack = tabStack.substring(0, tabStack.length()-1);
		src += tabStack + "END\n";
	}
	
	@Override
	public void visit(StmtNode statementNode) {
		for(ASTNode node: statementNode.getChildren()) {
			node.accept(this);
		}
		src += ";\n";
	}
	
	@Override
	public void visit(AssignmentNode assignmentNode) {
		assignmentNode.getLeft().accept(this);
		src += " :=";
		assignmentNode.getRight().accept(this);
	}
	
	@Override
	public void visit(IdDefNode idDefinitionNode) {
		src += tabStack + idDefinitionNode.getLabel();
	}
	
	@Override
	public void visit(ExpNode expressionNode) {
		for(ASTNode node: expressionNode.getChildren()) {
			node.accept(this);
		}
	}
	
	@Override
	public void visit(IdRefNode idReferenceNode) {
		src += " " + idReferenceNode.getLabel();
	}
	
	@Override
	public void visit(FactorNode factorNode) {
		for(ASTNode node: factorNode.getChildren()) {
			node.accept(this);
		}
	}
	
	@Override
	public void visit(MulNode multiplicationNode) {
		multiplicationNode.getLeft().accept(this);
		src += " *";
		multiplicationNode.getRight().accept(this);
	}
	
	@Override
	public void visit(ModNode modNode) {
		modNode.getLeft().accept(this);
		src += " MOD";
		modNode.getRight().accept(this);
	}
	
	@Override
	public void visit(AddNode addNode) {
		addNode.getLeft().accept(this);
		src += " +";
		addNode.getRight().accept(this);
	}
	
	@Override
	public void visit(SubNode subNode) {
		subNode.getLeft().accept(this);
		src += " -";
		subNode.getRight().accept(this);
	}
	
	@Override
	public void visit(ConstantNode constantNode) {
		src += " " + constantNode.getLabel();
	}
	
	@Override
	public void visit(ParenNode parenNode) {
		src += " " + parenNode.getLabel();
	}
	
	@Override
	public void visit(NotNode notNode) {
		src += " " + notNode.getLabel();
	}
	
	@Override
	public void visit(ExpListNode expressionListNode) {
		for(ASTNode node: expressionListNode.getChildren()) {
			node.accept(this);
		}
	}

}

























