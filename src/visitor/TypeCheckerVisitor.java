package visitor;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Stack;

import ast.*;

public class TypeCheckerVisitor implements Visitor {

	private HashMap<String, VariableMeta> symTable = new HashMap<String, VariableMeta>();
	private Stack<HashMap<String, VariableMeta>> symTableStack = new Stack<HashMap<String, VariableMeta>>();

	private String globalType;

	private String paramString;

	public TypeCheckerVisitor() {
		// symTable.put("1", new VariableMeta());
		symTableStack.push(symTable);
		globalType = "";
		paramString = "";
	}

	private void updateTypes(String type) {
		for (VariableMeta varMeta : symTable.values()) {
			if (varMeta.type == "") {
				varMeta.type = type;
				paramString += type + ",";
			}
		}
	}

	private void updateArrayTypes(ASTNode arrayNode) {
		for (VariableMeta varMeta : symTable.values()) {
			if (varMeta.type == "") {
				varMeta.type = arrayNode.getLabel();
				varMeta.returnType = arrayNode.getChild(3).getLabel();
				varMeta.minDim = arrayNode.getChild(1).getChild(0).getLabel();
				varMeta.maxDim = arrayNode.getChild(1).getChild(1).getLabel();
				paramString += arrayNode.getLabel() + ",";
			}
		}
	}

	@Override
	public void visit(ASTNode astNode) {
		// TODO Auto-generated method stub
	}

	@Override
	public void visit(ProgramNode programNode) {
		for (ASTNode node : programNode.getChildren()) {
			node.accept(this);
		}
		HashMap<String, VariableMeta> temp = symTableStack.pop();
		// Check for err after popping
		for (Entry<String, VariableMeta> varMeta : temp.entrySet()) {
			if (!varMeta.getValue().visited) {
				System.err.println("WARNING: " + varMeta.getKey() + " declared but not referenced on line "
						+ varMeta.getValue().lineNumber);
			}
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
			if (declListNode.getChild(i + 1) instanceof ArrayTypeNode) {
				updateArrayTypes(declListNode.getChild(i + 1));
			} else {
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
			if (paramListNode.getChild(i + 1) instanceof ArrayTypeNode) {
				updateArrayTypes(paramListNode.getChild(i + 1));
			} else {
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
		if (symTable.containsKey(idDeclNode.getLabel())) {
			System.err.println("ERROR: " + idDeclNode.getLabel() + " declared more than once in the same scope on line "
					+ idDeclNode.getLineNumber());
		} else {
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
		if ("CHARACTER" == leftType) {
			if (!("CHARACTER" == rightType || "ANYTYPE" == rightType)) {
				System.err.println("ERROR: cannot assign " + rightType + " to CHARACTER on line "
						+ assignmentNode.getLineNumber());
			}
		} else if (rightType == "NOTYPE") {
			System.err.println("ERROR: cannot assign a procedure on line " + assignmentNode.getLineNumber());
		}
	}

	@Override
	public void visit(IdDefNode idDefNode) {
		if (idDefNode.getChildren().size() > 1) {
			if (idDefNode.getChild(0) instanceof BracketNode) {
				if (symTable.containsKey(idDefNode.getLabel())) {
					symTable.get(idDefNode.getLabel()).visited = true;
					String constLabel = idDefNode.getChild(1).getChild(0).getChild(0).getLabel();
					try {
						// Number indexed?
						int index = Integer.parseInt(constLabel);
						VariableMeta meta = symTable.get(idDefNode.getLabel());
						try {
							int maxi = Integer.parseInt(meta.maxDim);
							int mini = Integer.parseInt(meta.minDim);
							if (index < mini || maxi < index) {
								System.err.println("ERROR: ARRAY " + idDefNode.getLabel()
										+ " index out of bounds on line " + idDefNode.getLineNumber());
								globalType = "ANYTYPE";
							} else {
								globalType = meta.returnType;
							}
						} catch (NumberFormatException f) {
							System.err.println("ERROR: wrong ARRAY " + idDefNode.getLabel() + " index type on line "
									+ idDefNode.getLineNumber());
							globalType = "ANYTYPE";
						}
					} catch (NumberFormatException e) {
						// Char indexed?

						VariableMeta meta = symTable.get(idDefNode.getLabel());
						try {
							int maxi = Integer.parseInt(meta.maxDim);
							int mini = Integer.parseInt(meta.minDim);
							System.err.println("ERROR: wrong ARRAY " + idDefNode.getLabel() + " index type on line "
									+ idDefNode.getLineNumber());
							globalType = "ANYTYPE";
						} catch (NumberFormatException f) {
							if (constLabel.compareTo(meta.minDim) < 0 || meta.maxDim.compareTo(constLabel) < 0) {
								System.err.println("ERROR: ARRAY " + idDefNode.getLabel()
										+ " index out of bounds on line " + idDefNode.getLineNumber());
								globalType = "ANYTYPE";
							} else {
								globalType = meta.returnType;
							}
						}
					}
				} else {
					System.err.println("ERROR: ARRAY " + idDefNode.getLabel() + " referenced but not declared on line "
							+ idDefNode.getLineNumber());
					globalType = "ANYTYPE";
				}
			}
		} else {
			if (symTable.containsKey(idDefNode.getLabel())) {
				VariableMeta temp = symTable.get(idDefNode.getLabel());
				temp.visited = true;
				if (temp.type == "FUNCTION" || temp.type == "PROCEDURE") {
					System.err.println(
							"ERROR: cannot assign to a FUNCTION or PROCEDURE on line " + idDefNode.getLineNumber());
					globalType = "ANYTYPE";
				} else {
					globalType = temp.type;
				}
			} else {
				System.err.println("ERROR: idDefNode " + idDefNode.getLabel() + " referenced but not declared on line "
						+ idDefNode.getLineNumber());
				globalType = "ANYTYPE";
			}
		}
	}

	@Override
	public void visit(IdRefNode idRefNode) {
		if (symTable.containsKey(idRefNode.getLabel())) {
			if (symTable.get(idRefNode.getLabel()).type == "FUNCTION"
					|| symTable.get(idRefNode.getLabel()).type == "PROCEDURE") {
				symTable.get(idRefNode.getLabel()).visited = true;
				globalType = symTable.get(idRefNode.getLabel()).returnType;
			} else {
				symTable.get(idRefNode.getLabel()).visited = true;
				globalType = symTable.get(idRefNode.getLabel()).type;
			}
		} else {
			// If the reference is in the global table and is a function or procedure or
			// doesn't contain it
			HashMap<String, VariableMeta> temp = symTableStack.get(0);
			if ((temp.containsKey(idRefNode.getLabel()) && !((temp.get(idRefNode.getLabel()).type == "FUNCTION")
					|| (temp.get(idRefNode.getLabel()).type == "PROCEDURE")))
					|| !temp.containsKey(idRefNode.getLabel())) {
				System.err.println("ERROR: idRefNode " + idRefNode.getLabel() + " referenced but not declared on line "
						+ idRefNode.getLineNumber());
				globalType = "ANYTYPE";
			} else if (temp.containsKey(idRefNode.getLabel()) && ((temp.get(idRefNode.getLabel()).type == "FUNCTION")
					|| (temp.get(idRefNode.getLabel()).type == "PROCEDURE"))) {
				globalType = temp.get(idRefNode.getLabel()).returnType;
			}
		}
	}

	@Override
	public void visit(ExpNode expNode) {
		for (ASTNode node : expNode.getChildren()) {
			node.accept(this);
		}
		paramString += globalType + ",";
	}

	@Override
	public void visit(MulNode mulNode) {
		mulNode.getLeft().accept(this);
		String leftType = globalType;
		mulNode.getRight().accept(this);
		String rightType = globalType;
		if (leftType == "CHARACTER" || rightType == "CHARACTER") {
			System.err.println("ERROR: cannot multiply by a charcter on line " + mulNode.getLineNumber());
			globalType = "ANYTYPE";
		} else if (leftType == "NOTYPE" && rightType == "NOTYPE") {
			System.err.println("ERROR: left side of multiplication; procedure has no return type on line "
					+ mulNode.getLineNumber());
			System.err.println("ERROR: right side of multiplication; procedure has no return type on line "
					+ mulNode.getLineNumber());
			globalType = "ANYTYPE";
		} else if (leftType == "NOTYPE") {
			System.err.println("ERROR: left side of multiplication; procedure has no return type on line "
					+ mulNode.getLineNumber());
			globalType = rightType;
		} else if (rightType == "NOTYPE") {
			System.err.println("ERROR: right side of multiplication; procedure has no return type on line "
					+ mulNode.getLineNumber());
			globalType = leftType;
		} else if (leftType == "ANYTYPE") {
			globalType = rightType;
		} else if (rightType == "ANYTYPE") {
			globalType = leftType;
			// This catches mismatched inputs
		} else if ((leftType == "FLOAT" && rightType == "INTEGER") || (leftType == "INTEGER" && rightType == "FLOAT")) {
			globalType = "FLOAT";
		} else {
			globalType = leftType;
		}
	}

	@Override
	public void visit(FactorNode factorNode) {
		if (factorNode.getChild(0) instanceof NotNode) {
			factorNode.getChild(1).accept(this);
			factorNode.getChild(0).accept(this);
		} else if (factorNode.getChildren().size() >= 2 && factorNode.getChild(1) instanceof ParenNode) {
			// Visit children to build call structure
			// System.out.println("Saved paramString: " + paramString);
			String paramStringSave = paramString;
			paramString = "";
			factorNode.getChild(2).accept(this);
			if (paramString.length() > 1) {
				paramString = paramString.substring(0, paramString.length() - 1);
			}
			// System.out.println("New paramString: " + paramString);
			// Do paramChecking after this
			if (symTable.containsKey(factorNode.getChild(0).getLabel())) {
				if (0 != paramString.compareTo(symTable.get(factorNode.getChild(0).getLabel()).paramString)) {
					System.err.println("ERROR: incorrect parameter types or incorrect number of parameters to FUNCTION "
							+ factorNode.getChild(0).getLabel() + " on line " + factorNode.getChild(0).getLineNumber());
				}
			}
			// ParamChecking before this
			paramString = paramStringSave;
			// Here for proper type checking.Leave at end
			factorNode.getChild(0).accept(this);
		} else if (factorNode.getChildren().size() > 1 && factorNode.getChild(1) instanceof BracketNode) {
			// Arrays
			if (symTable.containsKey(factorNode.getChild(0).getLabel()) && symTable.get(factorNode.getChild(0).getLabel()).type == "ARRAY") {
				symTable.get(factorNode.getChild(0).getLabel()).visited = true;
				String constLabel = factorNode.getChild(2).getChild(0).getChild(0).getLabel();
				try {
					// Number indexed?
					int index = Integer.parseInt(constLabel);
					VariableMeta meta = symTable.get(factorNode.getChild(0).getLabel());
					try {
						int maxi = Integer.parseInt(meta.maxDim);
						int mini = Integer.parseInt(meta.minDim);
						if (index < mini || maxi < index) {
							System.err.println("ERROR: ARRAY " + factorNode.getChild(0).getLabel()
									+ " index out of bounds on line " + factorNode.getChild(0).getLineNumber());
							globalType = "ANYTYPE";
						} else {
							globalType = meta.returnType;
						}
					} catch (NumberFormatException f) {
						System.err.println("ERROR: wrong ARRAY " + factorNode.getChild(0).getLabel()
								+ " index type on line " + factorNode.getChild(0).getLineNumber());
						globalType = "ANYTYPE";
					}
				} catch (NumberFormatException e) {
					// Char indexed?

					VariableMeta meta = symTable.get(factorNode.getChild(0).getLabel());
					try {
						int maxi = Integer.parseInt(meta.maxDim);
						int mini = Integer.parseInt(meta.minDim);
						System.err.println("ERROR: wrong ARRAY " + factorNode.getChild(0).getLabel()
								+ " index type on line " + factorNode.getChild(0).getLineNumber());
						globalType = "ANYTYPE";
					} catch (NumberFormatException f) {
						if (constLabel.compareTo(meta.minDim) < 0 || meta.maxDim.compareTo(constLabel) < 0) {
							System.err.println("ERROR: ARRAY " + factorNode.getChild(0).getLabel()
									+ " index out of bounds on line " + factorNode.getChild(0).getLineNumber());
							globalType = "ANYTYPE";
						} else {
							globalType = meta.returnType;
						}
					}
				}
			} else {
				System.err.println("ERROR: variable " + factorNode.getChild(0).getLabel() + " isn't an array or isn't declared on line " + factorNode.getChild(0).getLineNumber());
			}
		} else {
			for (ASTNode node : factorNode.getChildren()) {
				node.accept(this);
			}

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
		int temp1;
		float temp2;
		try {
			temp1 = Integer.parseInt(constantNode.getLabel());
			globalType = "INTEGER";
		} catch (NumberFormatException e) {
			try {
				temp2 = Float.parseFloat(constantNode.getLabel());
				globalType = "FLOAT";
			} catch (NumberFormatException f) {
				globalType = "CHARACTER";
			}
		}

	}

	@Override
	public void visit(NotNode notNode) {
		// Commented because of special case for not's.
		// Case is in visit(FactorNode)
		// notNode.getChild(0).accept(this);
		String type = globalType;
		if (type != "INTEGER") {
			System.err.println(
					"ERROR: NOT is only defined on INTEGERS, not " + type + " on line " + notNode.getLineNumber());
			globalType = "ANYTYPE";
		}
	}

	@Override
	public void visit(AndNode andNode) {
		andNode.getLeft().accept(this);
		String leftType = globalType;
		andNode.getRight().accept(this);
		String rightType = globalType;
		if (leftType != "INTEGER" && rightType != "INTEGER") {
			System.err.println("ERROR: left side of AND; AND is only defined on INTEGERS, not " + leftType
					+ "S on line " + andNode.getLineNumber());
			System.err.println("ERROR: right side of AND; AND is only defined on INTEGERS, not " + rightType
					+ "S on line " + andNode.getLineNumber());
			globalType = "ANYTYPE";
		} else if (leftType != "INTEGER") {
			System.err.println("ERROR: left side of AND; AND is only defined on INTEGERS, not " + leftType
					+ "S on line " + andNode.getLineNumber());
			globalType = rightType;
		} else if (rightType != "INTEGER") {
			System.err.println("ERROR: right side of AND; AND is only defined on INTEGERS, not " + rightType
					+ "S on line " + andNode.getLineNumber());
			globalType = leftType;
		}
	}

	@Override
	public void visit(OrNode orNode) {
		orNode.getLeft().accept(this);
		String leftType = globalType;
		orNode.getRight().accept(this);
		String rightType = globalType;
		if (leftType != "INTEGER" && rightType != "INTEGER") {
			System.err.println("ERROR: left side of OR; OR is only defined on INTEGERS, not " + leftType + "S on line "
					+ orNode.getLineNumber());
			System.err.println("ERROR: right side of OR; OR is only defined on INTEGERS, not " + rightType
					+ "S on line " + orNode.getLineNumber());
			globalType = "ANYTYPE";
		} else if (leftType != "INTEGER") {
			System.err.println("ERROR: left side of OR; OR is only defined on INTEGERS, not " + leftType + "S on line "
					+ orNode.getLineNumber());
			globalType = rightType;
		} else if (rightType != "INTEGER") {
			System.err.println("ERROR: right side of OR; OR is only defined on INTEGERS, not " + rightType
					+ "S on line " + orNode.getLineNumber());
			globalType = leftType;
		}
	}

	@Override
	public void visit(ModNode modNode) {
		modNode.getLeft().accept(this);
		String leftType = globalType;
		modNode.getRight().accept(this);
		String rightType = globalType;
		if (leftType != "INTEGER" && rightType != "INTEGER") {
			System.err.println("ERROR: left side of MOD; MOD is only defined on INTEGERS, not " + leftType
					+ "S on line " + modNode.getLineNumber());
			System.err.println("ERROR: right side of MOD; MOD is only defined on INTEGERS, not " + rightType
					+ "S on line " + modNode.getLineNumber());
			globalType = "ANYTYPE";
		} else if (leftType != "INTEGER") {
			System.err.println("ERROR: left side of MOD; MOD is only defined on INTEGERS, not " + leftType
					+ "S on line " + modNode.getLineNumber());
			globalType = rightType;
		} else if (rightType != "INTEGER") {
			System.err.println("ERROR: right side of MOD; MOD is only defined on INTEGERS, not " + rightType
					+ "S on line " + modNode.getLineNumber());
			globalType = leftType;
		}
	}

	@Override
	public void visit(LTNode lTNode) {
		comparisonCheck(lTNode);
	}

	@Override
	public void visit(LENode lENode) {
		comparisonCheck(lENode);
	}

	@Override
	public void visit(GTNode gTNode) {
		comparisonCheck(gTNode);
	}

	@Override
	public void visit(GENode gENode) {
		comparisonCheck(gENode);
	}

	@Override
	public void visit(NENode nENode) {
		comparisonCheck(nENode);
	}

	@Override
	public void visit(EQNode eQNode) {
		comparisonCheck(eQNode);
	}

	private void comparisonCheck(BinaryNode binNode) {
		binNode.getLeft().accept(this);
		String leftType = globalType;
		binNode.getRight().accept(this);
		String rightType = globalType;
		if (leftType == "CHARACTER" && rightType == "INTEGER") {
			System.err.println("ERROR: cannot compare CHARACTER and INTEGER on line " + binNode.getLineNumber());
		} else if (leftType == "CHARACTER" && rightType == "FLOAT") {
			System.err.println("ERROR: cannot compare CHARACTER and FLOAT on line " + binNode.getLineNumber());
		} else if (leftType == "INTEGER" && rightType == "CHARACTER") {
			System.err.println("ERROR: cannot compare INTEGER and CHARACTER on line " + binNode.getLineNumber());
		} else if (leftType == "FLOAT" && rightType == "CHARACTER") {
			System.err.println("ERROR: cannot compare FLOAT and CHARACTER on line " + binNode.getLineNumber());
		} else if (leftType == "NOTYPE") {
			System.err.println(
					"ERROR: left side of comparison; PROCEDURE has no return type on line " + binNode.getLineNumber());
		} else if (rightType == "NOTYPE") {
			System.err.println(
					"ERROR: right side of comparison; PROCEDURE has no return type on line " + binNode.getLineNumber());
		}
		globalType = "INTEGER";
	}

	@Override
	public void visit(AddNode addNode) {
		addNode.getLeft().accept(this);
		String leftType = globalType;
		addNode.getRight().accept(this);
		String rightType = globalType;
		if (leftType == "CHARACTER" || rightType == "CHARACTER") {
			System.err.println("ERROR: cannot add a charcter on line " + addNode.getLineNumber());
			globalType = "ANYTYPE";
		} else if (leftType == "NOTYPE" && rightType == "NOTYPE") {
			System.err.println(
					"ERROR: left side of addition; procedure has no return type on line " + addNode.getLineNumber());
			System.err.println(
					"ERROR: right side of addition; procedure has no return type on line " + addNode.getLineNumber());
			globalType = "ANYTYPE";
		} else if (leftType == "NOTYPE") {
			System.err.println(
					"ERROR: left side of addition; procedure has no return type on line " + addNode.getLineNumber());
			globalType = rightType;
		} else if (rightType == "NOTYPE") {
			System.err.println(
					"ERROR: right side of addition; procedure has no return type on line " + addNode.getLineNumber());
			globalType = leftType;
		} else if (leftType == "ANYTYPE") {
			globalType = rightType;
		} else if (rightType == "ANYTYPE") {
			globalType = leftType;
			// This catches mismatched inputs
		} else if ((leftType == "FLOAT" && rightType == "INTEGER") || (leftType == "INTEGER" && rightType == "FLOAT")) {
			globalType = "FLOAT";
		} else {
			globalType = leftType;
		}
	}

	@Override
	public void visit(SubNode subNode) {
		subNode.getLeft().accept(this);
		String leftType = globalType;
		subNode.getRight().accept(this);
		String rightType = globalType;
		if (leftType == "CHARACTER" || rightType == "CHARACTER") {
			System.err.println("ERROR: cannot subtract a charcter on line " + subNode.getLineNumber());
			globalType = "ANYTYPE";
		} else if (leftType == "NOTYPE" && rightType == "NOTYPE") {
			System.err.println(
					"ERROR: left side of subtraction; procedure has no return type on line " + subNode.getLineNumber());
			System.err.println("ERROR: right side of subtraction; procedure has no return type on line "
					+ subNode.getLineNumber());
			globalType = "ANYTYPE";
		} else if (leftType == "NOTYPE") {
			System.err.println(
					"ERROR: left side of subtraction; procedure has no return type on line " + subNode.getLineNumber());
			globalType = rightType;
		} else if (rightType == "NOTYPE") {
			System.err.println("ERROR: right side of subtraction; procedure has no return type on line "
					+ subNode.getLineNumber());
			globalType = leftType;
		} else if (leftType == "ANYTYPE") {
			globalType = rightType;
		} else if (rightType == "ANYTYPE") {
			globalType = leftType;
			// This catches mismatched inputs
		} else if ((leftType == "FLOAT" && rightType == "INTEGER") || (leftType == "INTEGER" && rightType == "FLOAT")) {
			globalType = "FLOAT";
		} else {
			globalType = leftType;
		}
	}

	@Override
	public void visit(ProcInvNode procInv) {

		if (procInv.getChild(2) instanceof ExpListNode) {
			// String paramStringSave = paramString;
			paramString = "";
			procInv.getChild(2).accept(this);
			if (paramString.length() > 1) {
				paramString = paramString.substring(0, paramString.length() - 1);
			}
			//System.out.println("New paramString: " + paramString);
			// Do paramChecking after this
			if (symTable.containsKey(procInv.getChild(0).getLabel())) {
				if (0 != paramString.compareTo(symTable.get(procInv.getChild(0).getLabel()).paramString)) {
					System.err.println("ERROR: incorrect parameter types or incorrect number of parameters to FUNCTION "
							+ procInv.getChild(0).getLabel() + " on line " + procInv.getChild(0).getLineNumber());
				}
			}
			// ParamChecking before this
			paramString = "";// paramStringSave;
		}
		ASTNode ref = procInv.getChild(0);
		if (symTable.containsKey(ref.getLabel())) {
			VariableMeta meta = symTable.get(ref.getLabel());
			if (meta.type == "FUNCTION") {
				System.err.println("ERROR: calling function " + ref.getLabel() + " like a procedure on line "
						+ ref.getLineNumber());
			} else if (meta.type != "PROCEDURE") {
				System.err.println("ERROR: " + meta.type + " " + ref.getLabel() + " is not callable on line "
						+ ref.getLineNumber());
			}
		} else {
			System.err.println("ERROR: procedure call " + ref.getLabel() + " referenced but not defined on line "
					+ ref.getLineNumber());
		}
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
		for (Entry<String, VariableMeta> varMeta : symTable.entrySet()) {
			if (varMeta.getValue().type == "FUNCTION") {
				varMeta.getValue().returnStatement = true;
				if (varMeta.getValue().returnType != globalType) {
					System.err.println("ERROR: " + globalType + " type of return does not match "
							+ varMeta.getValue().returnType + " return type of FUNCTION " + varMeta.getKey()
							+ " on line " + retStmt.getLineNumber());
				}
			} else if (varMeta.getValue().type == "PROCEDURE") {
				System.err.println("ERROR: PROCEDURE " + varMeta.getKey() + " contains a RETURN statement on line "
						+ retStmt.getLineNumber());
			}
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
		// Check for err after popping
		for (Entry<String, VariableMeta> varMeta : temp.entrySet()) {
			if (!varMeta.getValue().visited) {
				System.err.println("WARNING: " + varMeta.getKey() + " declared but not referenced on line "
						+ varMeta.getValue().lineNumber);
			} else if (varMeta.getValue().type == "FUNCTION" && !varMeta.getValue().returnStatement) {
				System.err.println("ERROR: FUNCTION " + varMeta.getKey() + " contains no return statement on line "
						+ varMeta.getValue().lineNumber);
			}
		}
		symTable = symTableStack.peek();
	}

	@Override
	public void visit(SubProgHeadNode subProgHead) {
		// For main symbol table
		VariableMeta funcMeta = new VariableMeta();
		// SubProgTypeNode
		funcMeta.type = subProgHead.getChild(0).getLabel();
		funcMeta.lineNumber = subProgHead.getLineNumber();
		if (funcMeta.type == "FUNCTION") {
			if (subProgHead.getChild(2) instanceof ArgsNode) {
				funcMeta.returnType = subProgHead.getChild(3).getLabel();
			} else {
				funcMeta.returnType = subProgHead.getChild(2).getLabel();
			}
		} else {
			funcMeta.returnType = "NOTYPE";
		}
		funcMeta.visited = true;

		addFunc(subProgHead.getChild(1), funcMeta);

		paramString = "";

		// Push new symbol table onto the stack
		symTable = new HashMap<String, VariableMeta>();
		symTableStack.push(symTable);

		funcMeta = new VariableMeta();
		// SubProgTypeNode
		funcMeta.type = subProgHead.getChild(0).getLabel();
		funcMeta.lineNumber = subProgHead.getLineNumber();
		if (funcMeta.type == "FUNCTION") {
			if (subProgHead.getChild(2) instanceof ArgsNode) {
				subProgHead.getChild(2).accept(this);
				funcMeta.returnType = subProgHead.getChild(3).getLabel();
			} else {
				funcMeta.returnType = subProgHead.getChild(2).getLabel();
			}
		} else {
			if (subProgHead.getChildren().size() == 3) {
				subProgHead.getChild(2).accept(this);
			}
		}
		funcMeta.visited = true;

		// Remove last "," at the end of the parameter string
		if (paramString.length() > 1) {
			paramString = paramString.substring(0, paramString.length() - 1);
		}
		// System.out.println("ParamString: " + paramString);
		// Set the global symtable function entry's paramstring.
		symTableStack.get(0).get(subProgHead.getChild(1).getLabel()).paramString = paramString;
		// Set current symtable function paramstring
		funcMeta.paramString = paramString;
		addFunc(subProgHead.getChild(1), funcMeta);
		paramString = "";
	}

	private void addFunc(ASTNode node, VariableMeta value) {
		String key = node.getLabel();
		if (symTable.containsKey(key)) {
			System.err.println(
					"ERROR: " + key + " declared more than once in the same scope on line " + node.getLineNumber());
		} else {
			symTable.put(key, value);
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
		for (ASTNode node : readNode.getChildren()) {
			node.accept(this);
		}
	}

	@Override
	public void visit(WriteNode writeNode) {
		for (ASTNode node : writeNode.getChildren()) {
			node.accept(this);
		}
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
