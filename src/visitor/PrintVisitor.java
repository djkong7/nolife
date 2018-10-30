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
	
	private void addToSrc(ASTNode astNode){
		src += tabStack + astNode.getClass().getSimpleName()+ ": " + astNode.getLabel() + ": " +astNode.getLineNumber() + "\n";
		tabStack += "\t";
		for (ASTNode node : astNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}
	
	// Here to remove errors from unvisited node types
	// Just here during/for development
	public void visit(ASTNode astNode) {
		addToSrc(astNode);
	}

	@Override
	public void visit(ProgramNode programNode) {
		// TODO Auto-generated method stub
		addToSrc(programNode);
	}

	@Override
	public void visit(DeclNode declNode) {
		// TODO Auto-generated method stub
		addToSrc(declNode);
	}

	@Override
	public void visit(DeclListNode declListNode) {
		// TODO Auto-generated method stub
		addToSrc(declListNode);
	}

	@Override
	public void visit(IdListNode idListNode) {
		// TODO Auto-generated method stub
		addToSrc(idListNode);
	}

	@Override
	public void visit(IdDeclNode idDeclNode) {
		// TODO Auto-generated method stub
		addToSrc(idDeclNode);
	}

	@Override
	public void visit(IntTypeNode intTypeNode) {
		// TODO Auto-generated method stub
		addToSrc(intTypeNode);
	}

	@Override
	public void visit(FloatTypeNode floatTypeNode) {
		// TODO Auto-generated method stub
		addToSrc(floatTypeNode);
	}

	@Override
	public void visit(CharTypeNode charTypeNode) {
		// TODO Auto-generated method stub
		addToSrc(charTypeNode);
	}

	@Override
	public void visit(ArrayTypeNode arrayTypeNode) {
		// TODO Auto-generated method stub
		addToSrc(arrayTypeNode);
	}

	@Override
	public void visit(DimNode dimNode) {
		// TODO Auto-generated method stub
		addToSrc(dimNode);
	}

	@Override
	public void visit(MinDimNode minDimNode) {
		// TODO Auto-generated method stub
		addToSrc(minDimNode);
	}

	@Override
	public void visit(MaxDimNode maxDimNode) {
		// TODO Auto-generated method stub
		addToSrc(maxDimNode);
	}

	@Override
	public void visit(CmpStmtNode cmpStmtNode) {
		// TODO Auto-generated method stub
		addToSrc(cmpStmtNode);
	}

	@Override
	public void visit(StmtListNode stmtListNode) {
		// TODO Auto-generated method stub
		addToSrc(stmtListNode);
	}

	@Override
	public void visit(AssignmentNode assignmentNode) {
		// TODO Auto-generated method stub
		addToSrc(assignmentNode);
	}

	@Override
	public void visit(IdDefNode idDefNode) {
		// TODO Auto-generated method stub
		addToSrc(idDefNode);
	}

	@Override
	public void visit(ExpNode expNode) {
		// TODO Auto-generated method stub
		addToSrc(expNode);
	}

	@Override
	public void visit(OrNode orNode) {
		// TODO Auto-generated method stub
		addToSrc(orNode);
	}

	@Override
	public void visit(MulNode mulNode) {
		// TODO Auto-generated method stub
		addToSrc(mulNode);
	}

	@Override
	public void visit(FactorNode factorNode) {
		// TODO Auto-generated method stub
		addToSrc(factorNode);
	}

	@Override
	public void visit(BracketNode bracketNode) {
		// TODO Auto-generated method stub
		addToSrc(bracketNode);
	}

	@Override
	public void visit(ParenNode parenNode) {
		// TODO Auto-generated method stub
		addToSrc(parenNode);
	}

	@Override
	public void visit(ConstantNode constantNode) {
		// TODO Auto-generated method stub
		addToSrc(constantNode);
	}

	@Override
	public void visit(NotNode notNode) {
		// TODO Auto-generated method stub
		addToSrc(notNode);
	}

	@Override
	public void visit(IdRefNode idRefNode) {
		// TODO Auto-generated method stub
		addToSrc(idRefNode);
	}

	@Override
	public void visit(AndNode andNode) {
		// TODO Auto-generated method stub
		addToSrc(andNode);
	}

	@Override
	public void visit(LTNode lTNode) {
		// TODO Auto-generated method stub
		addToSrc(lTNode);
	}

	@Override
	public void visit(GTNode gTNode) {
		// TODO Auto-generated method stub
		addToSrc(gTNode);
	}

	@Override
	public void visit(GENode gENode) {
		// TODO Auto-generated method stub
		addToSrc(gENode);
	}

	@Override
	public void visit(NENode nENode) {
		// TODO Auto-generated method stub
		addToSrc(nENode);
	}

	@Override
	public void visit(EQNode eQNode) {
		// TODO Auto-generated method stub
		addToSrc(eQNode);
	}

	@Override
	public void visit(AddNode addNode) {
		// TODO Auto-generated method stub
		addToSrc(addNode);
	}

	@Override
	public void visit(SubNode subNode) {
		// TODO Auto-generated method stub
		addToSrc(subNode);
	}

	@Override
	public void visit(ModNode modNode) {
		// TODO Auto-generated method stub
		addToSrc(modNode);
	}

	@Override
	public void visit(LENode lENode) {
		// TODO Auto-generated method stub
		addToSrc(lENode);
	}

	@Override
	public void visit(ProcInvNode procInv) {
		// TODO Auto-generated method stub
		addToSrc(procInv);
	}

	@Override
	public void visit(ExpListNode expListNode) {
		// TODO Auto-generated method stub
		addToSrc(expListNode);
	}

	@Override
	public void visit(RetStmtNode retStmt) {
		// TODO Auto-generated method stub
		addToSrc(retStmt);
	}

	@Override
	public void visit(SubProgDeclNode subProgDeclNode) {
		// TODO Auto-generated method stub
		addToSrc(subProgDeclNode);
	}

	@Override
	public void visit(SubProgNode subProgNode) {
		// TODO Auto-generated method stub
		addToSrc(subProgNode);
	}

	@Override
	public void visit(SubProgHeadNode subProgHead) {
		// TODO Auto-generated method stub
		addToSrc(subProgHead);
	}

	@Override
	public void visit(SubProgTypeNode subProgTypeNode) {
		// TODO Auto-generated method stub
		addToSrc(subProgTypeNode);
	}

	@Override
	public void visit(ArgsNode argsNode) {
		// TODO Auto-generated method stub
		addToSrc(argsNode);
	}

	@Override
	public void visit(ParamListNode paramListNode) {
		// TODO Auto-generated method stub
		addToSrc(paramListNode);
	}

	@Override
	public void visit(CaseStmtNode caseStmtNode) {
		// TODO Auto-generated method stub
		addToSrc(caseStmtNode);
	}

	@Override
	public void visit(CasesNode casesNode) {
		// TODO Auto-generated method stub
		addToSrc(casesNode);
	}

	@Override
	public void visit(CaseElementNode caseElementNode) {
		// TODO Auto-generated method stub
		addToSrc(caseElementNode);
	}

	@Override
	public void visit(CaseLabelsNode caseLabelsNode) {
		// TODO Auto-generated method stub
		addToSrc(caseLabelsNode);
	}

	@Override
	public void visit(IoStmtNode ioStmtNode) {
		// TODO Auto-generated method stub
		addToSrc(ioStmtNode);
	}

	@Override
	public void visit(ReadNode readNode) {
		// TODO Auto-generated method stub
		addToSrc(readNode);
	}

	@Override
	public void visit(WriteNode writeNode) {
		// TODO Auto-generated method stub
		addToSrc(writeNode);
	}

	@Override
	public void visit(StringNode stringNode) {
		// TODO Auto-generated method stub
		addToSrc(stringNode);
	}

	@Override
	public void visit(IfStmtNode ifStmt) {
		// TODO Auto-generated method stub
		addToSrc(ifStmt);
	}

	@Override
	public void visit(WhileStmtNode whileStmtNode) {
		// TODO Auto-generated method stub
		addToSrc(whileStmtNode);
	}
}
