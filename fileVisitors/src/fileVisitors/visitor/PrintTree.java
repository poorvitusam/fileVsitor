package fileVisitors.visitor;

import fileVisitors.store.Results;
import fileVisitors.tree.Tree;

public class PrintTree implements VisitorI{
	Results result; 
	
	public PrintTree(Results results) {
		result = results;
	}
	
	public void visit(Tree tree) {
		tree.printNodes(result);
	}
}
