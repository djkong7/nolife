package visitor;

import ast.*;

public interface Visitor {
	void visit(ASTNode astNode);
	void visit(ProgramNode programNode);
	void visit(DeclNode declNode);
	void visit(VarDeclNode varDeclNode);
	void visit(IdDeclNode idDeclNode);
	void visit(IntTypeNode intTypeNode);
	void visit(CmpStmtNode compoundStatementNode);
	void visit(StmtNode statementNode);
	void visit(AssignmentNode assignmentNode);
	void visit(IdDefNode idDefinitionNode);
	void visit(IdRefNode idReferenceNode);
	void visit(ExpNode expressionNode);
	void visit(FactorNode factorNode);
	void visit(MulNode multiplicationNode);
	void visit(ModNode modNode);
	void visit(AddNode addNode);
	void visit(SubNode subNode);
	void visit(ConstantNode constantNode);
	void visit(ParenNode parenNode);
	void visit(NotNode notNode);
	
}
