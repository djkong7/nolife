package visitor;

import ast.*;

public class PrintVisitor implements Visitor{
	
	private String src;
	private String tabStack;
	
	public PrintVisitor() {
		super();
		src = "";
		tabStack = "";
	}
	
	public String getSrc() {
		return src;
	}
	
	// Here to remove errors from unvisited node types
	// Just here during/for development
	public void visit(ASTNode astNode) {
		src += tabStack + astNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : astNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(ProgramNode programNode) {
		// TODO Auto-generated method stub
		src += tabStack + programNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : programNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(DeclNode declNode) {
		// TODO Auto-generated method stub
		src += tabStack + declNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : declNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(DeclListNode declListNode) {
		// TODO Auto-generated method stub
		src += tabStack + declListNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : declListNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(IdListNode idListNode) {
		// TODO Auto-generated method stub
		src += tabStack + idListNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : idListNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(IdDeclNode idDeclNode) {
		// TODO Auto-generated method stub
		src += tabStack + idDeclNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : idDeclNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(IntTypeNode intTypeNode) {
		// TODO Auto-generated method stub
		src += tabStack + intTypeNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : intTypeNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(FloatTypeNode floatTypeNode) {
		// TODO Auto-generated method stub
		src += tabStack + floatTypeNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : floatTypeNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(CharTypeNode charTypeNode) {
		// TODO Auto-generated method stub
		src += tabStack + charTypeNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : charTypeNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(ArrayTypeNode arrayTypeNode) {
		// TODO Auto-generated method stub
		src += tabStack + arrayTypeNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : arrayTypeNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(DimNode dimNode) {
		// TODO Auto-generated method stub
		src += tabStack + dimNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : dimNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(MinDimNode minDimNode) {
		// TODO Auto-generated method stub
		src += tabStack + minDimNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : minDimNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(MaxDimNode maxDimNode) {
		// TODO Auto-generated method stub
		src += tabStack + maxDimNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : maxDimNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(CmpStmtNode cmpStmtNode) {
		// TODO Auto-generated method stub
		src += tabStack + cmpStmtNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : cmpStmtNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(StmtListNode stmtListNode) {
		// TODO Auto-generated method stub
		src += tabStack + stmtListNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : stmtListNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(AssignmentNode assignmentNode) {
		// TODO Auto-generated method stub
		src += tabStack + assignmentNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : assignmentNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(IdDefNode idDefNode) {
		// TODO Auto-generated method stub
		src += tabStack + idDefNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : idDefNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(ExpNode expNode) {
		// TODO Auto-generated method stub
		src += tabStack + expNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : expNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(OrNode orNode) {
		// TODO Auto-generated method stub
		src += tabStack + orNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : orNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(MulNode mulNode) {
		// TODO Auto-generated method stub
		src += tabStack + mulNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : mulNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(FactorNode factorNode) {
		// TODO Auto-generated method stub
		src += tabStack + factorNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : factorNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(BracketNode bracketNode) {
		// TODO Auto-generated method stub
		src += tabStack + bracketNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : bracketNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(ParenNode parenNode) {
		// TODO Auto-generated method stub
		src += tabStack + parenNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : parenNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(ConstantNode constantNode) {
		// TODO Auto-generated method stub
		src += tabStack + constantNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : constantNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(NotNode notNode) {
		// TODO Auto-generated method stub
		src += tabStack + notNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : notNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(IdRefNode idRefNode) {
		// TODO Auto-generated method stub
		src += tabStack + idRefNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : idRefNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(AndNode andNode) {
		// TODO Auto-generated method stub
		src += tabStack + andNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : andNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(LTNode lTNode) {
		// TODO Auto-generated method stub
		src += tabStack + lTNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : lTNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(GTNode gTNode) {
		// TODO Auto-generated method stub
		src += tabStack + gTNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : gTNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(GENode gENode) {
		// TODO Auto-generated method stub
		src += tabStack + gENode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : gENode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(NENode nENode) {
		// TODO Auto-generated method stub
		src += tabStack + nENode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : nENode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(EQNode eQNode) {
		// TODO Auto-generated method stub
		src += tabStack + eQNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : eQNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(AddNode addNode) {
		// TODO Auto-generated method stub
		src += tabStack + addNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : addNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(SubNode subNode) {
		// TODO Auto-generated method stub
		src += tabStack + subNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : subNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(ModNode modNode) {
		// TODO Auto-generated method stub
		src += tabStack + modNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : modNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(LENode lENode) {
		// TODO Auto-generated method stub
		src += tabStack + lENode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : lENode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(ProcInvNode procInvNode) {
		// TODO Auto-generated method stub
		src += tabStack + procInvNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : procInvNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(ExpListNode expListNode) {
		// TODO Auto-generated method stub
		src += tabStack + expListNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : expListNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(RetStmtNode retStmtNode) {
		// TODO Auto-generated method stub
		src += tabStack + retStmtNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : retStmtNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(SubProgDeclNode subProgDeclNode) {
		// TODO Auto-generated method stub
		src += tabStack + subProgDeclNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : subProgDeclNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(SubProgNode subProgNode) {
		// TODO Auto-generated method stub
		src += tabStack + subProgNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : subProgNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(SubProgHeadNode subProgHead) {
		// TODO Auto-generated method stub
		src += tabStack + subProgHead.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : subProgHead.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(SubProgTypeNode subProgTypeNode) {
		// TODO Auto-generated method stub
		src += tabStack + subProgTypeNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : subProgTypeNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(ArgsNode argsNode) {
		// TODO Auto-generated method stub
		src += tabStack + argsNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : argsNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(ParamListNode paramListNode) {
		// TODO Auto-generated method stub
		src += tabStack + paramListNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : paramListNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(CaseStmtNode caseStmtNode) {
		// TODO Auto-generated method stub
		src += tabStack + caseStmtNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : caseStmtNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(CasesNode casesNode) {
		// TODO Auto-generated method stub
		src += tabStack + casesNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : casesNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(CaseElementNode caseElementNode) {
		// TODO Auto-generated method stub
		src += tabStack + caseElementNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : caseElementNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(CaseLabelsNode caseLabelsNode) {
		// TODO Auto-generated method stub
		src += tabStack + caseLabelsNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : caseLabelsNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(IoStmtNode ioStmtNode) {
		// TODO Auto-generated method stub
		src += tabStack + ioStmtNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : ioStmtNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(ReadNode readNode) {
		// TODO Auto-generated method stub
		src += tabStack + readNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : readNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(WriteNode writeNode) {
		// TODO Auto-generated method stub
		src += tabStack + writeNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : writeNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(StringNode stringNode) {
		// TODO Auto-generated method stub
		src += tabStack + stringNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : stringNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(IfStmtNode ifStmt) {
		// TODO Auto-generated method stub
		src += tabStack + ifStmt.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : ifStmt.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(WhileStmtNode whileStmtNode) {
		// TODO Auto-generated method stub
		src += tabStack + whileStmtNode.getClass().getSimpleName() + "\n";
		tabStack += "\t";
		for (ASTNode node : whileStmtNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}
}
