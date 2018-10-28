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
		} else if (nodeType == "AssignmentNode") {
			return new AssignmentNode();
		} else if (nodeType == "ExpListNode") {
			return new ExpListNode();
		} else if (nodeType == "ExpNode") {
			return new ExpNode();
		} else if (nodeType == "AddNode") {
			return new AddNode();
		} else if (nodeType == "SubNode") {
			return new SubNode();
		} else if (nodeType == "MulNode") {
			return new MulNode();
		} else if (nodeType == "ModNode") {
			return new ModNode();
		} else if (nodeType == "FactorNode") {
			return new FactorNode();
		} else if (nodeType == "IdRefNode") {
			return new IdRefNode();
		} else if (nodeType == "ConstantNode") {
			return new ConstantNode();
		} else if (nodeType == "ParenNode") {
			return new ParenNode();
		} else if (nodeType == "NotNode") {
			return new NotNode();
		} else if (nodeType == "IdDefNode") {
			return new IdDefNode();
		} else {
			return null;
		}
	}
}
