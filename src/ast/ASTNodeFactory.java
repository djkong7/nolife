package ast;

public class ASTNodeFactory {
	public ASTNode makeASTNode(String nodeType) {
		if (nodeType == "ProgramNode") {
			return new ProgramNode();
		} else if (nodeType == "DeclNode") {
			return new DeclNode();
		} else if (nodeType == "DeclListNode") {
			return new DeclListNode();
		} else if (nodeType == "IdListNode") {
			return new IdListNode();
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
		} else if (nodeType == "DimNode") {
			return new DimNode();
		} else if (nodeType == "MinDimNode") {
			return new MinDimNode();
		} else if (nodeType == "MaxDimNode") {
			return new MaxDimNode();
		} else if (nodeType == "SubProgDeclNode") {
			return new SubProgDeclNode();
		} else if (nodeType == "SubProgNode") {
			return new SubProgNode();
		} else if (nodeType == "SubProgHeadNode") {
			return new SubProgHeadNode();
		} else if (nodeType == "SubProgTypeNode") {
			return new SubProgTypeNode();
		} else if (nodeType == "ArgsNode") {
			return new ArgsNode();
		} else if (nodeType == "ParenNode") {
			return new ParenNode();
		} else if (nodeType == "ParamListNode") {
			return new ParamListNode();
		} else if (nodeType == "CmpStmtNode") {
			return new CmpStmtNode();
		} else if (nodeType == "StmtListNode") {
			return new StmtListNode();
		} else if (nodeType == "AssignmentNode") {
			return new AssignmentNode();
		} else if (nodeType == "IfStmtNode") {
			return new IfStmtNode();
		} else if (nodeType == "WhileStmtNode") {
			return new WhileStmtNode();
		} else if (nodeType == "ProcInvNode") {
			return new ProcInvNode();
		} else if (nodeType == "IoStmtNode") {
			return new IoStmtNode();
		} else if (nodeType == "ReadNode") {
			return new ReadNode();
		} else if (nodeType == "WriteNode") {
			return new WriteNode();
		} else if (nodeType == "RetStmtNode") {
			return new RetStmtNode();
		} else if (nodeType == "CaseStmtNode") {
			return new CaseStmtNode();
		} else if (nodeType == "CasesNode") {
			return new CasesNode();
		} else if (nodeType == "CaseElementNode") {
			return new CaseElementNode();
		} else if (nodeType == "CaseLabelsNode") {
			return new CaseLabelsNode();
		} else if (nodeType == "ExpListNode") {
			return new ExpListNode();
		} else if (nodeType == "ExpNode") {
			return new ExpNode();
		} else if (nodeType == "OrNode") {
			return new OrNode();
		} else if (nodeType == "AndNode") {
			return new AndNode();
		} else if (nodeType == "LTNode") {
			return new LTNode();
		} else if (nodeType == "LENode") {
			return new LENode();
		} else if (nodeType == "GTNode") {
			return new GTNode();
		} else if (nodeType == "GENode") {
			return new GENode();
		} else if (nodeType == "NENode") {
			return new NENode();
		} else if (nodeType == "EQNode") {
			return new EQNode();
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
		} else if (nodeType == "BracketNode") {
			return new BracketNode();
		} else if (nodeType == "IdRefNode") {
			return new IdRefNode();
		} else if (nodeType == "ConstantNode") {
			return new ConstantNode();
		} else if (nodeType == "NotNode") {
			return new NotNode();
		} else if (nodeType == "IdDefNode") {
			return new IdDefNode();
		} else if (nodeType == "StringNode") {
			return new StringNode();
		} else {
			return null;
		}
	}
}
