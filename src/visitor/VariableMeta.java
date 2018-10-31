package visitor;

public class VariableMeta {
	public String type;
	public String returnType;
	public String minDim;
	public String maxDim;
	public boolean visited;
	public int lineNumber;
	public boolean returnStatement;
	public String paramString;
	
	public VariableMeta() {
		type = "";
		returnType = "";
		minDim = "";
		maxDim = "";
		visited = false;
		lineNumber = -1;
		returnStatement = false;
		paramString = "";
	}
}
