package visitor;

import java.util.ArrayList;
import java.util.List;

import ast.*;

public class SourceVisitor implements Visitor {

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

	// Here to remove errors from unvisited node types
	// Just here during/for development
	@Override
	public void visit(ASTNode astNode) {
		
	}

	/***************** Variable Declarations *******************/
	@Override
	public void visit(ProgramNode programNode) {
		src += "PROGRAM " + programNode.getLabel() + ";\n";
		for (ASTNode node : programNode.getChildren()) {
			node.accept(this);
		}
		//src += "\n";
	}

	@Override
	public void visit(DeclNode declNode) {
		for (ASTNode node : declNode.getChildren()) {
			src += tabStack + "VAR";
			node.accept(this);
		}
	}

	@Override
	public void visit(DeclListNode declListNode) {
		List<ASTNode> children = declListNode.getChildren();
		int length = children.size();
		for (int i = 0; i < length; i += 2) {
			declListNode.getChild(i).accept(this);
			src += " :";
			declListNode.getChild(i + 1).accept(this);
			src += ";\n";
		}

	}

	@Override
	public void visit(IdListNode idListNode) {
		List<ASTNode> children = idListNode.getChildren();
		int length = children.size();
		for (int i = 0; i < length; i++) {
			children.get(i).accept(this);
			if (i != length - 1) {
				src += ",";
			}

		}
	}

	@Override
	public void visit(IdDeclNode idDeclNode) {
		src += " " + idDeclNode.getLabel();
	}

	@Override
	public void visit(IntTypeNode intTypeNode) {
		src += " " + intTypeNode.getLabel();
	}

	@Override
	public void visit(FloatTypeNode floatTypeNode) {
		src += " " + floatTypeNode.getLabel();
	}

	@Override
	public void visit(CharTypeNode charTypeNode) {
		src += " " + charTypeNode.getLabel();
	}

	@Override
	public void visit(ArrayTypeNode arrayTypeNode) {
		src += " " + arrayTypeNode.getLabel();
		arrayTypeNode.getChild(0).accept(this);
		arrayTypeNode.getChild(1).accept(this);
		arrayTypeNode.getChild(2).accept(this);
		src += " OF";
		arrayTypeNode.getChild(3).accept(this);
	}

	@Override
	public void visit(DimNode dimNode) {
		dimNode.getChild(0).accept(this);
		src += " ..";
		dimNode.getChild(1).accept(this);
	}

	@Override
	public void visit(MinDimNode minDimNode) {
		src += " " + minDimNode.getLabel();
	}

	@Override
	public void visit(MaxDimNode maxDimNode) {
		src += " " + maxDimNode.getLabel();
	}

	/***************** Compound Statements *******************/

	@Override
	public void visit(CmpStmtNode cmpStmtNode) {
		src += tabStack + "BEGIN\n";
		tabStack += "\t";
		for (ASTNode node : cmpStmtNode.getChildren()) {
			node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
		src += tabStack + "END";
	}

	@Override
	public void visit(StmtListNode stmtListNode) {
		List<ASTNode> children = stmtListNode.getChildren();
		int length = children.size();
		for (int i = 0; i < length; i++) {
			src += tabStack;
			children.get(i).accept(this);
			if (i != length - 1) {
				src += ";";
			}
			src += "\n";
		}
	}

	@Override
	public void visit(AssignmentNode assignmentNode) {
		assignmentNode.getChild(0).accept(this);
		src += " " + assignmentNode.getLabel();
		assignmentNode.getChild(1).accept(this);
	}

	@Override
	public void visit(IdDefNode idDefNode) {
		src += idDefNode.getLabel();
		for (ASTNode node : idDefNode.getChildren()) {
			node.accept(this);
		}
	}

	@Override
	public void visit(ExpNode expNode) {
		for (ASTNode node : expNode.getChildren()) {
			node.accept(this);
		}
	}

	@Override
	public void visit(OrNode orNode) {
		orNode.getLeft().accept(this);
		src += " " + orNode.getLabel();
		orNode.getRight().accept(this);
	}

	@Override
	public void visit(AndNode andNode) {
		andNode.getLeft().accept(this);
		src += " " + andNode.getLabel();
		andNode.getRight().accept(this);
	}

	@Override
	public void visit(LTNode lTNode) {
		lTNode.getLeft().accept(this);
		src += " " + lTNode.getLabel();
		lTNode.getRight().accept(this);
	}

	@Override
	public void visit(LENode lENode) {
		lENode.getLeft().accept(this);
		src += " " + lENode.getLabel();
		lENode.getRight().accept(this);
	}

	@Override
	public void visit(GTNode gTNode) {
		gTNode.getLeft().accept(this);
		src += " " + gTNode.getLabel();
		gTNode.getRight().accept(this);
	}

	@Override
	public void visit(GENode gENode) {
		gENode.getLeft().accept(this);
		src += " " + gENode.getLabel();
		gENode.getRight().accept(this);
	}

	@Override
	public void visit(NENode nENode) {
		nENode.getLeft().accept(this);
		src += " " + nENode.getLabel();
		nENode.getRight().accept(this);
	}

	@Override
	public void visit(EQNode eQNode) {
		eQNode.getLeft().accept(this);
		src += " " + eQNode.getLabel();
		eQNode.getRight().accept(this);
	}

	@Override
	public void visit(AddNode addNode) {
		addNode.getLeft().accept(this);
		src += " " + addNode.getLabel();
		addNode.getRight().accept(this);
	}

	@Override
	public void visit(SubNode subNode) {
		subNode.getLeft().accept(this);
		src += " " + subNode.getLabel();
		subNode.getRight().accept(this);
	}

	@Override
	public void visit(MulNode mulNode) {
		mulNode.getLeft().accept(this);
		src += " " + mulNode.getLabel();
		mulNode.getRight().accept(this);
	}

	@Override
	public void visit(ModNode modNode) {
		modNode.getLeft().accept(this);
		src += " " + modNode.getLabel();
		modNode.getRight().accept(this);
	}

	@Override
	public void visit(FactorNode factorNode) {
		for (ASTNode node : factorNode.getChildren()) {
			node.accept(this);
		}
	}

	@Override
	public void visit(IdRefNode idRefNode) {
		src += " " + idRefNode.getLabel();
	}

	@Override
	public void visit(BracketNode bracketNode) {
		src += " " + bracketNode.getLabel();
	}

	@Override
	public void visit(ParenNode parenNode) {
		src += " " + parenNode.getLabel();
	}

	@Override
	public void visit(ConstantNode constantNode) {
		src += " " + constantNode.getLabel();
	}

	@Override
	public void visit(NotNode notNode) {
		src += " " + notNode.getLabel();
	}

	@Override
	public void visit(ProcInvNode procInv) {
		for (ASTNode node : procInv.getChildren()) {
			node.accept(this);
		}
	}

	@Override
	public void visit(ExpListNode expListNode) {
		List<ASTNode> children = expListNode.getChildren();
		int length = children.size();
		for (int i = 0; i < length; i++) {
			children.get(i).accept(this);
			if (i != length - 1) {
				src += ",";
			}
		}
	}

	@Override
	public void visit(RetStmtNode retStmt) {
		src += retStmt.getLabel();
		for (ASTNode node : retStmt.getChildren()) {
			node.accept(this);
		}
	}

	@Override
	public void visit(CaseStmtNode caseStmtNode) {
		src += "CASE";
		caseStmtNode.getChild(0).accept(this);
		src += " OF\n";
		if (caseStmtNode.getChildren().size() > 1) {
			tabStack += "\t";
			caseStmtNode.getChild(1).accept(this);
			tabStack = tabStack.substring(0, tabStack.length() - 1);
		}
		src += tabStack + "END";
	}

	@Override
	public void visit(CasesNode casesNode) {
		List<ASTNode> children = casesNode.getChildren();
		int length = children.size();
		for (int i = 0; i < length; i++) {
			src += tabStack;
			children.get(i).accept(this);
			if (i != length - 1) {
				src += ";";
			}
			src += "\n";
		}
	}

	@Override
	public void visit(CaseElementNode caseElementNode) {
		caseElementNode.getChild(0).accept(this);
		src += " :\n";
		tabStack += "\t";
		src += tabStack;
		caseElementNode.getChild(1).accept(this);
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(CaseLabelsNode caseLabelsNode) {
		List<ASTNode> children = caseLabelsNode.getChildren();
		int length = children.size();
		for (int i = 0; i < length; i++) {
			children.get(i).accept(this);
			if (i != length - 1) {
				src += ",";
			}
		}
	}

	@Override
	public void visit(IoStmtNode ioStmtNode) {
		for (ASTNode node : ioStmtNode.getChildren()) {
			node.accept(this);
		}
	}

	@Override
	public void visit(ReadNode readNode) {
		src += readNode.getLabel();
	}

	@Override
	public void visit(WriteNode writeNode) {
		src += writeNode.getLabel();
	}

	@Override
	public void visit(StringNode stringNode) {
		src += " " + stringNode.getLabel();
	}
	
	@Override
	public void visit(IfStmtNode ifStmt) {
		src += "IF";
		ifStmt.getChild(0).accept(this);
		src += " THEN\n";
		tabStack += "\t";
		src += tabStack;
		ifStmt.getChild(1).accept(this);
		src += "\n";
		tabStack = tabStack.substring(0, tabStack.length() - 1);
		if (ifStmt.getChildren().size() == 3) {
			src += tabStack + "ELSE\n";
			tabStack += "\t";
			src += tabStack;
			ifStmt.getChild(2).accept(this);
			tabStack = tabStack.substring(0, tabStack.length() - 1);
		}
	}
	
	@Override
	public void visit(WhileStmtNode whileStmtNode) {
		src += "WHILE";
		whileStmtNode.getChild(0).accept(this);
		src += " DO\n";
		tabStack+="\t";
		whileStmtNode.getChild(1).accept(this);
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	/***************** Subprograms *******************/

	@Override
	public void visit(SubProgDeclNode subProgDeclNode) {
		tabStack += "\t";
		for (ASTNode node : subProgDeclNode.getChildren()) {
			node.accept(this);
			src += ";\n";
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public void visit(SubProgNode subProgNode) {
		for (ASTNode node : subProgNode.getChildren()) {
			node.accept(this);
		}
	}

	@Override
	public void visit(SubProgHeadNode subProgHead) {
		if (subProgHead.getChild(0).getLabel() == "FUNCTION") {
			subProgHead.getChild(0).accept(this);
			subProgHead.getChild(1).accept(this);
			if (subProgHead.getChild(2) instanceof ArgsNode) {
				subProgHead.getChild(2).accept(this);
				src += " :";
				subProgHead.getChild(3).accept(this);
				src += ";\n";
			} else {
				src += " :";
				subProgHead.getChild(2).accept(this);
				src += ";\n";
			}
		} else {
			subProgHead.getChild(0).accept(this);
			subProgHead.getChild(1).accept(this);
			if(subProgHead.getChildren().size() == 3) {
				subProgHead.getChild(2).accept(this);
			}
			src += ";\n";
		}
	}

	@Override
	public void visit(SubProgTypeNode subProgTypeNode) {
		src += subProgTypeNode.getLabel();
	}

	@Override
	public void visit(ArgsNode argsNode) {
		for (ASTNode node : argsNode.getChildren()) {
			node.accept(this);
		}
	}

	@Override
	public void visit(ParamListNode paramListNode) {
		List<ASTNode> children = paramListNode.getChildren();
		int length = children.size();
		for (int i = 0; i < length; i += 2) {
			children.get(i).accept(this);
			src += " :";
			children.get((i + 1)).accept(this);
			if (i != length - 2) {
				src += " ;";
			}
		}
	}

}
