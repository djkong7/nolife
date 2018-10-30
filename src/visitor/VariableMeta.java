package visitor;

public class VariableMeta {
	public String type;
	public String returnType;
	public String minDim;
	public String maxDim;
	public boolean visited;
	
	public VariableMeta() {
		type = "";
		returnType = "";
		minDim = "";
		maxDim = "";
		visited = false;
	}
}
