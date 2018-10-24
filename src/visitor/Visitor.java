package visitor;

import ast.*;

public interface Visitor {
	void visit(ASTNode astNode);
	void visit(ProgramNode programNode);
	void visit(DeclNode declNode);
	void visit(VarDeclNode varDeclNode);
	void visit(IdDeclNode idDeclNode);
	void visit(IntTypeNode intTypeNode);

}
