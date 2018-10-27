package ast;

public class ASTNodeFactory {
	public ASTNode makeASTNode(String nodeType) {
		if (nodeType == "ProgramNode") {
			return new ProgramNode();
		} else if (nodeType == "DeclNode") {
			return new DeclNode();
		} else if (nodeType == "VarDeclNode") {
			return new VarDeclNode();
		} else if (nodeType == "IdDeclNode") {
			return new IdDeclNode();
		} else if (nodeType == "IntTypeNode") {
			return new IntTypeNode();
		} else if (nodeType == "FloatTypeNode") {
			return new FloatTypeNode();
		} else if (nodeType == "CharTypeNode") {
			return new CharTypeNode();
		} else if (nodeType == "ArrayTypeNode") {
			return new ArrayTypeNode();
		} else if (nodeType == "MinArrayNode") {
			return new MinArrayNode();
		} else if (nodeType == "MaxArrayNode") {
			return new MaxArrayNode();
		} else if (nodeType == "CmpStmtNode") {
			return new CmpStmtNode();
		} else if (nodeType == "StmtNode") {
			return new StmtNode();
		} else {
			return null;
		}
	}
}
