package visitor;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Stack;

import ast.*;

public class TypeCheckerVisitor implements Visitor{
	
	private HashMap<String, VariableMeta> symTable = new HashMap<String, VariableMeta>();
	private Stack<HashMap<String, VariableMeta>> symTableStack = new Stack<HashMap<String, VariableMeta>>();
	
	private String globalType;
	
	public TypeCheckerVisitor() {
		//symTable.put("1", new VariableMeta());
		symTableStack.push(symTable);
		globalType = "";
	}
	
	private void updateTypes(String type) {
		for(VariableMeta varMeta : symTable.values()) {
			if(varMeta.type == "") {
				varMeta.type = type;
			}
		}
	}
	
	private void updateArrayTypes(ASTNode arrayNode) {
		for(VariableMeta varMeta : symTable.values()) {
			if(varMeta.type == "") {
				varMeta.type = arrayNode.getLabel();
				varMeta.returnType = arrayNode.getChild(3).getLabel();
				varMeta.minDim = arrayNode.getChild(1).getChild(0).getLabel();
				varMeta.maxDim = arrayNode.getChild(1).getChild(1).getLabel();
			}
		}
	}

	@Override
	public void visit(ASTNode astNode) {
		// TODO Auto-generated method stub
	}

	@Override
	public void visit(ProgramNode programNode) {
		// TODO Auto-generated method stub
		for (ASTNode node : programNode.getChildren()) {
			node.accept(this);
		}
	}

	@Override
	public void visit(DeclNode declNode) {
		for (ASTNode node : declNode.getChildren()) {
			node.accept(this);
		}
	}

	@Override
	public void visit(DeclListNode declListNode) {
		List<ASTNode> children = declListNode.getChildren();
		int length = children.size();
		for (int i = 0; i < length; i += 2) {
			declListNode.getChild(i).accept(this);
			if(declListNode.getChild(i + 1) instanceof ArrayTypeNode) {
				updateArrayTypes(declListNode.getChild(i + 1));
			}else {
				updateTypes(declListNode.getChild(i + 1).getLabel());
			}
		}
	}
	
	@Override
	public void visit(ParamListNode paramListNode) {
		List<ASTNode> children = paramListNode.getChildren();
		int length = children.size();
		for (int i = 0; i < length; i += 2) {
			paramListNode.getChild(i).accept(this);
			if(paramListNode.getChild(i + 1) instanceof ArrayTypeNode) {
				updateArrayTypes(paramListNode.getChild(i + 1));
			}else {
				updateTypes(paramListNode.getChild(i + 1).getLabel());
			}
		}
	}

	@Override
	public void visit(IdListNode idListNode) {
		for (ASTNode node : idListNode.getChildren()) {
			node.accept(this);
		}
	}

	@Override
	public void visit(IdDeclNode idDeclNode) {
		if(symTable.containsKey(idDeclNode.getLabel())){
			System.err.println("ERROR: " + idDeclNode.getLabel() + " declared more than once in the same scope!");
		}else {
			VariableMeta cur = new VariableMeta();
			cur.lineNumber = idDeclNode.getLineNumber();
			symTable.put(idDeclNode.getLabel(), cur);
		}
		
	}

	@Override
	public void visit(IntTypeNode intTypeNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(FloatTypeNode floatTypeNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(CharTypeNode charTypeNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ArrayTypeNode arrayTypeNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(DimNode dimNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(MinDimNode minDimNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(MaxDimNode maxDimNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(CmpStmtNode cmpStmtNode) {
		for (ASTNode node : cmpStmtNode.getChildren()) {
			node.accept(this);
		}
	}

	@Override
	public void visit(StmtListNode stmtListNode) {
		for (ASTNode node : stmtListNode.getChildren()) {
			node.accept(this);
		}
	}

	@Override
	public void visit(AssignmentNode assignmentNode) {
		assignmentNode.getLeft().accept(this);
		String leftType = globalType;
		assignmentNode.getRight().accept(this);
		String rightType = globalType;
		if("CHARACTER" == leftType) {
			if("CHARACTER" != rightType) {
				System.err.println("ERROR ");
			}
				
		} else {
			
		}
	}

	@Override
	public void visit(IdDefNode idDefNode) {
		if(!symTable.containsKey(idDefNode.getLabel())) {
			System.err.println("ERROR: idDefNode " + idDefNode.getLabel() + " referenced but not declared on line " + idDefNode.getLineNumber());
		} else {
			VariableMeta temp = symTable.get(idDefNode.getLabel());
			temp.visited = true;
		}
	}
	
	@Override
	public void visit(IdRefNode idRefNode) {
		//If the reference is in the global table and is a function or procedure
		if(!symTable.containsKey(idRefNode.getLabel())) {
			HashMap<String,VariableMeta> temp = symTableStack.get(0);
			if(temp.containsKey(idRefNode.getLabel()) && !((temp.get(idRefNode.getLabel()).type == "FUNCTION") || (temp.get(idRefNode.getLabel()).type == "PROCEDURE"))) {
				System.err.println("ERROR: idRefNode " + idRefNode.getLabel() + " referenced but not declared on line " + idRefNode.getLineNumber());
			}
		} else {
			symTable.get(idRefNode.getLabel()).visited = true;
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
		for (ASTNode node : orNode.getChildren()) {
			node.accept(this);
		}
	}

	@Override
	public void visit(MulNode mulNode) {
		for (ASTNode node : mulNode.getChildren()) {
			node.accept(this);
		}
	}

	@Override
	public void visit(FactorNode factorNode) {
		for (ASTNode node : factorNode.getChildren()) {
			node.accept(this);
		}
	}

	@Override
	public void visit(BracketNode bracketNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ParenNode parenNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ConstantNode constantNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(NotNode notNode) {
		for (ASTNode node : notNode.getChildren()) {
			node.accept(this);
		}
	}

	

	@Override
	public void visit(AndNode andNode) {
		for (ASTNode node : andNode.getChildren()) {
			node.accept(this);
		}
	}

	@Override
	public void visit(LTNode lTNode) {
		for (ASTNode node : lTNode.getChildren()) {
			node.accept(this);
		}
	}

	@Override
	public void visit(GTNode gTNode) {
		for (ASTNode node : gTNode.getChildren()) {
			node.accept(this);
		}
	}

	@Override
	public void visit(GENode gENode) {
		for (ASTNode node : gENode.getChildren()) {
			node.accept(this);
		}
	}

	@Override
	public void visit(NENode nENode) {
		for (ASTNode node : nENode.getChildren()) {
			node.accept(this);
		}
	}

	@Override
	public void visit(EQNode eQNode) {
		for (ASTNode node : eQNode.getChildren()) {
			node.accept(this);
		}
	}

	@Override
	public void visit(AddNode addNode) {
		for (ASTNode node : addNode.getChildren()) {
			node.accept(this);
		}
	}

	@Override
	public void visit(SubNode subNode) {
		for (ASTNode node : subNode.getChildren()) {
			node.accept(this);
		}
	}

	@Override
	public void visit(ModNode modNode) {
		for (ASTNode node : modNode.getChildren()) {
			node.accept(this);
		}
	}

	@Override
	public void visit(LENode lENode) {
		for (ASTNode node : lENode.getChildren()) {
			node.accept(this);
		}
	}

	@Override
	public void visit(ProcInvNode procInv) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ExpListNode expListNode) {
		for (ASTNode node : expListNode.getChildren()) {
			node.accept(this);
		}
	}

	@Override
	public void visit(RetStmtNode retStmt) {
		for (ASTNode node : retStmt.getChildren()) {
			node.accept(this);
		}
	}

	@Override
	public void visit(SubProgDeclNode subProgDeclNode) {
		for (ASTNode node : subProgDeclNode.getChildren()) {
			node.accept(this);
		}
	}

	@Override
	public void visit(SubProgNode subProgNode) {
		for (ASTNode node : subProgNode.getChildren()) {
			node.accept(this);
		}
		
		HashMap<String, VariableMeta> temp = symTableStack.pop();
		//Check for err after popping
		for(Entry<String, VariableMeta> varMeta : temp.entrySet()) {
			if(!varMeta.getValue().visited) {
				System.err.println("WARNING: " + varMeta.getKey() + " declared but not referenced on line " + varMeta.getValue().lineNumber);
			}
		}
		symTable = symTableStack.peek();
	}

	@Override
	public void visit(SubProgHeadNode subProgHead) {
		//For main symbol table
		VariableMeta funcMeta = new VariableMeta();
		//SubProgTypeNode
		funcMeta.type = subProgHead.getChild(0).getLabel();
		if(funcMeta.type == "FUNCTION") {
			if(subProgHead.getChild(2) instanceof ArgsNode) {
				funcMeta.returnType = subProgHead.getChild(3).getLabel();
			} else {
				funcMeta.returnType = subProgHead.getChild(2).getLabel();
			}
		} else {
			funcMeta.returnType = "VOID";
		}
		funcMeta.visited = true;
		addFunc(subProgHead.getChild(1), funcMeta);
		
		//Push new symbol table onto the stack
		symTable = new HashMap<String, VariableMeta>();
		symTableStack.push(symTable);
		
		funcMeta = new VariableMeta();
		//SubProgTypeNode
		funcMeta.type = subProgHead.getChild(0).getLabel();
		if(funcMeta.type == "FUNCTION") {
			if(subProgHead.getChild(2) instanceof ArgsNode) {
				subProgHead.getChild(2).accept(this);
				funcMeta.returnType = subProgHead.getChild(3).getLabel();
			} else {
				funcMeta.returnType = subProgHead.getChild(2).getLabel();
			}
		} else {
			if(subProgHead.getChildren().size() == 3) {
				subProgHead.getChild(2).accept(this);
			}
		}
		funcMeta.visited = true;
		addFunc(subProgHead.getChild(1), funcMeta);
	}
	
	private void addFunc(ASTNode node, VariableMeta value) {
		String key = node.getLabel();
		if(symTable.containsKey(key)){
			System.err.println("ERROR: " + key + " declared more than once in the same scope on line " + node.getLineNumber());
		}else {
			symTable.put(key,value);
		}
		
	}

	@Override
	public void visit(SubProgTypeNode subProgTypeNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ArgsNode argsNode) {
		for (ASTNode node : argsNode.getChildren()) {
			node.accept(this);
		}
		
	}

	
	
	

	@Override
	public void visit(CaseStmtNode caseStmtNode) {
		for (ASTNode node : caseStmtNode.getChildren()) {
			node.accept(this);
		}
	}

	@Override
	public void visit(CasesNode casesNode) {
		for (ASTNode node : casesNode.getChildren()) {
			node.accept(this);
		}
	}

	@Override
	public void visit(CaseElementNode caseElementNode) {
		for (ASTNode node : caseElementNode.getChildren()) {
			node.accept(this);
		}
	}

	@Override
	public void visit(CaseLabelsNode caseLabelsNode) {
		for (ASTNode node : caseLabelsNode.getChildren()) {
			node.accept(this);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(WriteNode writeNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(StringNode stringNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(IfStmtNode ifStmt) {
		for (ASTNode node : ifStmt.getChildren()) {
			node.accept(this);
		}
	}

	@Override
	public void visit(WhileStmtNode whileStmtNode) {
		for (ASTNode node : whileStmtNode.getChildren()) {
			node.accept(this);
		}
	}

}
